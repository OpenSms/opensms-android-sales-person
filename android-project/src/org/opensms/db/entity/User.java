package org.opensms.db.entity;

import java.util.Date;

public class User {
	 private static final long serialVersionUID = 1L;
	   
	    private Integer userId;
	    private String username;
	    private String password;
	    private Date createdate;
	    private boolean accountStatus;
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getCreatedate() {
			return createdate;
		}
		public void setCreatedate(Date createdate) {
			this.createdate = createdate;
		}
		public boolean isAccountStatus() {
			return accountStatus;
		}
		public void setAccountStatus(boolean accountStatus) {
			this.accountStatus = accountStatus;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
	    
}
