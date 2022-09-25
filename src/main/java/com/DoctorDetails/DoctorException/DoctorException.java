package com.DoctorDetails.DoctorException;

public class DoctorException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "id already exists in database";
	}

}
