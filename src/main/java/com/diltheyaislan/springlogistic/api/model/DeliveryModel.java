package com.diltheyaislan.springlogistic.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import com.diltheyaislan.springlogistic.api.domain.model.StatusDelivery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryModel {

	private Long id;
	private ClientCompactModel client;
	private RecipientModel recipient;
	private BigDecimal fee;
	private StatusDelivery status;
	private OffsetDateTime orderDate;
	private OffsetDateTime completedDate;
	private List<OcorrencyModel> ocorrencies;
}
