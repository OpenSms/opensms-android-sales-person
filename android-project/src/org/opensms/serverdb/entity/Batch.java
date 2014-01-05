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
public class Batch implements Serializable ,EntityInterface<String>{
    private static final long serialVersionUID = 1L;
  private String batchCode;
    private BigDecimal buyingUnitPrice;
     private BigDecimal quantity;
     private Profit profit;
     private Item item;
   private GrnOrder grnOrder;
     private Date expireDate;
      private BigDecimal remainingQuantity;

    public Batch() {
    }

    public Batch(String batchCode) {
        this.batchCode = batchCode;
    }

    public Batch(String batchCode, BigDecimal buyingUnitPrice, BigDecimal quantity) {
        this.batchCode = batchCode;
        this.buyingUnitPrice = buyingUnitPrice;
        this.quantity = quantity;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public BigDecimal getBuyingUnitPrice() {
        return buyingUnitPrice;
    }

    public void setBuyingUnitPrice(BigDecimal buyingUnitPrice) {
        this.buyingUnitPrice = buyingUnitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Profit getProfit() {
        return profit;
    }

    public void setProfit(Profit profit) {
        this.profit = profit;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public GrnOrder getGrnOrder() {
        return grnOrder;
    }

    public void setGrnOrder(GrnOrder grnOrder) {
        this.grnOrder = grnOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (batchCode != null ? batchCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Batch)) {
            return false;
        }
        Batch other = (Batch) object;
        if ((this.batchCode == null && other.batchCode != null) || (this.batchCode != null && !this.batchCode.equals(other.batchCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.Batch[ batchCode=" + batchCode + " ]";
    }

    @Override
    public String getId() {
       return getBatchCode();
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public BigDecimal getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(BigDecimal remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }
}
