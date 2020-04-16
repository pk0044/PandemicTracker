package com.pk.diasease;

import java.util.Map;

public class Disease {
	String name;
	int totalCases;
	int curedCases;
	int fatalityCases;
	int activeCases;
	
	public void changeGlobalActiveCases(int changeCount) {
		this.activeCases = this.activeCases + changeCount;
		if (this.activeCases < 0) {
			this.activeCases = 0;
		}
	}
	
	public void changeGlobalCuredCases(int changeCount) {
		this.curedCases = this.curedCases + changeCount;
		if (this.curedCases < 0) {
			this.curedCases = 0;
		}
	}
	
	public void changeGlobalFatalityCases(int changeCount) {
		this.fatalityCases = this.fatalityCases + changeCount;
		if (this.fatalityCases < 0) {
			this.fatalityCases = 0;
		}
	}
	
	public void changeGlobalTotalCases(int changeCount) {
		this.totalCases = this.totalCases + changeCount;
		if (this.totalCases < 0) {
			this.totalCases = 0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}

	public int getCuredCases() {
		return curedCases;
	}

	public void setCuredCases(int curedCases) {
		this.curedCases = curedCases;
	}

	public int getFatalityCases() {
		return fatalityCases;
	}

	public void setFatalityCases(int fatalityCases) {
		this.fatalityCases = fatalityCases;
	}

	public Disease(String name) {
		this.name = name;
		this.totalCases = 0;
		this.curedCases = 0;
		this.fatalityCases = 0;
		this.activeCases = 0;
	}

	public int getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(int activeCases) {
		this.activeCases = activeCases;
	}
	
	
	
}
