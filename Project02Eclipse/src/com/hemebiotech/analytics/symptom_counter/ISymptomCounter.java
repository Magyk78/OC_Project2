package com.hemebiotech.analytics.symptom_counter;

import java.util.TreeMap;

/**
 * count symptom all occurences of symptoms from a data source
 */
public interface ISymptomCounter {

	/**
	 * Return a sorted Map of symptoms (value) and number of occurences
	 * 
	 * @return a sorted map of symptoms
	 */
	TreeMap<String, Long> getResult();

}
