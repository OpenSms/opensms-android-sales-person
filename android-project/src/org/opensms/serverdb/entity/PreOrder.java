/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensms.serverdb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dewmal
 */
public class PreOrder implements Serializable, EntityInterface<Long> {
    private static final long serialVersionUID = 1L;
  
    private Long preOrderId;
    private Date preOrderDate;
    private int priority;
    private boolean isOpen;
    private List<PreOrderHasItem> preOrderHasItemList;
    private IisOrder iisOrder;
    private Customer customer;

    public PreOrder() {
    }

    public PreOrder(Long preOrderId) {
        this.preOrderId = preOrderId;
    }

    public PreOrder(Long preOrderId, Date preOrderDate, int priority, boolean isOpen) {
        this.preOrderId = preOrderId;
        this.preOrderDate = preOrderDate;
        this.priority = priority;
        this.isOpen = isOpen;
    }

    public Long getPreOrderId() {
        return preOrderId;
    }

    public void setPreOrderId() {
        this.preOrderId = preOrderId;
    }

    public Date getPreOrderDate() {
        return preOrderDate;
    }

    public void setPreOrderDate(Date preOrderDate) {
        this.preOrderDate = preOrderDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public List<PreOrderHasItem> getPreOrderHasItemList() {
        return preOrderHasItemList;
    }

    public void setPreOrderHasItemList(List<PreOrderHasItem> preOrderHasItemList) {
        this.preOrderHasItemList = preOrderHasItemList;
    }

    public IisOrder getIisOrder() {
        return iisOrder;
    }

    public void setIisOrder(IisOrder iisOrder) {
        this.iisOrder = iisOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preOrderId != null ? preOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreOrder)) {
            return false;
        }
        PreOrder other = (PreOrder) object;
        if ((this.preOrderId == null && other.preOrderId != null) || (this.preOrderId != null && !this.preOrderId.equals(other.preOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.PreOrder[ preOrderId=" + preOrderId + " ]";
    }

    @Override
    public Long getId() {
        return getPreOrderId();
    }
}
