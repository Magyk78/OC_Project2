package com.hemebiotech.analytics.symptom_reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Contains method to read symptoms list from a text file
 * 
 * @author Antoine
 * @version 1.0
 * @since 23/03/2022
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private Path path;

	/**
	 * Class Constructor
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it
	 * @throws IllegalArgumentException if filepath is null, empty or blank
	 * @throws IOException              if stream to file cannot be read
	 */
	public ReadSymptomDataFromFile(String filepath) throws IOException {

		if ((filepath == null) || (filepath.isEmpty()) || (filepath.isBlank()))
			throw new IllegalArgumentException("filepath cannot be null, empty or blank");

		this.filepath = filepath;
		path = (Paths.get(this.filepath));

	}

	/**
	 * Returns a list of symptoms from a text file, duplicates are possible/probable
	 * 
	 * @return result - list of symptoms
	 * 
	 */
	@Override
	public List<String> getSymptoms() {

		List<String> result = null;

		try {

			Stream<String> lines = Files.lines(path);
			// Get in result list all lines not empty
			result = lines.filter(s -> !s.trim().isEmpty()).toList();
			lines.close();

		} catch (IOException e) {

			System.out.println("The file symptoms.txt cannot be read");
		}

		return result;
	}

}
