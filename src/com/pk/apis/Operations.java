package com.pk.apis;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.pk.db.GlobalData;
import com.pk.diasease.Disease;
import com.pk.people.People;
import com.pk.region.Country;
import com.pk.region.District;
import com.pk.region.Region;
import com.pk.region.State;

public class Operations {

	private void incrementWorldActiveCases(String disName) {
		if(GlobalData.diseaseList.containsKey(disName)) {
			GlobalData.diseaseList.get(disName).changeGlobalActiveCases(GlobalData.incremnt);
		}else {
			Disease disease = new Disease(disName);
			disease.changeGlobalActiveCases(GlobalData.incremnt);
			GlobalData.diseaseList.put(disName, disease);
		}
	}
	
	private void decrementWorldActiveCases(String disName) {
		if(GlobalData.diseaseList.containsKey(disName)) {
			GlobalData.diseaseList.get(disName).changeGlobalActiveCases(GlobalData.decriment);
		}
	}
	
	private void incrementWorldTotalCases(String disName) {
		if(GlobalData.diseaseList.containsKey(disName)) {
			GlobalData.diseaseList.get(disName).changeGlobalTotalCases(GlobalData.incremnt);
		}else {
			Disease disease = new Disease(disName);
			disease.changeGlobalTotalCases(GlobalData.incremnt);
			GlobalData.diseaseList.put(disName, disease);
		}
	}
	
	private void decrementtWorldTotalCases(String disName) {
		if(GlobalData.diseaseList.containsKey(disName)) {
			GlobalData.diseaseList.get(disName).changeGlobalTotalCases(GlobalData.decriment);
		}
	}
	
	private void incrementWorldCured(String disName) {
		if(GlobalData.diseaseList.containsKey(disName)) {
			GlobalData.diseaseList.get(disName).changeGlobalCuredCases(GlobalData.incremnt);
		}else {
			Disease disease = new Disease(disName);
			disease.changeGlobalCuredCases(GlobalData.incremnt);
			GlobalData.diseaseList.put(disName, disease);
		}
	}
	
	private void decrementCuredlCases(String disName) {
		if(GlobalData.diseaseList.containsKey(disName)) {
			GlobalData.diseaseList.get(disName).changeGlobalCuredCases(GlobalData.decriment);
		}
	}
	
	private void incrementWorldFatalityCases(String disName) {
		if(GlobalData.diseaseList.containsKey(disName)) {
			GlobalData.diseaseList.get(disName).changeGlobalFatalityCases(GlobalData.incremnt);
		}else {
			Disease disease = new Disease(disName);
			disease.changeGlobalFatalityCases(GlobalData.incremnt);
			GlobalData.diseaseList.put(disName, disease);
		}
	}
	
	private void decrementFatalityCases(String disName) {
		if(GlobalData.diseaseList.containsKey(disName)) {
			GlobalData.diseaseList.get(disName).changeGlobalFatalityCases(GlobalData.decriment);
		}
	}

	private void incrementRegionLevelDiseaseCount(Region regionObj, Map region, String regionName, String disease) {
		Region currRegionObj;
		if (region.containsKey(regionName)) {
			currRegionObj = (Region) region.get(regionName);
			currRegionObj.incrementDiseaseCount(disease);
		} else {
			currRegionObj = regionObj;
			currRegionObj.incrementDiseaseCount(disease);
		}
		region.put(regionName, currRegionObj);
	}

	private void derementRegionevelDiseaseCount(Map region, String regionName, String disease) {
		Region currRegionObj = null;
		if (region.containsKey(regionName)) {
			currRegionObj = (Region) region.get(regionName);
			currRegionObj.decrementDiseaseCount(disease);
			region.put(regionName, currRegionObj);
		}
	}

	public void report(String disease, String patient_id, String Country, String state, String district) {
		if (GlobalData.people.containsKey(patient_id)) {
			People patient = GlobalData.people.get(patient_id);
			Map<String, Integer> disList = patient.getDisease();
			disList.put(disease, 1);
			patient.setDisease(disList);
			GlobalData.people.put(patient_id, patient);
		} else {
			People patient = new People(patient_id, disease, Country, state, district);
			Map<String, Integer> disList = new HashMap<String, Integer>();
			disList.put(disease, 1);
			patient.setDisease(disList);
			GlobalData.people.put(patient_id, patient);
			GlobalData.total++;
		}
		
		
		incrementWorldTotalCases(disease);
		incrementWorldActiveCases(disease);
		Region countryObj = new Country(Country);
		Region stateObj = new State(state);
		Region distObj = new District(district);

		incrementRegionLevelDiseaseCount(countryObj, GlobalData.cntrs, Country, disease);
		incrementRegionLevelDiseaseCount(stateObj, GlobalData.states, state, disease);
		incrementRegionLevelDiseaseCount(distObj, GlobalData.districts, district, disease);

	}

	private void changeGlobalDiseaseCases(Map caseType, String disease, int changeCount) {
		int count = (int) caseType.get(disease);
		count = count + changeCount;
		if (count < 0) {
			count = 0;
		}
		caseType.put(disease, count);
	}

	public void cured(String disease, String patient_id) {

		GlobalData.cured++;
		GlobalData.active--;

		changeGlobalDiseaseCases(GlobalData.activeCases, disease, GlobalData.decriment);
		changeGlobalDiseaseCases(GlobalData.curedCases, disease, GlobalData.incremnt);

		People patient = GlobalData.people.get(patient_id);
		
		decrementCuredlCases(disease);

		derementRegionevelDiseaseCount(GlobalData.cntrs, patient.getCountry(), disease);
		derementRegionevelDiseaseCount(GlobalData.states, patient.getState(), disease);
		derementRegionevelDiseaseCount(GlobalData.districts, patient.getDistrict(), disease);
	}

	public void fatality(String disease, String patient_id) {

		GlobalData.people.get(patient_id).setAlive(false);

		People patient = GlobalData.people.get(patient_id);

		GlobalData.active--;
		GlobalData.fatality++;
		
		incrementWorldFatalityCases(disease);
		decrementWorldActiveCases(disease);

		derementRegionevelDiseaseCount(GlobalData.cntrs, patient.getCountry(), disease);
		derementRegionevelDiseaseCount(GlobalData.states, patient.getState(), disease);
		derementRegionevelDiseaseCount(GlobalData.districts, patient.getDistrict(), disease);
		
//		incrementRegionaleveCount(GlobalData.cntrs, patient.getCountry(), disease);
//		derementRegionevelDiseaseCount(GlobalData.states, patient.getState(), disease);
//		derementRegionevelDiseaseCount(GlobalData.districts, patient.getDistrict(), disease);
	}

	public void showWorldLevelSummary() {
		System.out.println("Total     :: " + GlobalData.total);
		System.out.println("Cured     :: " + GlobalData.cured);
		System.out.println("Fatality  :: " + GlobalData.fatality);
		System.out.println("Active    :: " + GlobalData.active);
	}

	public void showDiseaseWiseWorldSummary() {
		for (Map.Entry<String, Disease> entry : GlobalData.diseaseList.entrySet()) {
				System.out.println(entry.getKey() + " :::");
				System.out.println("Total cases    ::: " + entry.getValue().getTotalCases());
				System.out.println("Cured cases    ::: " + entry.getValue().getCuredCases());
				System.out.println("Active cases   ::: " + entry.getValue().getActiveCases());
				System.out.println("Fatality cases ::: " + entry.getValue().getFatalityCases());
				System.out.println("____________________________________________________________");
		}
	}
	
	public void showCountryBreakup(String disease) {
		for(Map.Entry<String, Country> entry: GlobalData.cntrs.entrySet()) {
			System.out.println(entry.getKey() + ":");
			System.out.println("Total :: " + entry.getValue().getDiseaseCount().get(disease));
			System.out.println("Cured :: " + entry.getValue().getCuredCases().get(disease));
			System.out.println("Active :: " + entry.getValue().getActiveCases().get(disease));
			System.out.println("Fatality :: " + entry.getValue().getFatalityCases().get(disease));
			System.out.println("________________________________________________________________");
		}
	}
	
	
	public void showStateBreakupDiseaseWise(String disease) {
		for(Map.Entry<String, State> entry: GlobalData.states.entrySet()) {
			System.out.println(entry.getKey() + ":");
			System.out.println("Total :: " + entry.getValue().getDiseaseCount().get(disease));
			System.out.println("Cured :: " + entry.getValue().getCuredCases().get(disease));
			System.out.println("Active :: " + entry.getValue().getActiveCases().get(disease));
			System.out.println("Fatality :: " + entry.getValue().getFatalityCases().get(disease));
			System.out.println("________________________________________________________________");
		}
	}
	
	public void showDistrictBreakupDiseaseWise(String disease) {
		for(Map.Entry<String, District> entry: GlobalData.districts.entrySet()) {
			System.out.println(entry.getKey() + ":");
			System.out.println("Total :: " + entry.getValue().getDiseaseCount().get(disease));
			System.out.println("Cured :: " + entry.getValue().getCuredCases().get(disease));
			System.out.println("Active :: " + entry.getValue().getActiveCases().get(disease));
			System.out.println("Fatality :: " + entry.getValue().getFatalityCases().get(disease));
			System.out.println("________________________________________________________________");
		}
	}
}
