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
public class PaymentMethod implements Serializable, EntityInterface<Integer> {
    private static final long serialVersionUID = 1L;
  
    private Integer paymentMethodId;
   
    private String description;
    private List<GrnPayment> grnPaymentList;
    private List<GsrPayment> gsrPaymentList;

    public PaymentMethod() {
    }

    public PaymentMethod(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public PaymentMethod(Integer paymentMethodId, String description) {
        this.paymentMethodId = paymentMethodId;
        this.description = description;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GrnPayment> getGrnPaymentList() {
        return grnPaymentList;
    }

    public void setGrnPaymentList(List<GrnPayment> grnPaymentList) {
        this.grnPaymentList = grnPaymentList;
    }

    public List<GsrPayment> getGsrPaymentList() {
        return gsrPaymentList;
    }

    public void setGsrPaymentList(List<GsrPayment> gsrPaymentList) {
        this.gsrPaymentList = gsrPaymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod other = (PaymentMethod) object;
        if ((this.paymentMethodId == null && other.paymentMethodId != null) || (this.paymentMethodId != null && !this.paymentMethodId.equals(other.paymentMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.PaymentMethod[ paymentMethodId=" + paymentMethodId + " ]";
    }

    @Override
    public Integer getId() {
        return getPaymentMethodId();
    }
}
