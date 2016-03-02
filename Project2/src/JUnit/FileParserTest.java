package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import RecordManagement.FileParser;

public class FileParserTest {
	private FileParser fp;
	private String[] contents;
	
	//run twice, test fails on first try

	@Before
	public void setUp() {
		fp = new FileParser("fp.txt");
		contents = new String[]{"Patient", "Doctor", "Nurse", "Division", "This is a medical record. Viewer discretion is advised.", "1234 user 1234"};
	}

	@Test
	public void testReader() throws FileNotFoundException, IOException {
		fp.readFile();
		assertEquals(contents[0], fp.getPatient());
		assertEquals(contents[1], fp.getDoctor());
		assertEquals(contents[2], fp.getNurse());
		assertEquals(contents[3], fp.getDivision());
		assertEquals(contents[4], fp.getRecord());
		assertEquals(contents[5], fp.getLog());
	}
	
	@Test
	public void testWriter() throws FileNotFoundException, IOException {
		fp.setContents(new String[]{"asdf", "", "", "", ""});
		fp.writeFile();
		fp.readFile();
		assertEquals("asdf", fp.getPatient());
		fp.setContents(contents);
		fp.Log("1234 user 1234");
		fp.writeFile();
	}
	
}
