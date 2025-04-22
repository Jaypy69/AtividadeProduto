package com.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.Cliente;
import com.map.repository.ClienteRepository;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	public List <Cliente>buscaTodosClientes() {
		return clienteRepository.findAll();
	}
	public Cliente buscaClienteById(Long id) {
		Optional <Cliente> Cliente = clienteRepository.findById(id);
		return Cliente.orElse(null);
	}
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente); //erro corrido
	}
	public Cliente alterarCliente (Long id, Cliente alterarU) {
		Optional <Cliente> existeCliente = clienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			alterarU.setId(id);
			return clienteRepository.save(alterarU);
	}
	 	return null;
	}
	public boolean ApagarCliente(long id) {
		Optional <Cliente> existeCliente = clienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			clienteRepository.deleteById(id);
			return true;
	}
		return false;
	}
	
}
