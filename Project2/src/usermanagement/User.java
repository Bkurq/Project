package usermanagement;

public abstract class User {
	public static final int USER_PATIENT = 1;
	public static final int USER_DOCTOR = 2;
	public static final int USER_NURSE = 3;
	public static final int USER_GOVERNMENT = 4;
	
	String name;
	String type;
	String division;
	String password;
	
	public User(String name) {
		this.name = name;
	}
	
	public abstract boolean canRead(FileParser fp);
	
	public abstract boolean canWrite(FileParser fp);
	
	public abstract boolean canDelete(FileParser fp);
	
}
