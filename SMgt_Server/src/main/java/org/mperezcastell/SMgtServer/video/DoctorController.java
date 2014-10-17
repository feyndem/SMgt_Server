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

package org.mperezcastell.SMgtServer.video;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mperezcastell.SMgtServer.video.repository.Doctor;
import org.mperezcastell.SMgtServer.video.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctors;
	
	@RequestMapping(value = "/doctors/{doctorid}/patients", method = RequestMethod.GET)
	public @ResponseBody Doctor getPatientsList (@PathVariable String doctorid, HttpServletResponse response) {
		List<Doctor> doctorCollection = doctors.findByDoctor(doctorid);
		Doctor doctor = doctorCollection.get(0);
		return doctor;				
//		if (doctorCollection != null) {
//			Collection<Patient> patientsList = null;
//			for (Doctor doctor : doctorCollection) {
//				patientsList =  doctor.getPatients();
//			}			
//			return patientsList;
//		} else {
//			response.setStatus(HttpServletResponse.SC_NOT_FOUND);	
//			return null;
//		}
	}
	
}
