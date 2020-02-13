package com.qa.ims.persistence.domain;

public class Items {

	private Long item_id;
	private String item_name;
	private Long cost;
	
	public Items(String item_name, long cost) {
		this.item_name = item_name;
		this.cost = cost;
	}

	public Items(long item_id, String item_name, long cost) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.cost = cost;
	}
	


	public long getItem_Id() {
		return item_id;
	}

	public void setItem_Id(long item_id) {
		this.item_id = item_id;
	}

	public String getItem_Name() {
		return item_name;
	}

	public void setItem_Name(String item_name) {
		this.item_name = item_name;
	}

	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}

	public Items(long cost) {
		this.cost = cost;
	}

	public Items(String item_id, String item_name, String string) {
		// TODO Auto-generated constructor stub
	}

	public Items(Object item_name, Object object) {
		// TODO Auto-generated constructor stub
	}

	public Items(long l, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Items(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "item_id:" + item_id + " item name:" + item_name + " cost:" + cost;
	}
	@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
	result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
	result = prime * result + ((cost == null) ? 0 : cost.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Items other = (Items) obj;
	if (item_name == null) {
		if (other.item_name != null)
			return false;
	} else if (!item_name.equals(other.item_name))
		return false;
	if (item_id == null) {
		if (other.item_id != null)
			return false;
	} else if (!item_id.equals(other.item_id))
		return false;
	if (cost == null) {
		if (other.cost != null)
			return false;
	} else if (!cost.equals(other.cost))
		return false;
	return true;
}

public void setOrder_Id(Object object) {
	// TODO Auto-generated method stub
	
}

public void setCost(Object object) {
	// TODO Auto-generated method stub
	
}

public void setItem_Id(Object object) {
	// TODO Auto-generated method stub
	
}

}