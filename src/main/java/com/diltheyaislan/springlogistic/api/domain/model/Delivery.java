package com.diltheyaislan.springlogistic.api.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.diltheyaislan.springlogistic.api.domain.exception.BusinessException;
import com.diltheyaislan.springlogistic.api.domain.validation.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
	@NotNull
	@ManyToOne
	private Client client;
	
	@Valid
	@NotNull
	@Embedded
	private Recipient recipient;
	
	@NotNull
	private BigDecimal fee;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Ocorrency> ocorrencies = new ArrayList<>();
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusDelivery status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime orderDate;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime completedDate;

	public Ocorrency addOcorrency(String description) {
		Ocorrency ocorrency = new Ocorrency();
		ocorrency.setDescription(description);
		ocorrency.setRegisterDate(OffsetDateTime.now());
		ocorrency.setDelivery(this);
		
		this.ocorrencies.add(ocorrency);
		
		return ocorrency;
	}

	public void complete() {
		if (!canCompleted()) {
			throw new BusinessException("Current delivery status is invalid");
		}
		
		setStatus(StatusDelivery.COMPLETED);
		setCompletedDate(OffsetDateTime.now());
	}
	
	public boolean canCompleted() {
		return getStatus().equals(StatusDelivery.PENDING);
	}
}
