package com.hemebiotech.analytics;

import com.hemebiotech.analytics.SymptomCounter.CountSymptoms;
import com.hemebiotech.analytics.SymptomCounter.ISymptomCounter;
import com.hemebiotech.analytics.SymptomReader.ISymptomReader;
import com.hemebiotech.analytics.SymptomReader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.SymptomWritter.ISymptomWritter;
import com.hemebiotech.analytics.SymptomWritter.WriteSymptomResultToFile;

/*
 * Analyze a brute text file of symptom containing duplicate and return file including symptom & number of symptom occurences
 * 
 * @Since 23/03/2022
 * @Version 1.0
 * @Author Antoine
 */
public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		final String INPUT_FILE = "symptoms.txt";
		final String OUTPUT_FILE = "result.out";

		ISymptomReader reader = new ReadSymptomDataFromFile(INPUT_FILE);

		ISymptomCounter counter = new CountSymptoms(reader.getSymptoms());

		ISymptomWritter writer = new WriteSymptomResultToFile(OUTPUT_FILE, counter.getResult());

		writer.writeResultOut();

	}
}
