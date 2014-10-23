package org.mperezcastell.SMgtServer.service.repository;

public enum PainLevels {
	CONTROLLED(1), MODERATE(2), SEVERE(3);
	
	private int code;
	
	private PainLevels (int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public static PainLevels getStatus(int code){
		for (PainLevels stat : PainLevels.values()) {
			if (stat.getCode()==code) return stat;
		}
		return null; // not found: invalid code
	}
}