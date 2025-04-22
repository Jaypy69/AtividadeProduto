package com.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.map.entities.ItemVenda;
import com.map.service.ItemVendaService;

@RestController
@RequestMapping("/itemvenda")
public class ItemVendaController {
	private final ItemVendaService itemvendaService;
	@Autowired
	public ItemVendaController(ItemVendaService itemvendaService) {
		this.itemvendaService = itemvendaService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<ItemVenda> buscaItemVendaControlId(@PathVariable Long id) {
		ItemVenda itemvenda = itemvendaService.buscaItemVendaById(id);
		if (itemvenda != null) {
			return ResponseEntity.ok(itemvenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		@GetMapping("/")
		public ResponseEntity<List<ItemVenda>> buscaTodosItemVendasControl() {
			List<ItemVenda> ItemVendas = itemvendaService.buscaTodosItemVenda();
			return ResponseEntity.ok(ItemVendas);	
	}
		@PostMapping("/{id}")
		public ResponseEntity<ItemVenda> alterarItemVenda(@PathVariable Long id, @RequestBody ItemVenda itemvenda) {
			ItemVenda alterarItemVenda = itemvendaService.alterarItemVenda(id, itemvenda);
			if (alterarItemVenda != null) {
				return ResponseEntity.ok(alterarItemVenda);
			
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<ItemVenda> apagarItemVenda(@PathVariable Long id) {
			boolean apagar = itemvendaService.ApagarItemVenda(id);
			if (apagar) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
}
