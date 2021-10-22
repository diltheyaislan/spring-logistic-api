package com.diltheyaislan.springlogistic.api.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diltheyaislan.springlogistic.api.domain.model.Client;
import com.diltheyaislan.springlogistic.api.domain.model.Delivery;
import com.diltheyaislan.springlogistic.api.domain.model.StatusDelivery;
import com.diltheyaislan.springlogistic.api.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryOrderService {

	private ClientService clientService;
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public Delivery order(Delivery delivery) {
		Client client = clientService.getById(delivery.getClient().getId());
		
		delivery.setClient(client);
		delivery.setStatus(StatusDelivery.PENDING);
		delivery.setOrderDate(OffsetDateTime.now());
		
		return deliveryRepository.save(delivery);
	}
}
