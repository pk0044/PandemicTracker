package com.pk.region;

import java.util.HashMap;
import java.util.Map;

public class State implements Region{
	String name;
	District[] districts;
	Map<String, Integer> diseaseCount;
	Map<String, Integer> activeCases;
	Map<String, Integer> curedCases;
	Map<String, Integer> fatalityCases;
	
	public State(String name) {
		super();
		this.name = name;
		this.districts = districts;
		this.diseaseCount = new HashMap<String, Integer>();
		this.activeCases = new HashMap<String, Integer>();
		this.curedCases = new HashMap<String, Integer>();
		this.fatalityCases = new HashMap<String, Integer>();

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District[] getDistricts() {
		return districts;
	}

	public void setDistricts(District[] districts) {
		this.districts = districts;
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
	
	@Override
	public void decrementDiseaseCount(String disID) {
		if(this.diseaseCount.containsKey(disID)) {
			int count = this.diseaseCount.get(disID);
			count--;
			if(count < 0) {
				count = 0;
			}
			this.diseaseCount.put(disID, count);
		}
	}
	
}
