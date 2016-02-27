package JUnit;

import static org.junit.Assert.*;

import java.io.File;

import usermanagement.*;

import org.junit.Before;
import org.junit.Test;

import RecordManagement.FileParser;

public class FileParserTest {
	private FileParser fp;

	@Before
	public void setUp() throws Exception {
		fp = new FileParser(new File("fp.txt"));
	}

	@Test
	public void test() {
		assertEquals("Patient", fp.getPatient());
		assertEquals("Doctor", fp.getDoctor());
		assertEquals("Nurse", fp.getNurse());
		assertEquals("Division", fp.getDivision());
		assertEquals("This is a medical record. Viewer discretion is advised.", fp.getRecord().trim());
	}

}
