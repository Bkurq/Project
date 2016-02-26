package usermanagement;

public class NurseUser extends User {
	private String division;

	public NurseUser(String name) {
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
