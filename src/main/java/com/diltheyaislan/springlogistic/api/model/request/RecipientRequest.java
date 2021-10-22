package com.diltheyaislan.springlogistic.api.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientRequest {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String addressNumber;
	
	private String addressAdditional;
	
	@NotBlank
	private String addressDistrict;
}
