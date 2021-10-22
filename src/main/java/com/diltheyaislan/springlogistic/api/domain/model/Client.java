package com.diltheyaislan.springlogistic.api.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.diltheyaislan.springlogistic.api.domain.validation.ValidationGroups;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Client {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups = ValidationGroups.ClientId.class)
	private Long id;
	
 	@Column
 	@NotBlank
	@Size(max = 60)
 	private String name;
 	
 	@Column
	@NotBlank
	@Email
	@Size(max = 60)
 	private String email;
 	
 	@Column
	@NotBlank
	@Size(max = 20)
	private String phoneNumber;
}
