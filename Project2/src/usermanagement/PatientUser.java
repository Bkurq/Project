package usermanagement;

import RecordManagement.FileParser;

public class PatientUser extends User {

	public PatientUser(String name) {
		super(name);
	}

	@Override
	public boolean canRead(FileParser fp) {
		return false;
	}

	@Override
	public boolean canWrite(FileParser fp) {
		return false;
	}

	@Override
	public boolean canDelete(FileParser fp) {
		return false;
	}

}
