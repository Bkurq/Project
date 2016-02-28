package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import RecordManagement.FileParser;
import RecordManagement.RecordManager;

public class RecordManagerTest {
	private RecordManager recordManager;

	@Before
	public void setUp() throws Exception {
		recordManager = new RecordManager("records");
	}

	@Test
	public void test() {
		recordManager.getRecords();
	}

}
