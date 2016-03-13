package usermanagement;

import recordManagement.Record;

public abstract class User {
	protected String userName;

	public User(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Checks if the user can read the record.
	 * @param fp FileParser containing the record.
	 * @return True if user has access. False otherwise.
	 */
	public abstract boolean canRead(Record record);
	
	/**
	 * Checks if the user can write to the record.
	 * @param fp FileParser containing the record.
	 * @return True if user has access. False otherwise.
	 */
	public abstract boolean canWrite(Record record);
	
	/**
	 * Checks if the user can delete the record.
	 * @param fp FileParser containing the record.
	 * @return True if user has access. False otherwise.
	 */
	public abstract boolean canDelete();	
	
	/**
	 * Checks if the user can delete the record.
	 * @return
	 */
	public abstract boolean canRecord();
	
	/**
	 * Checks if the user can create a record
	 * @param fp
	 * @return
	 */
	public abstract boolean canCreate();
	
	public abstract String getDivision();
}
