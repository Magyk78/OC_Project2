package com.hemebiotech.analytics;

import com.hemebiotech.analytics.symptom_counter.CountSymptoms;
import com.hemebiotech.analytics.symptom_counter.ISymptomCounter;
import com.hemebiotech.analytics.symptom_reader.ISymptomReader;
import com.hemebiotech.analytics.symptom_reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.symptom_writter.ISymptomWritter;
import com.hemebiotech.analytics.symptom_writter.WriteSymptomResultToFile;

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
