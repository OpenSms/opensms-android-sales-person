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
 * @author dewmal
 */
public class Profit implements Serializable, EntityInterface<Integer> {
    private static final long serialVersionUID = 1L;
    private Integer profitId;
  
    private BigDecimal value;
   
    private String type;
  
    private List<Batch> batchList;
    private List<Item> itemList;

    public Profit() {
    }

    public Profit(Integer profitId) {
        this.profitId = profitId;
    }

    public Profit(Integer profitId, BigDecimal value, String type) {
        this.profitId = profitId;
        this.value = value;
        this.type = type;
    }

    public Integer getProfitId() {
        return profitId;
    }

    public void setProfitId(Integer profitId) {
        this.profitId = profitId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profitId != null ? profitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profit)) {
            return false;
        }
        Profit other = (Profit) object;
        if ((this.profitId == null && other.profitId != null) || (this.profitId != null && !this.profitId.equals(other.profitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.Profit[ profitId=" + profitId + " ]";
    }

    @Override
    public Integer getId() {
        return getProfitId();
    }
}
