/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensms.serverdb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author dewmal
 */
public class GsrPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long gsrPaymentId;
     private BigDecimal amount;
      private Date paymentDate;
     private GsrOrder gsrOrder;
     private Employee cashierEmployee;
     private PaymentMethod paymentMethod;

    public GsrPayment() {
    }

    public GsrPayment(Long gsrPaymentId) {
        this.gsrPaymentId = gsrPaymentId;
    }

    public GsrPayment(Long gsrPaymentId, BigDecimal amount, Date paymentDate) {
        this.gsrPaymentId = gsrPaymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Long getGsrPaymentId() {
        return gsrPaymentId;
    }

    public void setGsrPaymentId(Long gsrPaymentId) {
        this.gsrPaymentId = gsrPaymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public GsrOrder getGsrOrder() {
        return gsrOrder;
    }

    public void setGsrOrder(GsrOrder gsrOrder) {
        this.gsrOrder = gsrOrder;
    }

    public Employee getCashierEmployee() {
        return cashierEmployee;
    }

    public void setCashierEmployee(Employee cashierEmployee) {
        this.cashierEmployee = cashierEmployee;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gsrPaymentId != null ? gsrPaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsrPayment)) {
            return false;
        }
        GsrPayment other = (GsrPayment) object;
        if ((this.gsrPaymentId == null && other.gsrPaymentId != null) || (this.gsrPaymentId != null && !this.gsrPaymentId.equals(other.gsrPaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.GsrPayment[ gsrPaymentId=" + gsrPaymentId + " ]";
    }
    
}
