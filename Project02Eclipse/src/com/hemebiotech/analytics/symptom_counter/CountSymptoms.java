package com.hemebiotech.analytics.SymptomCounter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Count all occurences of symptoms from a data sources
 * 
 * @author Antoine
 * @version 1.0
 * @since 23/03/2022
 */
public class CountSymptoms implements ISymptomCounter {

	private List<String> symptomList;

	/**
	 * Class Constructor
	 * 
	 * @param symptomList - a list do symptoms
	 * @throws NullPointerException	if symptomList is null
	 */
	public CountSymptoms(List<String> symptomList) {

		this.symptomList = symptomList;
		
		if (symptomList == null)
			throw new NullPointerException();
		
	}

	/**
	 * Returns a sorted map of symptoms (value) and number of occurences
	 * 
	 * @return result - list of symptoms
	 */
	@Override
	public TreeMap<String, Long> getResult() {

		// Put in a Map Symptom (Key) & number of occurences (Value)
		Map<String, Long> symptomsCounter = symptomList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		// Use TreeMap to sort by key 
		TreeMap<String, Long>sortedSympstoms = new TreeMap<String, Long>(symptomsCounter);

		return sortedSympstoms;
	}

}
