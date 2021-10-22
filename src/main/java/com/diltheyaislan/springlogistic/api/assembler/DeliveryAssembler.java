package com.diltheyaislan.springlogistic.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.diltheyaislan.springlogistic.api.domain.model.Delivery;
import com.diltheyaislan.springlogistic.api.model.DeliveryModel;
import com.diltheyaislan.springlogistic.api.model.request.DeliveryRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

	private ModelMapper modelMapper;
	
	public DeliveryModel toModel(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryModel.class);
	}
	
	public List<DeliveryModel> toCollectionModel(List<Delivery> deliveries) {
		return deliveries.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Delivery toEntity(DeliveryRequest deliveryRequest) {
		return modelMapper.map(deliveryRequest, Delivery.class);
	}
}
