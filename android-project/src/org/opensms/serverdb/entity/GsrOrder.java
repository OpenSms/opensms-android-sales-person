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
public class GsrOrder implements EntityInterface<Long>, Serializable {
    private static final long serialVersionUID = 1L;
     private Long gsrOrderId;
    private Date sellingDateTime;
      private Customer customer;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gsrOrder1", fetch = FetchType.LAZY)
//    private List<IisOrderBatchHasGsrOrder> iisOrderBatchHasGsrOrderList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gsrOrder", fetch = FetchType.LAZY)
//    private List<GsrPayment> gsrPaymentList;

    public GsrOrder() {
    }

    public GsrOrder(Long gsrOrderId) {
        this.gsrOrderId = gsrOrderId;
    }

    public GsrOrder(Long gsrOrderId, Date sellingDateTime) {
        this.gsrOrderId = gsrOrderId;
        this.sellingDateTime = sellingDateTime;
    }

    public Long getGsrOrderId() {
        return gsrOrderId;
    }

    public void setGsrOrderId(Long gsrOrderId) {
        this.gsrOrderId = gsrOrderId;
    }

    public Date getSellingDateTime() {
        return sellingDateTime;
    }

    public void setSellingDateTime(Date sellingDateTime) {
        this.sellingDateTime = sellingDateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<IisOrderBatchHasGsrOrder> getIisOrderBatchHasGsrOrderList() {
//        return iisOrderBatchHasGsrOrderList;
//    }
//
//    public void setIisOrderBatchHasGsrOrderList(List<IisOrderBatchHasGsrOrder> iisOrderBatchHasGsrOrderList) {
//        this.iisOrderBatchHasGsrOrderList = iisOrderBatchHasGsrOrderList;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public List<GsrPayment> getGsrPaymentList() {
//        return gsrPaymentList;
//    }
//
//    public void setGsrPaymentList(List<GsrPayment> gsrPaymentList) {
//        this.gsrPaymentList = gsrPaymentList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gsrOrderId != null ? gsrOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsrOrder)) {
            return false;
        }
        GsrOrder other = (GsrOrder) object;
        if ((this.gsrOrderId == null && other.gsrOrderId != null) || (this.gsrOrderId != null && !this.gsrOrderId.equals(other.gsrOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.GsrOrder[ gsrOrderId=" + gsrOrderId + " ]";
    }

    @Override
    public Long getId() {
        return gsrOrderId;
    }
}
