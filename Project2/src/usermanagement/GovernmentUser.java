package usermanagement;

import server.FileParser;

public class GovernmentUser extends User {

	public GovernmentUser(String name) {
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
