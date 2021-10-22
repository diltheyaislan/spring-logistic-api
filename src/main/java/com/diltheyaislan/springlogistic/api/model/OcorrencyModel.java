package com.diltheyaislan.springlogistic.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrencyModel {

	private Long id;
	private String description;
	private OffsetDateTime registerDate;
}
