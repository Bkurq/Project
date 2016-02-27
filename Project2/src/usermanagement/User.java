package usermanagement;

import RecordManagement.FileParser;

public abstract class User {
	private String userName;

	public User(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Returns true if the user can perform any available action on the record.
	 * @param fp FileParser containing the record.
	 * @return True if user has access. False otherwise.
	 */
	public boolean canAccess(FileParser fp) {
		if(canRead(fp) || canWrite(fp) || canDelete(fp)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if the user can read the record.
	 * @param fp FileParser containing the record.
	 * @return True if user has access. False otherwise.
	 */
	public abstract boolean canRead(FileParser fp);
	
	/**
	 * Checks if the user can write to the record.
	 * @param fp FileParser containing the record.
	 * @return True if user has access. False otherwise.
	 */
	public abstract boolean canWrite(FileParser fp);
	
	/**
	 * Checks if the user can delete the record.
	 * @param fp FileParser containing the record.
	 * @return True if user has access. False otherwise.
	 */
	public abstract boolean canDelete(FileParser fp);	
}
