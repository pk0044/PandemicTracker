package com.pk.region;

import java.util.HashMap;
import java.util.Map;

public class State implements Region{
	String name;
	District[] districts;
	Map<String, Integer> diaseaseCount;
	
	public State(String name) {
		super();
		this.name = name;
		this.districts = districts;
		this.diaseaseCount = new HashMap<String, Integer>();
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
		if(this.diaseaseCount.containsKey(disID)) {
			int count = this.diaseaseCount.get(disID);
			count++;
			this.diaseaseCount.put(disID, count);
		}else {
			this.diaseaseCount.put(disID, 1);
		}
	}
	
	@Override
	public void decrementDiseaseCount(String disID) {
		if(this.diaseaseCount.containsKey(disID)) {
			int count = this.diaseaseCount.get(disID);
			count--;
			if(count < 0) {
				count = 0;
			}
			this.diaseaseCount.put(disID, count);
		}
	}
	
}
