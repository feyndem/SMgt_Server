package org.mperezcastell.SMgtServer.service.repository;

public enum EatingStatus {
	NO(1), SOME(2), CANTEAT(3);
	
	private int code;
	
	private EatingStatus (int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public static EatingStatus getStatus(int code){
		for (EatingStatus stat : EatingStatus.values()) {
			if (stat.getCode()==code) return stat;
		}
		return null; // not found: invalid code
	}
}