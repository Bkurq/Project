package recordManagement;

import java.util.ArrayList;
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
	 * Create new RecordManager as a deep copy of oldRecordManager
	 * @param oldRecordManager
	 */
	public RecordManager(RecordManager oldRecordManager) {
		records = new ArrayList<FileParser>();
		for(FileParser medicalRecord:oldRecordManager.records) {
			records.add(medicalRecord);
		}
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
	public ArrayList<FileParser> getRecords() {
		return records;
	}
	
	
	public void writeFiles() {
		for(FileParser medicalRecord:records) {
			medicalRecord.writeFile();
		}
	}
}
