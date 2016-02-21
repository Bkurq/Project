package usermanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {
	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String record;
	private String doctor, nurse, patient, division;
	
	/**
	 * Creates a new FileParser that will read from a file
	 * @param fileName Name of the file to be read.
	 * @throws IOException 
	 */
	public FileParser(String fileName) throws IOException {
		file = new File(fileName);
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.toString());
		}
		readFile();
	}

	/**
	 * Reads fileName and puts a name with the correct corresponding
	 * startNumber.
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	private void readFile() throws IOException {
		patient = bufferedReader.readLine();
		doctor = bufferedReader.readLine();
		nurse = bufferedReader.readLine();
		division = bufferedReader.readLine();
		StringBuilder sb = new StringBuilder();
	    String line = bufferedReader.readLine();

	    while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = bufferedReader.readLine();
	    }
	    record = sb.toString();
	}
	
	public String getPatient() {
		return patient;
	}
	
	public String getDoctor() {
		return doctor;
	}
	
	public String getNurse() {
		return nurse;
	}
	
	public String getDivision() {
		return division;
	}
	
	public String getRecord() {
		return record;
	}
}
