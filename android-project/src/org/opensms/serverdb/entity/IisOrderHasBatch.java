/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.opensms.serverdb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dewmal
 */
public class IisOrderHasBatch implements Serializable, EntityInterface<IisOrderHasBatchPK> {
    private static final long serialVersionUID = 1L;
   protected IisOrderHasBatchPK iisOrderHasBatchPK;
   
    private BigDecimal issuedQuantity;
    private BigDecimal returnQuantity;
    private List<IisOrderBatchHasGsrOrder> iisOrderBatchHasGsrOrderList;
    private Batch batch1;

    public IisOrderHasBatch() {
    }

    public IisOrderHasBatch(IisOrderHasBatchPK iisOrderHasBatchPK) {
        this.iisOrderHasBatchPK = iisOrderHasBatchPK;
    }

    public IisOrderHasBatch(IisOrderHasBatchPK iisOrderHasBatchPK, BigDecimal issuedQuantity) {
        this.iisOrderHasBatchPK = iisOrderHasBatchPK;
        this.issuedQuantity = issuedQuantity;
    }

    public IisOrderHasBatch(long iisOrder, String batch) {
        this.iisOrderHasBatchPK = new IisOrderHasBatchPK(iisOrder, batch);
    }

    public IisOrderHasBatchPK getIisOrderHasBatchPK() {
        return iisOrderHasBatchPK;
    }

    public void setIisOrderHasBatchPK(IisOrderHasBatchPK iisOrderHasBatchPK) {
        this.iisOrderHasBatchPK = iisOrderHasBatchPK;
    }

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public BigDecimal getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public List<IisOrderBatchHasGsrOrder> getIisOrderBatchHasGsrOrderList() {
        return iisOrderBatchHasGsrOrderList;
    }

    public void setIisOrderBatchHasGsrOrderList(List<IisOrderBatchHasGsrOrder> iisOrderBatchHasGsrOrderList) {
        this.iisOrderBatchHasGsrOrderList = iisOrderBatchHasGsrOrderList;
    }

    public Batch getBatch1() {
        return batch1;
    }

    public void setBatch1(Batch batch1) {
        this.batch1 = batch1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iisOrderHasBatchPK != null ? iisOrderHasBatchPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IisOrderHasBatch)) {
            return false;
        }
        IisOrderHasBatch other = (IisOrderHasBatch) object;
        if ((this.iisOrderHasBatchPK == null && other.iisOrderHasBatchPK != null) || (this.iisOrderHasBatchPK != null && !this.iisOrderHasBatchPK.equals(other.iisOrderHasBatchPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.IisOrderHasBatch[ iisOrderHasBatchPK=" + iisOrderHasBatchPK + " ]";
    }

    @Override
    public IisOrderHasBatchPK getId() {
        return getIisOrderHasBatchPK();
    }
}
