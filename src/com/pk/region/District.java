package com.pk.region;

import java.util.HashMap;
import java.util.Map;

import com.pk.people.People;

public class District implements Region{
	String name;
	Map<String, People> patients;
	int size;
	Map<String, Integer> diaseaseCount;
	
	

	public District(String district) {
		this.name =district;
		this.patients = new HashMap<String, People>();
		this.diaseaseCount = new HashMap<String, Integer>();
		this.size = 0;
	}


	public String getName() {
		return name;
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
