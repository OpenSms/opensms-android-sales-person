/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensms.serverdb.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author dewmal
 */
public class UserRolePK implements Serializable {

    private int role;
    private int user;
    private Date assignDate;

    public UserRolePK() {
    }

    public UserRolePK(int role, int user, Date assignDate) {
        this.role = role;
        this.user = user;
        this.assignDate = assignDate;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) role;
        hash += (int) user;
        hash += (assignDate != null ? assignDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRolePK)) {
            return false;
        }
        UserRolePK other = (UserRolePK) object;
        if (this.role != other.role) {
            return false;
        }
        if (this.user != other.user) {
            return false;
        }
        if ((this.assignDate == null && other.assignDate != null) || (this.assignDate != null && !this.assignDate.equals(other.assignDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.UserRolePK[ role=" + role + ", user=" + user + ", assignDate=" + assignDate + " ]";
    }
    
}
