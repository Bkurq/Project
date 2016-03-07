package recordManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileParser {
	private String filePath;
	private Record record;

	public FileParser(String filePath, Record record) {
		this.filePath = (filePath.replaceAll(":",""));
		this.record = record;
	}

	/**
	 * Reads fileName and puts a name with the correct corresponding startNumber.
	 * @param fileName
	 * @throws IOException 
	 */
	public void readFile() {
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			record.setPatient(bufferedReader.readLine());
			record.setDoctor(bufferedReader.readLine());
			record.setNurse(bufferedReader.readLine());
			record.setDivision(bufferedReader.readLine());
			StringBuilder sb = new StringBuilder();
			String line = bufferedReader.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
			record.setRecord(sb.toString().trim());
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
			bufferedWriter.write(record.getPatient());
			bufferedWriter.newLine();
			bufferedWriter.write(record.getDoctor());
			bufferedWriter.newLine();
			bufferedWriter.write(record.getNurse());
			bufferedWriter.newLine();
			bufferedWriter.write(record.getDivision());
			bufferedWriter.newLine();
			bufferedWriter.write(record.getRecord());
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	
	public void setRecord(Record record) {
		this.record = record;
	}
	
	public Record getRecord() {
		return record;
	}
}
