package com.diltheyaislan.springlogistic.api.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.diltheyaislan.springlogistic.api.domain.model.Delivery;
import com.diltheyaislan.springlogistic.api.domain.model.Ocorrency;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OcorrencyRegisterService {

	private FindDeliveryService findDeliveryService;
	
	@Transactional
	public Ocorrency register(Long deliveryId, String description) {
		Delivery delivery = findDeliveryService.findById(deliveryId);
		return delivery.addOcorrency(description);
	}
}
