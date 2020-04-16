package com.pk.region;

import java.util.HashMap;
import java.util.Map;

import com.pk.people.People;

public class District implements Region{
	String name;
	Map<String, People> patients;
	int size;
	Map<String, Integer> diseaseCount;
	Map<String, Integer> activeCases;
	Map<String, Integer> curedCases;
	Map<String, Integer> fatalityCases;
	
	

	public District(String district) {
		this.name =district;
		this.patients = new HashMap<String, People>();
		this.diseaseCount = new HashMap<String, Integer>();
		this.activeCases = new HashMap<String, Integer>();
		this.curedCases = new HashMap<String, Integer>();
		this.fatalityCases = new HashMap<String, Integer>();
		this.size = 0;
	}


	public String getName() {
		return name;
	}
	
	@Override
	public void incrementDiseaseCount(String disID) {
		if(this.diseaseCount.containsKey(disID)) {
			int count = this.diseaseCount.get(disID);
			count++;
			this.diseaseCount.put(disID, count);
		}else {
			this.diseaseCount.put(disID, 1);
		}
	}
	
	public Map<String, Integer> getDiseaseCount() {
		return diseaseCount;
	}


	public void setDiseaseCount(Map<String, Integer> diseaseCount) {
		this.diseaseCount = diseaseCount;
	}


	public Map<String, Integer> getActiveCases() {
		return activeCases;
	}


	public void setActiveCases(Map<String, Integer> activeCases) {
		this.activeCases = activeCases;
	}


	public Map<String, Integer> getCuredCases() {
		return curedCases;
	}


	public void setCuredCases(Map<String, Integer> curedCases) {
		this.curedCases = curedCases;
	}


	public Map<String, Integer> getFatalityCases() {
		return fatalityCases;
	}


	public void setFatalityCases(Map<String, Integer> fatalityCases) {
		this.fatalityCases = fatalityCases;
	}


	public void decrementDiseaseCount(String disID) {
		if(this.diseaseCount.containsKey(disID)) {
			int count = this.diseaseCount.get(disID);
			count--;
			this.diseaseCount.put(disID, count);
		}
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Map<String, People> getPatients() {
		return patients;
	}


	public void setPatients(Map<String, People> patients) {
		this.patients = patients;
	}



	
	
	
}
