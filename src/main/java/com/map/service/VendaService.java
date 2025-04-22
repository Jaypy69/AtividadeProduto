package com.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.Venda;
import com.map.repository.VendaRepository;

@Service
public class VendaService {
	private VendaRepository vendaRepository;
@Autowired
public VendaService(VendaRepository vendaRepository) {
	this.vendaRepository = vendaRepository;
}
public List <Venda>buscaTodosVenda() {
	return vendaRepository.findAll();
}
public Venda buscaVendaById(Long id) {
	Optional <Venda> Venda = vendaRepository.findById(id);
	return Venda.orElse(null);
}
public Venda salvarVenda(Venda venda) {
	return vendaRepository.save(venda); //erro corrido
}
public Venda alterarVenda (Long id, Venda alterarU) {
	Optional <Venda> existeVenda = vendaRepository.findById(id);
	if (existeVenda.isPresent()) {
		alterarU.setId(id);
		return vendaRepository.save(alterarU);
}
 	return null;
}
public boolean ApagarVenda(long id) {
	Optional <Venda> existeVenda = vendaRepository.findById(id);
	if (existeVenda.isPresent()) {
		 vendaRepository.deleteById(id);
		return true;
}
	return false;
}

}

