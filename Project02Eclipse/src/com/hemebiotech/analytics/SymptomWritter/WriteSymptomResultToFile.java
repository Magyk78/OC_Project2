package com.hemebiotech.analytics.SymptomWritter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Contains method to write the symptoms in a file
 * 
 * @author Antoine
 * @version 1.0
 * @since 23/03/2022
 */
public class WriteSymptomResultToFile implements ISymptomWritter {

	private String filepath;

	/**
	 * Class Constructor
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it
	 * @throws NullPointerException if object is null
	 */
	public WriteSymptomResultToFile(String filepath) {

		this.filepath = filepath;

		if (this.filepath == null)
			throw new NullPointerException();

	}

	/**
	 * Write a text file from a Tree Map of symptoms
	 * 
	 * @param symptomResult a map sorted alphabetically of symptom name and number
	 *                      of symptom
	 * @throws NullPointerException if object is null
	 * @throws IOException          if stream to file cannot be written to or
	 *                              closed.
	 */
	@Override
	public void writeResultOut(TreeMap<String, Long> symptomResult) throws IOException {

		if (symptomResult == null)
			throw new NullPointerException();
		else {

			BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));

			symptomResult.forEach((k, v) -> {
				try {
					// Write in the text file
					writer.write(k + "," + v.toString() + System.lineSeparator());

				} catch (IOException e) {

					e.printStackTrace();
				}
			});

			writer.close();
		}

	}

}
