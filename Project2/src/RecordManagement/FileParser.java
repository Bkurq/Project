package RecordManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileParser {
	private String file;
	private String record, doctor, nurse, patient, division;
	
	/**
	 * Creates a new FileParser that will read from a file
	 * @param fileName Name of the file to be read.
	 * @throws IOException 
	 */
	public FileParser(String file) {
		this.file = file;
	}

	/**
	 * Reads fileName and puts a name with the correct corresponding
	 * startNumber.
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public void readFile() throws IOException, FileNotFoundException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
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
	    record = sb.toString().trim();
	    bufferedReader.close();
	}
	
	/**
	 * Write to the file overwriting existing data.
	 * @param args
	 * @throws IOException, FileNotFoundException 
	 */
	public void writeFile(String contents) throws IOException, FileNotFoundException {
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(contents);
		bufferedWriter.close();
		fileWriter.close();
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
