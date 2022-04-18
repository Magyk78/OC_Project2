package com.hemebiotech.analytics.symptom_writter;

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
	 * @throws IllegalArgumentException if filepath is null, empty or blank
	 */
	public WriteSymptomResultToFile(String filepath) {

		if ((filepath == null) || (filepath.isEmpty()) || (filepath.isBlank()))
			throw new IllegalArgumentException("filepath cannot be null, empty or blank");

		this.filepath = filepath;

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
					writer.write(k + "=" + v.toString() + System.lineSeparator());

				} catch (IOException e) {

					System.out.println("a problem occurred while writing the result file");
				}
			});

			writer.close();
		}

	}

}
