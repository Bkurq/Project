package recordManagement;

import java.util.ArrayList;
import java.util.Date;

import usermanagement.User;

import java.io.File;

public class RecordManager {
	private ArrayList<FileParser> records;
	private String directoryPath;
	private Log log;
	
	/**
	 * Create new RecordManager with directoryPath as the directory containing records
	 * @param directoryPath
	 */
	public RecordManager(String directoryPath, Log log) {
		this.directoryPath = directoryPath;
		this.log = log;
		log.readFile();
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
		int index = 0;
		for(FileParser fp:records) {
			Record record = fp.getRecord();
			if(user.canRead(record)) {
				record.setIndex(index);
				matchingRecords.add(record);
			}
			index++;
		}
		return matchingRecords;
	}
	
	public boolean update(User user, Record record) {
		if(user.canWrite(record)) {
			records.get(record.getIndex()).getRecord().setRecord(record.getRecord());
			log.log("Edit " + records.get(record.getIndex()).getFilePath(), user);
			return true;
		}
		return false;
	}
	
	public boolean addNewRecord(User user, Record record) {
		if(user.canCreate()) {
			records.add(new FileParser(new Date().toString(), record));
			log.log("Create " + records.get(records.size()-1).getFilePath(), user);
			return true;
		}
		return false;
	}
	
	/**
	 * Write records to hard drive
	 */
	public void writeFiles() {
		for(FileParser medicalRecord:records) {
			medicalRecord.writeFile();
		}
		log.writeFile();
	}
}
