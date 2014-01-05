/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensms.serverdb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author dewmal
 */
public class IisOrder implements Serializable, EntityInterface<Long> {
	private static final long serialVersionUID = 1L;
	private Long iisOrderId;
	private Date issOrderDateTime;
	private List<PreOrder> preOrderList;
	private Employee salesEmployee;
	private Employee returnCheckEmployee;
	private Employee itemIssuerEmployee;

	public IisOrder() {
	}

	public IisOrder(Long iisOrderId) {
		this.iisOrderId = iisOrderId;
	}

	public IisOrder(Long iisOrderId, Date issOrderDateTime) {
		this.iisOrderId = iisOrderId;
		this.issOrderDateTime = issOrderDateTime;
	}

	public Long getIisOrderId() {
		return iisOrderId;
	}

	public void setIisOrderId(Long iisOrderId) {
		this.iisOrderId = iisOrderId;
	}

	public Date getIssOrderDateTime() {
		return issOrderDateTime;
	}

	public void setIssOrderDateTime(Date issOrderDateTime) {
		this.issOrderDateTime = issOrderDateTime;
	}

	@JsonIgnore
	public List<PreOrder> getPreOrderList() {
		return preOrderList;
	}

	public void setPreOrderList(List<PreOrder> preOrderList) {
		this.preOrderList = preOrderList;
	}

	public Employee getSalesEmployee() {
		return salesEmployee;
	}

	public void setSalesEmployee(Employee salesEmployee) {
		this.salesEmployee = salesEmployee;
	}

	public Employee getReturnCheckEmployee() {
		return returnCheckEmployee;
	}

	public void setReturnCheckEmployee(Employee returnCheckEmployee) {
		this.returnCheckEmployee = returnCheckEmployee;
	}

	public Employee getItemIssuerEmployee() {
		return itemIssuerEmployee;
	}

	public void setItemIssuerEmployee(Employee itemIssuerEmployee) {
		this.itemIssuerEmployee = itemIssuerEmployee;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (iisOrderId != null ? iisOrderId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof IisOrder)) {
			return false;
		}
		IisOrder other = (IisOrder) object;
		if ((this.iisOrderId == null && other.iisOrderId != null)
				|| (this.iisOrderId != null && !this.iisOrderId
						.equals(other.iisOrderId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.opensms.app.db.entity.IisOrder[ iisOrderId=" + iisOrderId
				+ " ]";
	}

	@Override
	public Long getId() {
		return iisOrderId;
	}
}
