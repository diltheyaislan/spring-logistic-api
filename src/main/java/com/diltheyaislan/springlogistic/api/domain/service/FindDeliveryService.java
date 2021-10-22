package com.diltheyaislan.springlogistic.api.domain.service;

import org.springframework.stereotype.Service;

import com.diltheyaislan.springlogistic.api.domain.exception.NotFoundEntityBusinessException;
import com.diltheyaislan.springlogistic.api.domain.model.Delivery;
import com.diltheyaislan.springlogistic.api.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindDeliveryService {

	private DeliveryRepository deliveryRepository;
	
	public Delivery findById(Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new NotFoundEntityBusinessException("Delivery not found"));
	}
}
