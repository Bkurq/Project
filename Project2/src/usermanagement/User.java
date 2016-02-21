package usermanagement;

public abstract class User {
	private String name;
	private UserType type;
	private String password;
	
	public static enum UserType {
		Doctor, Patient, Nurse, Government
	}
		
	public User(String name, UserType type) {
		this.name = name;
		this.type = type;
	}
	
	public abstract boolean canRead(FileParser fp);
	
	public abstract boolean canWrite(FileParser fp);
	
	public abstract boolean canDelete(FileParser fp);
	
}
