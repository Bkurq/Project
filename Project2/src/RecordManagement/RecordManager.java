package RecordManagement;

import java.util.ArrayList;
import java.io.File;;

public class RecordManager {
	private ArrayList<FileParser> records;
	
	public RecordManager() {
		records = new ArrayList<FileParser>();
		File dir = new File("records");
		String[] dirContents = dir.list();
		if(dirContents != null) {
			for(String file: dirContents) {
				records.add(new FileParser(file));
			}
		}
	}
	
	
}
