package com.diltheyaislan.springlogistic.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.diltheyaislan.springlogistic.api.domain.model.Ocorrency;
import com.diltheyaislan.springlogistic.api.model.OcorrencyModel;
import com.diltheyaislan.springlogistic.api.model.request.OcorrencyRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrencyAssembler {

	private ModelMapper modelMapper;
	
	public OcorrencyModel toModel(Ocorrency Ocorrency) {
		return modelMapper.map(Ocorrency, OcorrencyModel.class);
	}
	
	public List<OcorrencyModel> toCollectionModel(List<Ocorrency> deliveries) {
		return deliveries.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Ocorrency toEntity(OcorrencyRequest OcorrencyRequest) {
		return modelMapper.map(OcorrencyRequest, Ocorrency.class);
	}
}
