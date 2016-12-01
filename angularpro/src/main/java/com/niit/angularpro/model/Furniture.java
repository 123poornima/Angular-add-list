package com.niit.angularpro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Furniture")
@Component 
public class Furniture
{
	@Id
    private String p_id; 
	private String p_name;
	private int p_price;
	private String p_description;
	private String category_id;
	//private String supplier_id;
	
	  @ManyToOne
	  @JoinColumn(name="category_id",nullable=false,updatable=false,insertable=false)
	  private Category  category;
	  
	 
	
	  
  public String getp_id() {
	return p_id;
}

public void setp_id(String p_id) {
	this.p_id =  p_id;
}

public String getp_name() {
	return p_name;
}

public void setp_name(String p_name) {
	this.p_name = p_name;
}

public int getp_price() {
	return p_price;
}

public void setp_price(int p_price) {
	this.p_price = p_price;
}

public String getp_description() {
	return p_description;
}

public void setp_description(String p_description) {
	this.p_description = p_description;
}


 
  
public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}



public String getCategory_ID() {
	return category_id;
}

public void setCategory_ID(String category_id) {
	this.category_id = category_id;
}


}
