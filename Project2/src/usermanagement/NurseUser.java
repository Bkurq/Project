package usermanagement;

import recordManagement.FileParser;
import recordManagement.Record;

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
	public boolean canRead(Record record) {
		return record.getNurse().equals(userName) || record.getDivision().equals(division);
	}

	@Override
	public boolean canWrite(Record record) {
		return record.getNurse().equals(userName);
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
		return false;
	}
	
	
}
