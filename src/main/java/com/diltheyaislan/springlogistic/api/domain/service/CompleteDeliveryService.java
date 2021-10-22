package com.diltheyaislan.springlogistic.api.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.diltheyaislan.springlogistic.api.domain.model.Delivery;
import com.diltheyaislan.springlogistic.api.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CompleteDeliveryService {

	private DeliveryRepository deliveryRepository;
	private FindDeliveryService findDeliveryService;
	
	@Transactional
	public void complete(Long deliveryId) {
		Delivery delivery = findDeliveryService.findById(deliveryId);
		
		delivery.complete();
		
		deliveryRepository.save(delivery);
	}
}
