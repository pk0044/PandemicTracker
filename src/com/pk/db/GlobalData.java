package com.pk.db;

import java.util.HashMap;
import java.util.Map;

import com.pk.diasease.Disease;
import com.pk.people.People;
import com.pk.region.Country;
import com.pk.region.District;
import com.pk.region.State;

public class GlobalData {
	
	public static int decriment = -1;
	public static int incremnt = 1;
	
	public static int total = 0;
	public static int cured = 0;	
	public static int fatality = 0;
	public static int active = 0;
	
	public static Map<String, People> people = new HashMap<String, People>();
	public static Map<String, Country> cntrs = new HashMap<String, Country>();
	public static Map<String, State> states = new HashMap<String, State>();
	public static Map<String, District> districts = new HashMap<String, District>();
	public static Map<String, Disease> diseaseList = new HashMap<String, Disease>();
	
	public static Map<String, Integer> diseaseCount = new HashMap<String, Integer>();
	public static Map<String, Integer> activeCases = new HashMap<String, Integer>();
	public static Map<String, Integer> curedCases = new HashMap<String, Integer>();
	public static Map<String, Integer> fatalityCases = new HashMap<String, Integer>();
}
