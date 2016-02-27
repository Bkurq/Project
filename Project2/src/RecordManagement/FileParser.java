package RecordManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileParser {
	private String record, doctor, nurse, patient, division;

	/**
	 * Reads fileName and puts a name with the correct corresponding
	 * startNumber.
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public void readFile(String file) throws IOException, FileNotFoundException {
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
	public void writeFile(String file, String[] contents) throws IOException, FileNotFoundException {
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for(String parameter:contents) {
			bufferedWriter.write(parameter);
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}
	
	/**
	 * Returns patient's username
	 * @return
	 */
	public String getPatient() {
		return patient;
	}
	
	/**
	 * Returns doctor's username
	 * @return
	 */
	public String getDoctor() {
		return doctor;
	}
	
	/**
	 * Returns nurse's username
	 * @return
	 */
	public String getNurse() {
		return nurse;
	}
	
	/**
	 * Returns division's name
	 * @return
	 */
	public String getDivision() {
		return division;
	}
	
	/**
	 * Returns record's name
	 * @return
	 */
	public String getRecord() {
		return record;
	}
	
	/**
	 * @param record the record to set
	 */
	public void setRecord(String record) {
		this.record = record;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	/**
	 * @param nurse the nurse to set
	 */
	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(String patient) {
		this.patient = patient;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}

}
