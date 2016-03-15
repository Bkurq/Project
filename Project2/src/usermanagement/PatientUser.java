package usermanagement;

import java.io.Serializable;

import recordManagement.FileParser;
import recordManagement.Record;

public class PatientUser extends User implements Serializable {

	public PatientUser(String name) {
		super(name);
	}

	@Override
	public boolean canRead(Record record) {
		return record.getPatient().equals(userName);
	}

	@Override
	public boolean canWrite(Record record) {
		return false;
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
	
	public String getDivision() {
		return "";
	}

}
