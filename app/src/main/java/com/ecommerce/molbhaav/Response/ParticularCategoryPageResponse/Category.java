package com.ecommerce.molbhaav.Response.ParticularCategoryPageResponse;


import com.google.gson.annotations.SerializedName;

public class Category{

	@SerializedName("categoryImageUrl")
	private String categoryImageUrl;

	@SerializedName("categoryName")
	private String categoryName;

	@SerializedName("categoryId")
	private String categoryId;

	public void setCategoryImageUrl(String categoryImageUrl){
		this.categoryImageUrl = categoryImageUrl;
	}

	public String getCategoryImageUrl(){
		return categoryImageUrl;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return categoryName;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	@Override
 	public String toString(){
		return 
			"Category{" + 
			"categoryImageUrl = '" + categoryImageUrl + '\'' + 
			",categoryName = '" + categoryName + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			"}";
		}
}