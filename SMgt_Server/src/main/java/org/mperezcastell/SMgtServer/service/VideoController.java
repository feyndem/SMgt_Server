/*
 * 
 * Copyright 2014 Jules White
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.mperezcastell.SMgtServer.service;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.mperezcastell.SMgtServer.service.repository.Patient;
import org.mperezcastell.SMgtServer.service.repository.PatientRepository;
import org.mperezcastell.SMgtServer.service.repository.Video;
import org.mperezcastell.SMgtServer.service.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

@Controller
public class VideoController {
	
	@Autowired
	private VideoRepository videos;
	
	@RequestMapping(value = "/video", method = RequestMethod.GET)
	public @ResponseBody Collection<Video> getVideoList () {
		return Lists.newArrayList(videos.findAll());		
	}

	@RequestMapping(value = "/video", method = RequestMethod.POST)
	public @ResponseBody Video addVideo (@RequestBody Video v) {
		return videos.save(v);		
	}
	@Autowired
	PatientRepository patients;
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public @ResponseBody String getClient (Principal principal, OAuth2Authentication auth) {
		Collection<GrantedAuthority> authorities = ((OAuth2Authentication) auth).getAuthorities();
		String client = ((OAuth2Authentication) auth).getOAuth2Request().getClientId();
		Collection<Patient> pac = (Collection<Patient>) patients.findAll();
		String patientsList = "";
		for (Patient patient : pac) {
			patientsList = patientsList + patient.getPatient();
		}
		return principal.getName() + authorities + client + patientsList;
	}
	
	@RequestMapping(value = "/video/{id}", method = RequestMethod.GET)
	public @ResponseBody Video getVideo(@PathVariable long id, HttpServletResponse response) {
		Video video = videos.findOne(id);
		if (video == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);	
			return video;
		} else {
			return video;
		}
	}
	
	@RequestMapping(value ="/video/search/findByName", method = RequestMethod.GET)
	public @ResponseBody Collection<Video> findByTitle (@RequestParam("title") String title) {
		
		Collection<Video> listVideos = videos.findByName(title);
		if (listVideos == null) {
			return Collections.emptyList();
		} else {
			return listVideos;
		}
	}
	
	@RequestMapping(value ="/video/search/findByDurationLessThan", method = RequestMethod.GET)
	public @ResponseBody Collection<Video> findByDurationLessThan (@RequestParam("duration") long duration) {
		
		Collection<Video> listVideos = videos.findByDurationLessThan(duration);
		if (listVideos == null) {
			return Collections.emptyList();
		} else {
			return listVideos;
		}
	}
	
}
