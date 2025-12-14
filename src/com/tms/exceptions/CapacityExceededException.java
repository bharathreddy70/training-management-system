package com.tms.exceptions;

public class CapacityExceededException extends RuntimeException{
  public String getMessage() {
	  return "Capacity exceeded! Cannot enroll more students.";
  }
}
