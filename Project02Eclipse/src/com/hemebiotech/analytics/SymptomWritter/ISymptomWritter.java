package com.hemebiotech.analytics.SymptomWritter;

import java.io.IOException;
import java.util.TreeMap;

/**
 * Anything that will write a map in a file
 * 
 */
public interface ISymptomWritter {

	/**
	 * Write a text file from a Tree Map of symptoms
	 * 
	 * @param symptomResult a map sorted alphabetically of symptom name and number
	 *                      of symptom
	 * @throws IOException if stream to file cannot be written to or closed.
	 */
	void writeResultOut(TreeMap<String, Long> symptomResult) throws IOException;

}
