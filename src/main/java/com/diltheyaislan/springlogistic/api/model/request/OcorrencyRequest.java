package com.diltheyaislan.springlogistic.api.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrencyRequest {

	@NotBlank
	private String description;
}
