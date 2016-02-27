package JUnit;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import RecordManagement.FileParser;

public class FileParserTest {
	private FileParser fp;

	@Before
	public void setUp() {
		fp = new FileParser("fp.txt");
	}

	@Test
	public void testReader() throws FileNotFoundException, IOException {
		fp.readFile();
		assertEquals("Patient", fp.getPatient());
		assertEquals("Doctor", fp.getDoctor());
		assertEquals("Nurse", fp.getNurse());
		assertEquals("Division", fp.getDivision());
		assertEquals("This is a medical record. Viewer discretion is advised.", fp.getRecord());
	}
	
	@Test
	public void testWriter() throws FileNotFoundException, IOException {
		fp.writeFile("asdf");
		fp.readFile();
		assertEquals("asdf", fp.getPatient());
		fp.writeFile("Patient\nDoctor\nNurse\nDivision\nThis is a medical record. Viewer discretion is advised.");
	}
}
