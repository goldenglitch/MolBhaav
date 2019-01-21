package com.ecommerce.molbhaav.Response.ParticularCategoryPageResponse;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ProductByCategory{

	@SerializedName("productImageUrl")
	private String productImageUrl;

	@SerializedName("productId")
	private String productId;

	@SerializedName("staticAttributeList")
	private List<StaticAttributeListItem> staticAttributeList;

	@SerializedName("category")
	private Category category;

	@SerializedName("productName")
	private String productName;

	@SerializedName("productDescription")
	private String productDescription;

	@SerializedName("productUsp")
	private String productUsp;

	public void setProductImageUrl(String productImageUrl){
		this.productImageUrl = productImageUrl;
	}

	public String getProductImageUrl(){
		return productImageUrl;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setStaticAttributeList(List<StaticAttributeListItem> staticAttributeList){
		this.staticAttributeList = staticAttributeList;
	}

	public List<StaticAttributeListItem> getStaticAttributeList(){
		return staticAttributeList;
	}

	public void setCategory(Category category){
		this.category = category;
	}

	public Category getCategory(){
		return category;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setProductUsp(String productUsp){
		this.productUsp = productUsp;
	}

	public String getProductUsp(){
		return productUsp;
	}

	@Override
 	public String toString(){
		return 
			"ProductByCategory{" + 
			"productImageUrl = '" + productImageUrl + '\'' + 
			",productId = '" + productId + '\'' + 
			",staticAttributeList = '" + staticAttributeList + '\'' + 
			",category = '" + category + '\'' + 
			",productName = '" + productName + '\'' + 
			",productDescription = '" + productDescription + '\'' + 
			",productUsp = '" + productUsp + '\'' + 
			"}";
		}
}