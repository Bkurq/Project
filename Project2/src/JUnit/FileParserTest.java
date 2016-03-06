package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import recordManagement.FileParser;
import recordManagement.Record;

public class FileParserTest {
	private FileParser fp;
	private String[] contents;
	private Record record;
	
	//run twice, test fails on first try

	@Before
	public void setUp() {
		fp = new FileParser("fp.txt", new Record());
		record = fp.getRecord();
		contents = new String[]{"Patient", "Doctor", "Nurse", "Division", "This is a medical record. Viewer discretion is advised.", "1234 user 1234"};
	}

	@Test
	public void testReader() throws FileNotFoundException, IOException {
		fp.readFile();
		Record record = fp.getRecord();
		assertEquals(contents[0], record.getPatient());
		assertEquals(contents[1], record.getDoctor());
		assertEquals(contents[2], record.getNurse());
		assertEquals(contents[3], record.getDivision());
		assertEquals(contents[4], record.getRecord());
	}
	
	@Test
	public void testWriter() throws FileNotFoundException, IOException {
		record.setContents(new String[]{"asdf", "", "", "", ""});
		fp.writeFile();
		fp.readFile();
		assertEquals("asdf", record.getPatient());
		record.setContents(contents);
		fp.writeFile();
	}
	
}
