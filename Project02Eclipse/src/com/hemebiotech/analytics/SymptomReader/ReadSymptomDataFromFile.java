package com.hemebiotech.analytics.SymptomReader;

import java.io.FileNotFoundException;
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
	 * @param filepath 	a full or partial path to file with symptom strings in it
	 * @throws NullPointerException 	if object is null
	 * @throws FileNotFoundException    if file not found
	 * @throws IOException              if stream to file cannot be read
	 */
	public ReadSymptomDataFromFile(String filepath) throws IOException {

		this.filepath = filepath;

		if (this.filepath == null) {
			throw new NullPointerException();
		} else {

			path = (Paths.get(this.filepath));

			if (path == null) {
				throw new NullPointerException();
			} else if (!Files.exists(path)) {
				throw new FileNotFoundException();
			} else if (!Files.isReadable(path)) {
				throw new IOException();
			}
		}

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

			e.printStackTrace();
		}

		return result;
	}

}
