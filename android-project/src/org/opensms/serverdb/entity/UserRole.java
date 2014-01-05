/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensms.serverdb.entity;




import java.io.Serializable;
import java.util.Date;

/**
 * @author dewmal
 */
public class UserRole implements Serializable, EntityInterface<UserRolePK> {
    private static final long serialVersionUID = 1L;
    protected UserRolePK userRolePK;
    private Date resignDate;
    private boolean active;
    private Role role1;
    private User user1;

    public UserRole() {
    }

    public UserRole(UserRolePK userRolePK) {
        this.userRolePK = userRolePK;
    }

    public UserRole(UserRolePK userRolePK, boolean active) {
        this.userRolePK = userRolePK;
        this.active = active;
    }

    public UserRole(int role, int user, Date assignDate) {
        this.userRolePK = new UserRolePK(role, user, assignDate);
    }

    public UserRolePK getUserRolePK() {
        return userRolePK;
    }

    public void setUserRolePK(UserRolePK userRolePK) {
        this.userRolePK = userRolePK;
    }

    public Date getResignDate() {
        return resignDate;
    }

    public void setResignDate(Date resignDate) {
        this.resignDate = resignDate;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Role getRole1() {
        return role1;
    }

    public void setRole1(Role role1) {
        this.role1 = role1;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRolePK != null ? userRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.userRolePK == null && other.userRolePK != null) || (this.userRolePK != null && !this.userRolePK.equals(other.userRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.UserRole[ userRolePK=" + userRolePK + " ]";
    }

    @Override
    public UserRolePK getId() {
        return getUserRolePK();
    }
}
