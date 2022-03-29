package com.hemebiotech.analytics;

import com.hemebiotech.analytics.SymptomCounter.CountSymptoms;
import com.hemebiotech.analytics.SymptomCounter.ISymptomCounter;
import com.hemebiotech.analytics.SymptomReader.ISymptomReader;
import com.hemebiotech.analytics.SymptomReader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.SymptomWritter.ISymptomWritter;
import com.hemebiotech.analytics.SymptomWritter.WriteSymptomResultToFile;

/**
 * Analyze a brute text file of symptom containing duplicate and return file
 * including symptom and number of symptom occurences
 * 
 * @author Antoine
 * @version 1.0
 * @since 23/03/2022
 */
public class AnalyticsCounter {

	final static String INPUT_FILE = "symptoms.txt";
	final static String OUTPUT_FILE = "result.out";

	/**
	 * Main Method
	 * 
	 * @param args Unused
	 * @throws Exception Generic Exception
	 */
	public static void main(String args[]) throws Exception {

		ISymptomReader reader = new ReadSymptomDataFromFile(INPUT_FILE);

		ISymptomCounter counter = new CountSymptoms(reader.getSymptoms());

		ISymptomWritter writer = new WriteSymptomResultToFile(OUTPUT_FILE);

		writer.writeResultOut(counter.getResult());

	}
}
