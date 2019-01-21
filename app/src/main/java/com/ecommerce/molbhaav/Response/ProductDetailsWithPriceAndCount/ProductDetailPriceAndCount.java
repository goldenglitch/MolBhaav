package com.ecommerce.molbhaav.Response.ProductDetailsWithPriceAndCount;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ProductDetailPriceAndCount{

	@SerializedName("productImageUrl")
	private String productImageUrl;

	@SerializedName("highestPrice")
	private int highestPrice;

	@SerializedName("lowestPrice")
	private int lowestPrice;

	@SerializedName("productId")
	private String productId;

	@SerializedName("staticAttributeList")
	private List<StaticAttributeListItem> staticAttributeList;

	@SerializedName("merchantCount")
	private int merchantCount;

	@SerializedName("productName")
	private String productName;

	@SerializedName("categoryId")
	private String categoryId;

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

	public void setHighestPrice(int highestPrice){
		this.highestPrice = highestPrice;
	}

	public int getHighestPrice(){
		return highestPrice;
	}

	public void setLowestPrice(int lowestPrice){
		this.lowestPrice = lowestPrice;
	}

	public int getLowestPrice(){
		return lowestPrice;
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

	public void setMerchantCount(int merchantCount){
		this.merchantCount = merchantCount;
	}

	public int getMerchantCount(){
		return merchantCount;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
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
			"ProductDetailPriceAndCount{" + 
			"productImageUrl = '" + productImageUrl + '\'' + 
			",highestPrice = '" + highestPrice + '\'' + 
			",lowestPrice = '" + lowestPrice + '\'' + 
			",productId = '" + productId + '\'' + 
			",staticAttributeList = '" + staticAttributeList + '\'' + 
			",merchantCount = '" + merchantCount + '\'' + 
			",productName = '" + productName + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",productDescription = '" + productDescription + '\'' + 
			",productUsp = '" + productUsp + '\'' + 
			"}";
		}
}