package org.opensms.db.entity;


/**
 * Created by dewmal on 1/1/14.
 */
public class Customer {

    private int user_id;
    private String username;
    private String nicNumber;
    private String contactNumber;
    private String email;
    private String firstName;
    
    private Location location;
    
    


   

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	@Override
	public String toString() {
		return "Customer [user_id=" + user_id + ", username=" + username
				+ ", nicNumber=" + nicNumber + ", contactNumber="
				+ contactNumber + ", email=" + email + ", firstName="
				+ firstName + ", location=" + location + "]";
	}
    
    
}
