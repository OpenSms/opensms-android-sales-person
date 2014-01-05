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
public class Unit implements Serializable, EntityInterface<Integer> {

    private static final long serialVersionUID = 1L;
    private Integer unitId;
    private String unit;
    private List<Item> itemList;

    public Unit() {
    }

    public Unit(Integer unitId) {
        this.unitId = unitId;
    }

    public Unit(Integer unitId, String unit) {
        this.unitId = unitId;
        this.unit = unit;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitId != null ? unitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.unitId == null && other.unitId != null) || (this.unitId != null && !this.unitId.equals(other.unitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.opensms.app.db.entity.Unit[ unitId=" + unitId + " ]";
    }

    @Override
    public Integer getId() {
        return getUnitId();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
