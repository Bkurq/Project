package RecordManagement;

import java.util.ArrayList;

import usermanagement.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;;

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
	 * Create new RecordManager as a deep copy of oldRecordManager
	 * @param oldRecordManager
	 */
	public RecordManager(RecordManager oldRecordManager) {
		System.arraycopy(oldRecordManager.records, 0, records, 0, oldRecordManager.records.size());
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
				FileParser medicalRecord = new FileParser();
				try {
					medicalRecord.readFile(filePath);
					records.add(medicalRecord);
				} catch (FileNotFoundException e) {
					System.out.println(filePath + "not found");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println(filePath + "could not be loaded");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Find all records the user can perform operations on
	 * @param user 
	 * @return ArrayList containing matching medical records
	 */
	public ArrayList<FileParser> search(User user) {
		ArrayList<FileParser> matchingRecords = new ArrayList<FileParser>();
		for(FileParser medicalRecord:records) {
			if(user.canAccess(medicalRecord)) {
				matchingRecords.add(medicalRecord);
			}
		}
		return matchingRecords;
	}
	
	public void writeRecord() {
		
	}
}
