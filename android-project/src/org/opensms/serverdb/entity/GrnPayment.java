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
public class GrnPayment implements Serializable, EntityInterface<Long>  {
    private static final long serialVersionUID = 1L;
    private Long payementId;
    private BigDecimal amount;
      private Date paymentDate;
      private PaymentMethod paymentMethod;
      private GrnOrder grnOrder;
     private Employee cashierEmployee;

    public GrnPayment() {
    }

    public GrnPayment(Long payementId) {
        this.payementId = payementId;
    }

    public GrnPayment(Long payementId, BigDecimal amount, Date paymentDate) {
        this.payementId = payementId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Long getPayementId() {
        return payementId;
    }

    public void setPayementId(Long payementId) {
        this.payementId = payementId;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public GrnOrder getGrnOrder() {
        return grnOrder;
    }

    public void setGrnOrder(GrnOrder grnOrder) {
        this.grnOrder = grnOrder;
    }

    public Employee getCashierEmployee() {
        return cashierEmployee;
    }

    public void setCashierEmployee(Employee cashierEmployee) {
        this.cashierEmployee = cashierEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payementId != null ? payementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrnPayment)) {
            return false;
        }
        GrnPayment other = (GrnPayment) object;
        if ((this.payementId == null && other.payementId != null) || (this.payementId != null && !this.payementId.equals(other.payementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.GrnPayment[ payementId=" + payementId + " ]";
    }

    @Override
    public Long getId() {
        return getPayementId();
    }
}
