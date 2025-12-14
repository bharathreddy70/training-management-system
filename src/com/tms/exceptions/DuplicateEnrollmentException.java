package com.tms.exceptions;

public class DuplicateEnrollmentException extends RuntimeException {
	  public String getMessage() {
		  return "Duplicate enrollment! Student is already enrolled.";
	  }
}
