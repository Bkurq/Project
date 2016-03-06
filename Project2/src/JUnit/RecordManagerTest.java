package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import recordManagement.FileParser;
import recordManagement.RecordManager;

public class RecordManagerTest {
	private RecordManager recordManager;

	@Before
	public void setUp() throws Exception {
		recordManager = new RecordManager("records");
	}
	
	private String recordToString(RecordManager recordManager, int index) {
		ArrayList<FileParser> records = recordManager.getRecords();
		return records.get(index).getRecord().getPatient() + "\n" + records.get(index).getRecord().getDoctor() + 
				"\n" + records.get(index).getRecord().getNurse() + "\n" + records.get(index).getRecord().getDivision() + 
				"\n" + records.get(index).getRecord().getRecord();
	}

	@Test
	public void testRead() {
		try {
			System.out.println(recordToString(recordManager, 0));
			System.out.println();
			System.out.println(recordToString(recordManager, 1));
			assert(true);
		} catch (Exception e) {
			e.printStackTrace();
			assert(false);
		}
	}
	
	@Test
	public void testCopy() {
		RecordManager recordManager2 = new RecordManager(recordManager);
		try {
			System.out.println(recordToString(recordManager2, 0));
			System.out.println();
			System.out.println(recordToString(recordManager2, 1));
			assert(true);
		} catch (Exception e) {
			e.printStackTrace();
			assert(false);
		}
	}

}
