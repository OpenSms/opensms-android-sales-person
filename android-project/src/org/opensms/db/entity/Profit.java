package org.opensms.db.entity;

public class Profit {
	
    private Integer profitId;

    private double value;

    private String type;

	public Integer getProfitId() {
		return profitId;
	}

	public void setProfitId(Integer profitId) {
		this.profitId = profitId;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    

}
