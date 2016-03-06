package usermanagement;

import recordManagement.FileParser;

public class GovernmentUser extends User {

	public GovernmentUser(String name) {
		super(name);
	}

	@Override
	public boolean canRead(FileParser fp) {
		return true;
	}

	@Override
	public boolean canWrite(FileParser fp) {
		return false;
	}

	@Override
	public boolean canDelete() {
		return true;
	}
	
	@Override
	public boolean canRecord(FileParser fp) {
		return true;
	}
	
	@Override
	public boolean canCreate() {
		return false;
	}
	
	public String getDivision() {
		return null;
	}

}
