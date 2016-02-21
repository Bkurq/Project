package usermanagement;

public class PatientUser extends User {

	public PatientUser(String name, UserType type) {
		super(name, type);
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
