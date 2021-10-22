package com.diltheyaislan.springlogistic.api.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Recipient {

	@NotBlank
	@Column(name = "recipient_name")
	private String name;
	
	@NotBlank
	@Column(name = "recipient_address")
	private String address;
	
	@NotBlank
	@Column(name = "recipient_address_number")
	private String addressNumber;
	
	@Column(name = "recipient_address_additional")
	private String addressAdditional;
	
	@NotBlank
	@Column(name = "recipient_address_district")
	private String addressDistrict;
}
