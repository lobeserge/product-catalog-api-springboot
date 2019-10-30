package com.gotraining.productcatalogapi.entity;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Product {
	
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int productid;

private String productname;
private long quantity;
private long price;



public Product() {
	super();
}



public Product(int productid, String productname, long quantity, long price) {
	super();
	this.productid = productid;
	this.productname = productname;
	this.quantity = quantity;
	this.price = price;
}


@ApiModelProperty(hidden = true)
public int getProductid() {
	return productid;
}

public void setProductid(int productid) {
	this.productid = productid;
}


public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
}

public long getQuantity() {
	return quantity;
}

public void setQuantity(long quantity) {
	this.quantity = quantity;
}

public long getPrice() {
	return price;
}

public void setPrice(long price) {
	this.price = price;
}


@ManyToOne(fetch=FetchType.LAZY)
private Category category;

@ApiModelProperty(hidden = true)
public Category getCategory() {
	return new Category(getCategoryId(),getCategoryName());
}

@JsonIgnore
public int getCategoryId() {
	return category.getCategoryid();
}

@JsonIgnore
public String getCategoryName() {
	return category.getCategoryname();
}

public Product setCategory(Category category) {
	this.category = category;
	return this;
}



@Override
public String toString() {
	return "Product [productid=" + productid + ", quantity=" + quantity + ", price=" + price + "]";
}


	
}