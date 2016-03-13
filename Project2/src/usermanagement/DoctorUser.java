package usermanagement;

import recordManagement.FileParser;
import recordManagement.Record;

public class DoctorUser extends User {
	private String division;

	public DoctorUser(String name, String division) {
		super(name);
		this.division = division;
	}
	
	public String getDivision() {
		return division;
	}

	@Override
	public boolean canRead(Record record) {
		return record.getDoctor().equals(userName) || record.getDivision().equals(division);
	}

	@Override
	public boolean canWrite(Record record) {
		return record.getDoctor().equals(userName);
	}

	@Override
	public boolean canDelete() {
		return false;
	}
	
	@Override
	public boolean canRecord() {
		return false;
	}
	
	@Override
	public boolean canCreate() {
		return true;
	}

}
