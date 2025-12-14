package com.tms.model.person;

import java.util.Objects;

import com.tms.interfaces.Identifiable;
import com.tms.interfaces.Nameable;

public class Person implements Identifiable<Long>,Nameable{
private final Long id;
private String name;

public Person(Long id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Long getId() {
	return id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public int hashCode() {
	return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Person other = (Person) obj;
	return Objects.equals(id, other.id);
}



}


