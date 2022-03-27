package com.hemebiotech.analytics.SymptomWritter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/*
 * Contains method to write the symptoms in a file
 * 
 * @Since 23/03/2022
 * @Version 1.0
 * @Author Antoine
 * 
 */
public class WriteSymptomResultToFile implements ISymptomWritter {

	private String filepath;

	private TreeMap<String, Long> symptomResult;

	/**
	 * Class Constructor
	 * 
	 * @param filepath      - a full or partial path to file with symptom strings in
	 *                      it
	 * @param symptomResult - a map sorted alphabetically of symptom name & number
	 */

	public WriteSymptomResultToFile(String filepath, TreeMap<String, Long> symptomResult) {

		this.filepath = filepath;
		this.symptomResult = symptomResult;
	}

	/*
	 * Write a text file from a Tree Map of symptoms
	 * 
	 */
	@Override
	public void writeResultOut() {

		if ((symptomResult != null) && (filepath != null)) {

			try {

				BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
							
				symptomResult.forEach((k, v) -> {
					try {
						//Write in the text file
						writer.write(k + "=" + v.toString() + System.lineSeparator());
						System.out.println(k + "=" + v);

					} catch (IOException e) {

						e.printStackTrace();
					}
				});

				writer.close();

			} catch (IOException e) {
				e.printStackTrace();

			}
		}

	}

}
