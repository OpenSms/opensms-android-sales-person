/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensms.serverdb.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author dewmal
 */
public class PreOrderHasItem implements Serializable, EntityInterface<PreOrderHasItemPK> {
    private static final long serialVersionUID = 1L;
   
    protected PreOrderHasItemPK preOrderHasItemPK;
  
    private BigDecimal quantity;
   private PreOrder preOrder1;
    private Item item1;

    public PreOrderHasItem() {
    }

    public PreOrderHasItem(PreOrderHasItemPK preOrderHasItemPK) {
        this.preOrderHasItemPK = preOrderHasItemPK;
    }

    public PreOrderHasItem(PreOrderHasItemPK preOrderHasItemPK, BigDecimal quantity) {
        this.preOrderHasItemPK = preOrderHasItemPK;
        this.quantity = quantity;
    }

    public PreOrderHasItem(String item, long preOrder) {
        this.preOrderHasItemPK = new PreOrderHasItemPK(item, preOrder);
    }

    public PreOrderHasItemPK getPreOrderHasItemPK() {
        return preOrderHasItemPK;
    }

    public void setPreOrderHasItemPK(PreOrderHasItemPK preOrderHasItemPK) {
        this.preOrderHasItemPK = preOrderHasItemPK;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public PreOrder getPreOrder1() {
        return preOrder1;
    }

    public void setPreOrder1(PreOrder preOrder1) {
        this.preOrder1 = preOrder1;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preOrderHasItemPK != null ? preOrderHasItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreOrderHasItem)) {
            return false;
        }
        PreOrderHasItem other = (PreOrderHasItem) object;
        if ((this.preOrderHasItemPK == null && other.preOrderHasItemPK != null) || (this.preOrderHasItemPK != null && !this.preOrderHasItemPK.equals(other.preOrderHasItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.PreOrderHasItem[ preOrderHasItemPK=" + preOrderHasItemPK + " ]";
    }

    @Override
    public PreOrderHasItemPK getId() {
        return getPreOrderHasItemPK();
    }
}
