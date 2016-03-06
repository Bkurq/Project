package recordManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

import usermanagement.User;

public class Log {
	private String filePath;

	public Log(String filePath) {
		this.filePath = filePath;
	}
	
	public void readFile() {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();
		StringBuilder sb = new StringBuilder();
		while(line != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
			line = bufferedReader.readLine();
		}
		log = sb.toString().trim();
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
	
	public void Log(String string, User user) {
		StringBuilder sb = new StringBuilder();
		sb.append(log);
		sb.append(System.lineSeparator());
		sb.append(string);
		sb.append(":");
		sb.append(user.getUserName());
		sb.append(":");
		sb.append(new Date().toString());
		log = sb.toString();
	}
	
	
}
