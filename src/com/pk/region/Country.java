package com.pk.region;

import java.util.HashMap;
import java.util.Map;

public class Country implements Region{

	String name;
	State[] states;
	Map<String, Integer> diaseaseCount;
	
	public Country(String names) {
		this.name = name;
		this.states = new State[20];
		this.diaseaseCount = new HashMap<String, Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State[] getStates() {
		return states;
	}

	public void setStates(State[] states) {
		this.states = states;
	}
	
	@Override
	public void incrementDiseaseCount(String disID) {
		if(this.diaseaseCount.containsKey(disID)) {
			int count = this.diaseaseCount.get(disID);
			count++;
			this.diaseaseCount.put(disID, count);
		}else {
			this.diaseaseCount.put(disID, 1);
		}
	}
	
	public void decrementDiseaseCount(String disID) {
		if(this.diaseaseCount.containsKey(disID)) {
			int count = this.diaseaseCount.get(disID);
			count--;
			this.diaseaseCount.put(disID, count);
		}
	}
	
	
}
