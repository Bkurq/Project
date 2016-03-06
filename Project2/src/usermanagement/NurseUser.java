package usermanagement;

import recordManagement.FileParser;

public class NurseUser extends User {
	private String division;

	public NurseUser(String name, String division) {
		super(name);
		this.division = division;
	}
	
	public String getDivision() {
		return division;
	}

	@Override
	public boolean canRead(FileParser fp) {
		return fp.getNurse().equals(userName) || fp.getDivision().equals(division);
	}

	@Override
	public boolean canWrite(FileParser fp) {
		return fp.getNurse().equals(userName);
	}

	@Override
	public boolean canDelete() {
		return false;
	}

	@Override
	public boolean canRecord(FileParser fp) {
		return false;
	}
	
	@Override
	public boolean canCreate() {
		return false;
	}
	
	
}
