package recordManagement;

/**
 * Class Record is a container class that allows other classes to handle medical records.
 * @author bert
 *
 */
public class Record {
	private String patient, doctor, nurse, division, record;
	
	public Record() {
	}
	
	/**
	 * Sets the contents of the file doctor, patient, nurse, division, record without writing to a file
	 * @param contents String[] containing patient, doctor, nurse, division, record
	 */
	public void setContents(String[] contents) {
		patient = contents[0];
		doctor = contents[1];
		nurse = contents[2];
		division = contents[3];
		record = contents[4];
	}
	
	
	/**
	 * Returns patient's username
	 * @return
	 */
	public String getPatient() {
		return patient;
	}
	
	/**
	 * Returns doctor's username
	 * @return
	 */
	public String getDoctor() {
		return doctor;
	}
	
	/**
	 * Returns nurse's username
	 * @return
	 */
	public String getNurse() {
		return nurse;
	}
	
	/**
	 * Returns division's name
	 * @return
	 */
	public String getDivision() {
		return division;
	}
	
	/**
	 * Returns record's name
	 * @return
	 */
	public String getRecord() {
		return record;
	}
	
	/**
	 * @param record the record to set
	 */
	public void setRecord(String record) {
		this.record = record;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	/**
	 * @param nurse the nurse to set
	 */
	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(String patient) {
		this.patient = patient;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}

}
