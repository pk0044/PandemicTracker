package com.pk.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.pk.apis.Operations;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		String[] inputs; 
		Operations ops = new Operations();
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		String input;
		// String disease, String patient_id, String Country, String state, String district
		while(sc.hasNextLine()) {
			input = sc.nextLine();
			inputs = input.split(" ");
			//System.out.println(inputs[0] + " " + inputs[1] + " " + inputs[2] + " " + inputs[3] + " " + inputs[4] + " " + inputs[5]);
			ops.report(inputs[1], inputs[2], inputs[3], inputs[4], inputs[5]);
			
			//ops.showDiseaseWorldSummary();
		}
		
//		ops.showWorldLevelSummary();
		ops.showDiseaseWiseWorldSummary();
//		ops.showCountryBreakup("COVID-19");
//		ops.showDistrictBreakupDiseaseWise("COVID-19");
//		ops.showStateBreakupDiseaseWise("COVID-19");
		
	}

}
