package com.diltheyaislan.springlogistic.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diltheyaislan.springlogistic.api.assembler.OcorrencyAssembler;
import com.diltheyaislan.springlogistic.api.domain.model.Delivery;
import com.diltheyaislan.springlogistic.api.domain.service.FindDeliveryService;
import com.diltheyaislan.springlogistic.api.domain.service.OcorrencyRegisterService;
import com.diltheyaislan.springlogistic.api.model.OcorrencyModel;
import com.diltheyaislan.springlogistic.api.model.request.OcorrencyRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/ocorrencies")
public class OcorrencyController {
	
	private OcorrencyRegisterService ocorrencyRegisterService;
	private OcorrencyAssembler ocorrencyAssembler;
	private FindDeliveryService findDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrencyModel register(@PathVariable Long deliveryId, 
			@Valid @RequestBody OcorrencyRequest ocorrencyRequest) {
		var ocorrency = ocorrencyRegisterService.register(deliveryId, ocorrencyRequest.getDescription());
		return ocorrencyAssembler.toModel(ocorrency);
	}
	
	@GetMapping
	public List<OcorrencyModel> list(@PathVariable Long deliveryId) {
		Delivery delivery = findDeliveryService.findById(deliveryId);
		return ocorrencyAssembler.toCollectionModel(delivery.getOcorrencies());
	}
}
