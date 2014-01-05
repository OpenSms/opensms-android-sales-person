/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensms.serverdb.entity;

import java.io.Serializable;
/**
 * @author dewmal
 */
public class Role implements Serializable, EntityInterface<Integer> {
    private static final long serialVersionUID = 1L;
   
    private Integer roleId;
    private String description;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role1", fetch = FetchType.LAZY)
//    private List<UserRole> userRoleList;

    public Role() {
    }

    public Role(Integer roleId) {
        this.roleId = roleId;
    }

    public Role(Integer roleId, String description) {
        this.roleId = roleId;
        this.description = description;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<UserRole> getUserRoleList() {
//        return userRoleList;
//    }
//
//    public void setUserRoleList(List<UserRole> userRoleList) {
//        this.userRoleList = userRoleList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.Role[ roleId=" + roleId + " ]";
    }

    @Override
    public Integer getId() {
        return getRoleId();
    }
}
