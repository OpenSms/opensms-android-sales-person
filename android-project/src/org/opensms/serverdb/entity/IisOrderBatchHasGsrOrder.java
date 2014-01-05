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
public class IisOrderBatchHasGsrOrder implements EntityInterface<IisOrderBatchHasGsrOrderPK>,Serializable {
    private static final long serialVersionUID = 1L;
  
  protected IisOrderBatchHasGsrOrderPK iisOrderBatchHasGsrOrderPK;
   
private BigDecimal quantity;
   
 private IisOrderHasBatch iisOrderHasBatch;

    public IisOrderBatchHasGsrOrder() {
    }

    public IisOrderBatchHasGsrOrder(IisOrderBatchHasGsrOrderPK iisOrderBatchHasGsrOrderPK) {
        this.iisOrderBatchHasGsrOrderPK = iisOrderBatchHasGsrOrderPK;
    }

    public IisOrderBatchHasGsrOrder(IisOrderBatchHasGsrOrderPK iisOrderBatchHasGsrOrderPK, BigDecimal quantity) {
        this.iisOrderBatchHasGsrOrderPK = iisOrderBatchHasGsrOrderPK;
        this.quantity = quantity;
    }

    public IisOrderBatchHasGsrOrder(long gsrOrder, long iisOrder, String batch) {
        this.iisOrderBatchHasGsrOrderPK = new IisOrderBatchHasGsrOrderPK(gsrOrder, iisOrder, batch);
    }

    public IisOrderBatchHasGsrOrderPK getIisOrderBatchHasGsrOrderPK() {
        return iisOrderBatchHasGsrOrderPK;
    }

    public void setIisOrderBatchHasGsrOrderPK(IisOrderBatchHasGsrOrderPK iisOrderBatchHasGsrOrderPK) {
        this.iisOrderBatchHasGsrOrderPK = iisOrderBatchHasGsrOrderPK;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public IisOrderHasBatch getIisOrderHasBatch() {
        return iisOrderHasBatch;
    }

    public void setIisOrderHasBatch(IisOrderHasBatch iisOrderHasBatch) {
        this.iisOrderHasBatch = iisOrderHasBatch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iisOrderBatchHasGsrOrderPK != null ? iisOrderBatchHasGsrOrderPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IisOrderBatchHasGsrOrder)) {
            return false;
        }
        IisOrderBatchHasGsrOrder other = (IisOrderBatchHasGsrOrder) object;
        if ((this.iisOrderBatchHasGsrOrderPK == null && other.iisOrderBatchHasGsrOrderPK != null) || (this.iisOrderBatchHasGsrOrderPK != null && !this.iisOrderBatchHasGsrOrderPK.equals(other.iisOrderBatchHasGsrOrderPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.IisOrderBatchHasGsrOrder[ iisOrderBatchHasGsrOrderPK=" + iisOrderBatchHasGsrOrderPK + " ]";
    }

    @Override
    public IisOrderBatchHasGsrOrderPK getId() {
        return getIisOrderBatchHasGsrOrderPK();
    }
}
