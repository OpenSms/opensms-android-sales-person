/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensms.serverdb.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dewmal
 */
public class Vendor implements Serializable, EntityInterface<Integer> {
    private static final long serialVersionUID = 1L;
   
    private Integer userId;
    private String name;
    private String remark;
    private User user;
    private List<GrnOrder> grnOrderList;

    public Vendor() {
    }

    public Vendor(Integer userId) {
        this.userId = userId;
    }

    public Vendor(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<GrnOrder> getGrnOrderList() {
        return grnOrderList;
    }

    public void setGrnOrderList(List<GrnOrder> grnOrderList) {
        this.grnOrderList = grnOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.Vendor[ userId=" + userId + " ]";
    }

    @Override
    public Integer getId() {
        return getUserId();
    }
}
