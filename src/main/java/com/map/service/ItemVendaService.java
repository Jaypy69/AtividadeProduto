package com.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.ItemVenda;
import com.map.repository.ItemVendaRepository;

@Service
public class ItemVendaService {
	private final ItemVendaRepository itemvendaRepository;

	@Autowired
	public ItemVendaService(ItemVendaRepository itemvendaRepository) {
		this.itemvendaRepository = itemvendaRepository;
	}

	public List<ItemVenda> buscaTodosItemVenda() {
		return itemvendaRepository.findAll();
	}

	public ItemVenda buscaItemVendaById(Long id) {
		Optional<ItemVenda> ItemVenda = itemvendaRepository.findById(id);
		return ItemVenda.orElse(null);
	}

	public ItemVenda salvarItemVenda(ItemVenda itemvenda) {
		return itemvendaRepository.save(itemvenda); // erro corrido
	}

	public ItemVenda alterarItemVenda(Long id, ItemVenda alterarU) {
		Optional<ItemVenda> existeItemVenda = itemvendaRepository.findById(id);
		if (existeItemVenda.isPresent()) {
			alterarU.setId(id);
			return itemvendaRepository.save(alterarU);
		}
		return null;
	}

	public boolean ApagarItemVenda(long id) {
		Optional<ItemVenda> existeItemVenda = itemvendaRepository.findById(id);
		if (existeItemVenda.isPresent()) {
			itemvendaRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
