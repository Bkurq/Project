package usermanagement;

import RecordManagement.FileParser;

public class DoctorUser extends User {
	private String division;

	public DoctorUser(String name, String division) {
		super(name);
		this.division = division;
	}

	@Override
	public boolean canRead(FileParser fp) {
		return fp.getDoctor().equals(userName) || fp.getDivision().equals(division);
	}

	@Override
	public boolean canWrite(FileParser fp) {
		return fp.getDoctor().equals(userName);
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
		return true;
	}

}
