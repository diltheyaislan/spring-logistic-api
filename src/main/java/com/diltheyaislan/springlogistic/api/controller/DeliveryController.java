package com.diltheyaislan.springlogistic.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diltheyaislan.springlogistic.api.assembler.DeliveryAssembler;
import com.diltheyaislan.springlogistic.api.domain.repository.DeliveryRepository;
import com.diltheyaislan.springlogistic.api.domain.service.CompleteDeliveryService;
import com.diltheyaislan.springlogistic.api.domain.service.DeliveryOrderService;
import com.diltheyaislan.springlogistic.api.model.DeliveryModel;
import com.diltheyaislan.springlogistic.api.model.request.DeliveryRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	private DeliveryRepository deliveryRepository;
	private DeliveryOrderService deliveryOrderService;
	private CompleteDeliveryService completeDeliveryService;
	
	private DeliveryAssembler deliveryAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryModel order(@Valid @RequestBody DeliveryRequest deliveryRequest) {
		var delivery = deliveryOrderService.order(deliveryAssembler.toEntity(deliveryRequest));
		return deliveryAssembler.toModel(delivery);
	}
	
	@GetMapping
	public List<DeliveryModel> list() {
		return  deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
	}
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryModel> findById(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{deliveryId}/complete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void complete(@PathVariable Long deliveryId) {
		completeDeliveryService.complete(deliveryId);
	}
}
