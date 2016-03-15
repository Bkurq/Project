package usermanagement;

import java.io.Serializable;

import recordManagement.FileParser;
import recordManagement.Record;

public class DoctorUser extends User implements Serializable {
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
		boolean one = record.getDoctor().equals(userName);
		boolean two = record.getDivision().equals(division);
		return one || two;
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
