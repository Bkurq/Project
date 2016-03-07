package recordManagement;

import java.util.ArrayList;

import usermanagement.User;

import java.io.File;

public class RecordManager {
	private ArrayList<FileParser> records;
	
	/**
	 * Create new RecordManager with directoryPath as the directory containing records
	 * @param directoryPath
	 */
	public RecordManager(String directoryPath) {
		readFiles(directoryPath);
	}
	
	/**
	 * Read all records on the server
	 * @param directoryPath
	 */
	private void readFiles(String directoryPath) {
		records = new ArrayList<FileParser>();
		File folder = new File(directoryPath);
		String[] folderContents = folder.list();
		if(folderContents != null) {
			for(String filePath: folderContents) {
				FileParser medicalRecord = new FileParser(directoryPath+"/"+filePath, new Record());
				medicalRecord.readFile();
				records.add(medicalRecord);
			}
		}
	}
	
	/**
	 * Find all records the user can perform operations on
	 * @param user 
	 * @return ArrayList containing matching medical records
	 */
	public ArrayList<Record> getRecords(User user) {
		ArrayList<Record> matchingRecords = new ArrayList<Record>();
		for(FileParser fp:records) {
			Record record = fp.getRecord();
			if(user.canRead(record)) {
				matchingRecords.add(record);
			}
		}
		return matchingRecords;
	}
	
	/**
	 * Write records to hard drive
	 */
	public void writeFiles() {
		for(FileParser medicalRecord:records) {
			medicalRecord.writeFile();
		}
	}
}
