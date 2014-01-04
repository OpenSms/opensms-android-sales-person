package org.opensms.db.entity;

public class ToDo {
	private Customer customer;
    private PreOrder preOrder;

    public ToDo(Customer customer, PreOrder preOrder) {
        this.customer = customer;
        this.preOrder = preOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PreOrder getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(PreOrder preOrder) {
        this.preOrder = preOrder;
    }

}
