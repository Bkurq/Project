package recordManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import usermanagement.User;

public class FileParser {
	private filePath;

	public FileParser(String filePath) {
		this.filePath = (filePath.replaceAll(":",""));
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
			System.out.println(filePath);
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


}
