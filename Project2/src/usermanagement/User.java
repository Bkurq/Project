package usermanagement;

import server.FileParser;

public abstract class User {
	private String name;
	private String password;

	public User(String name) {
		this.name = name;
	}
	
	public abstract boolean canRead(FileParser fp);
	
	public abstract boolean canWrite(FileParser fp);
	
	public abstract boolean canDelete(FileParser fp);
	
}
