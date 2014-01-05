/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensms.serverdb.entity;

import java.io.Serializable;

/**
 *
 * @author dewmal
 */

public class PreOrderHasItemPK implements Serializable {
  
    private String item;
    private long preOrder;

    public PreOrderHasItemPK() {
    }

    public PreOrderHasItemPK(String item, long preOrder) {
        this.item = item;
        this.preOrder = preOrder;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public long getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(long preOrder) {
        this.preOrder = preOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (item != null ? item.hashCode() : 0);
        hash += (int) preOrder;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreOrderHasItemPK)) {
            return false;
        }
        PreOrderHasItemPK other = (PreOrderHasItemPK) object;
        if ((this.item == null && other.item != null) || (this.item != null && !this.item.equals(other.item))) {
            return false;
        }
        if (this.preOrder != other.preOrder) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.PreOrderHasItemPK[ item=" + item + ", preOrder=" + preOrder + " ]";
    }
    
}
