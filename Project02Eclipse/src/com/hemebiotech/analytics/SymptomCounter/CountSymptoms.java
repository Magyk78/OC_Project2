package com.hemebiotech.analytics.SymptomCounter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * count symptom all occurences of symptoms from a data sources
 * 
 * @Since 23/03/2022
 * @Version 1.0
 * @Author Antoine
 *
 */
public class CountSymptoms implements ISymptomCounter {

	private List<String> symptomList;

	/**
	 * Class Constructor
	 * 
	 * @param symptomList - a list do symptoms
	 */
	public CountSymptoms(List<String> symptomList) {

		this.symptomList = symptomList;
	}

	/*
	 * Returns a sorted map of symptoms (value) & number of occurences
	 * 
	 * @return result - list of symptoms
	 */
	@Override
	public TreeMap<String, Long> getResult() {

		TreeMap<String, Long> sortedSympstoms = null;

		if (symptomList != null) {

			// Put in a Map Symptom (Key) & number of occurences (Value)
			Map<String, Long> symptomsCounter = symptomList.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			// Use TreeMap to sort by key
			sortedSympstoms = new TreeMap<String, Long>(symptomsCounter);

			sortedSympstoms.forEach((k, v) -> System.out.println(("testTreeMap -> " + k + "=" + v)));
		}

		return sortedSympstoms;
	}

}
