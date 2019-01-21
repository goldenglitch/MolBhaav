package com.ecommerce.molbhaav.Response.ParticularCategoryPageResponse;


import com.google.gson.annotations.SerializedName;


public class StaticAttributeListItem{

	@SerializedName("attributeDescription")
	private String attributeDescription;

	@SerializedName("attribute")
	private String attribute;

	public void setAttributeDescription(String attributeDescription){
		this.attributeDescription = attributeDescription;
	}

	public String getAttributeDescription(){
		return attributeDescription;
	}

	public void setAttribute(String attribute){
		this.attribute = attribute;
	}

	public String getAttribute(){
		return attribute;
	}

	@Override
 	public String toString(){
		return 
			"StaticAttributeListItem{" + 
			"attributeDescription = '" + attributeDescription + '\'' + 
			",attribute = '" + attribute + '\'' + 
			"}";
		}
}