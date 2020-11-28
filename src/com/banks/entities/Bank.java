package com.banks.entities;

public class Bank {
	
	private int id;
	private int compensationCode;
	private String institutionName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCompensationCode() {
		return compensationCode;
	}
	
	public void setCompensationCode(int compensationCode) {
		this.compensationCode = compensationCode;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}
	
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
}
