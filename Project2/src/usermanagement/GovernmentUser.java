package usermanagement;

import java.io.Serializable;

import recordManagement.FileParser;
import recordManagement.Record;

public class GovernmentUser extends User implements Serializable {

	public GovernmentUser(String name) {
		super(name);
	}

	@Override
	public boolean canRead(Record record) {
		return true;
	}

	@Override
	public boolean canWrite(Record record) {
		return false;
	}

	@Override
	public boolean canDelete() {
		return true;
	}
	
	@Override
	public boolean canRecord() {
		return true;
	}
	
	@Override
	public boolean canCreate() {
		return false;
	}
	
	public String getDivision() {
		return "";
	}

}
