package com.tms.model.course;

import java.time.LocalDateTime;
import java.util.Objects;

public class Session {
  
	private LocalDateTime dateTime;
	private String topic;
	
	public Session(LocalDateTime dateTime, String topic) {
		super();
		this.dateTime = dateTime;
		this.topic = topic;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateTime, topic);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(topic, other.topic);
	}
	@Override
	public String toString() {
		return "Session [dateTime=" + dateTime + ", topic=" + topic + "]";
	}
	
	
}
