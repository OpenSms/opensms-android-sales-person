package org.opensms.db.entity;

public class PreOrder {
	
	private  final CharSequence name ;
	private String location;

	
	
	public PreOrder(CharSequence name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public CharSequence getName() {
		return this.name;
	}
	
	
	

}
