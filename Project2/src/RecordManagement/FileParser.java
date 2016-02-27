package RecordManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String record;
	private String doctor, nurse, patient, division;
	
	/**
	 * Creates a new FileParser that will read from a file
	 * @param fileName Name of the file to be read.
	 * @throws IOException 
	 */
	public FileParser(File file) {
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found: " + file.toString());
		}
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("Error reading the file");
			e.printStackTrace();
		}
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
	
	/**
	 * Returns patient name
	 * @return
	 */
	public String getPatient() {
		return patient;
	}
	
	/**
	 * Returns doctor name
	 * @return
	 */
	public String getDoctor() {
		return doctor;
	}
	
	/**
	 * Returns nurse name
	 * @return
	 */
	public String getNurse() {
		return nurse;
	}
	
	/**
	 * Returns division name
	 * @return
	 */
	public String getDivision() {
		return division;
	}
	
	/**
	 * Returns record name
	 * @return
	 */
	public String getRecord() {
		return record;
	}
}
