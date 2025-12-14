package com.tms.model.person;

 
import java.util.HashSet;
import java.util.Set;

public class Trainer extends Person{
  private Set<String> expertise=new HashSet<String>();

  public Trainer(Long id, String name) {
	super(id, name);
  }

  public Set<String> getExpertise() {
	return expertise;
  }

  public void setExpertise(String string) {
	 expertise.add(string);
  }

	


}
