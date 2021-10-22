package com.diltheyaislan.springlogistic.api.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diltheyaislan.springlogistic.api.domain.exception.BusinessException;
import com.diltheyaislan.springlogistic.api.domain.model.Client;
import com.diltheyaislan.springlogistic.api.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientService {

	private ClientRepository clientRepository;
	
	public Client getById(Long clientId) {
		return clientRepository.findById(clientId)
				.orElseThrow(() -> new BusinessException("Client not found"));
	}
	
	@Transactional
	public Client save(Client client) {
		boolean emailInUse = clientRepository
				.findByEmail(client.getEmail())
				.stream()
				.anyMatch(foundClient -> !foundClient.equals(client));
		
		if (emailInUse) {
			throw new BusinessException("Email already in use");
		}
		
		return clientRepository.save(client);
	}
	
	@Transactional
	public void delete(Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
