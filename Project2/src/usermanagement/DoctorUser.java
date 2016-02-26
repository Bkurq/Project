package usermanagement;

public class DoctorUser extends User {
	private String division;

	public DoctorUser(String name) {
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
