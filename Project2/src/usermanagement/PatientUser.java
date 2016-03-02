package usermanagement;

import RecordManagement.FileParser;

public class PatientUser extends User {

	public PatientUser(String name) {
		super(name);
	}

	@Override
	public boolean canRead(FileParser fp) {
		return fp.getPatient().equals(userName);
	}

	@Override
	public boolean canWrite(FileParser fp) {
		return false;
	}

	@Override
	public boolean canDelete(FileParser fp) {
		return false;
	}

	@Override
	public boolean canRecord(FileParser fp) {
		return false;
	}

}
