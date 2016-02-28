package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import RecordManagement.FileParser;
import RecordManagement.RecordManager;

public class RecordManagerTest {
	private RecordManager recordManager;
	private ArrayList<FileParser> records;

	@Before
	public void setUp() throws Exception {
		recordManager = new RecordManager("records");
		records = recordManager.getRecords();
	}
	
	private String recordToString(int index) {
		return records.get(index).getPatient() + "\n" + records.get(index).getDoctor() + 
				"\n" + records.get(index).getNurse() + "\n" + records.get(index).getDivision() + 
				"\n" + records.get(index).getRecord();
	}

	@Test
	public void test() {
		try {
			System.out.println(recordToString(0));
			assert(true);
		} catch (Exception e) {
			e.printStackTrace();
			assert(false);
		}
	}

}
