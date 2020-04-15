package com.pk.people;

import java.util.HashMap;
import java.util.Map;

public class People {

	String patient_id;
	Map<String, Integer> disease;
	String country;
	String state;
	String district;
	Boolean alive;
	
	
	public Boolean getAlive() {
		return alive;
	}


	public void setAlive(Boolean alive) {
		this.alive = alive;
	}


	public People(String patient_id, String disease, String country, String state, String district) {
		super();
		this.patient_id = patient_id;
		this.disease = new HashMap<String, Integer>();
		this.country = country;
		this.state = state;
		this.district = district;
		this.alive = true;
	}


	public String getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Map<String, Integer> getDisease() {
		return disease;
	}


	public void setDisease(Map<String, Integer> disease) {
		this.disease = disease;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	
	
}
