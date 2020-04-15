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
		while(sc.hasNextLine()) {
			input = sc.nextLine();
			inputs = input.split(" ");
			ops.report(inputs[1], inputs[2], inputs[3], inputs[4], inputs[5]);
			
			//ops.showDiseaseWorldSummary();
		}
		
		ops.showWorldLevelSummary();
		ops.showDiseaseWiseWorldSummary();
		
	}

}
