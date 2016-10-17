package com.granitetransformations.Pricing.Model;

public class GranteColorsModel {
	private final String key;
	private final String value;
	
	public GranteColorsModel(String key, String value){
		this.key = key;
		this.value = value;
	}
	public String getKey(){ return key; }
	public String toStringColor(){ return value; }

}