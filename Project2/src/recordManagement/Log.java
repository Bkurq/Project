package recordManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import usermanagement.User;

public class Log {
	private String filePath, log;

	public Log(String filePath) {
		this.filePath = filePath;
		log = "";
	}
	
	public void readFile() {
		FileReader fileReader;
		try {
			fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			StringBuilder sb = new StringBuilder();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
			log = sb.toString().trim();
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add entry to log
	 * @param string
	 * @param user
	 */
	public void log(String string, User user) {
		StringBuilder sb = new StringBuilder();
		sb.append(log);
		sb.append(System.lineSeparator());
		sb.append(string);
		sb.append(" : ");
		sb.append(user.getUserName());
		sb.append(" : ");
		sb.append(new Date().toString());

		log = sb.toString();
	}

	public void writeFile() {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(log);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String getLog() {
		return log;
	}
	
}
