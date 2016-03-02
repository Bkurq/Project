package RecordManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileParser {
	private String patient, doctor, nurse, division, record, filePath, log;

	public FileParser(String filePath) {
		this.filePath = filePath;
		patient = "";
		doctor = "";
		nurse = "";
		division = "";
		record = "";
		log = "";
	}

	/**
	 * Reads fileName and puts a name with the correct corresponding
	 * startNumber.
	 * 
	 * @param fileName
	 * @throws IOException 
	 */
	public void readFile() {
		try {
			FileReader fileReader = new FileReader(filePath);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			patient = bufferedReader.readLine();
			doctor = bufferedReader.readLine();
			nurse = bufferedReader.readLine();
			division = bufferedReader.readLine();
			StringBuilder sb = new StringBuilder();
			String line = bufferedReader.readLine();

			while (line != null && !line.equals("#")) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
			record = sb.toString().trim();
			line = bufferedReader.readLine();
			sb = new StringBuilder();
			while(line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
			log = sb.toString().trim();
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(filePath + " not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(filePath + " could not be loaded");
			e.printStackTrace();
		}
	    
	}
	
	/**
	 * Write to the file overwriting existing data.
	 * @param args
	 * @throws IOException, FileNotFoundException 
	 */
	public void writeFile() {
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(patient);
			bufferedWriter.newLine();
			bufferedWriter.write(doctor);
			bufferedWriter.newLine();
			bufferedWriter.write(nurse);
			bufferedWriter.newLine();
			bufferedWriter.write(division);
			bufferedWriter.newLine();
			bufferedWriter.write(record);
			bufferedWriter.newLine();
			bufferedWriter.write("#");
			bufferedWriter.write(log);
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the contents of the file doctor, patient, nurse, division, record without writing to a file
	 * @param contents String[] containing patient, doctor, nurse, division, record
	 */
	public void setContents(String[] contents) {
		patient = contents[0];
		doctor = contents[1];
		nurse = contents[2];
		division = contents[3];
		record = contents[4];
	}
	
	/**
	 * Add an entry to log
	 * @param string
	 */
	public void Log(String string) {
		StringBuilder sb = new StringBuilder();
		sb.append(log);
		sb.append(System.lineSeparator());
		sb.append(string);
		log = sb.toString();
	}
	
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	
	/**
	 * @return the log
	 */
	public String getLog() {
		return log;
	}

	/**
	 * @param log the log to set
	 */
	public void setLog(String log) {
		this.log = log;
	}
	
	public String toString() {
		return filePath;
	}

}
