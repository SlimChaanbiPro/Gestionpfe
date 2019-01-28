package com.slim.Dto;

import lombok.Data;


public class OptionDTO {
 
	private String type;
	private String description;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public OptionDTO(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}
	public OptionDTO() {
		super();
	}
	
}
