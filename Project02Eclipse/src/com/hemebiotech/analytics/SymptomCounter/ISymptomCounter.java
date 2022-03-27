package com.hemebiotech.analytics.SymptomCounter;

import java.util.TreeMap;

/**
 * count symptom all occurences of symptoms from a data source
 */
public interface ISymptomCounter {

	/**
	 * Return a sorted Map of symptoms (value) & number of occurences
	 * 
	 * @return a sorted map of symptoms
	 */
	TreeMap<String, Long> getResult();

}
