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

import com.map.entities.Produto;
import com.map.entities.Venda;
import com.map.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {
	private final VendaService vendaService;
	
	@Autowired
	public VendaController(VendaService vendaService) {
		this.vendaService = vendaService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Venda> buscaVendaControlId(@PathVariable Long id) {
		Venda venda = vendaService.buscaVendaById(id);
		if (venda != null) {
			return ResponseEntity.ok(venda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		@GetMapping("/")
		public ResponseEntity<List<Venda>> buscaTodosVendasControl() {
			List<Venda> Venda = vendaService.buscaTodosVenda();
			return ResponseEntity.ok(Venda);	
	}
		@PostMapping("/{id}")
		public ResponseEntity<Venda> alterarVenda(@PathVariable Long id, @RequestBody Venda venda) {
			Venda alterarVenda = vendaService.alterarVenda(id, venda);
			if (alterarVenda != null) {
				return ResponseEntity.ok(alterarVenda);
			
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<Venda> apagarVenda(@PathVariable Long id) {
			boolean apagar = vendaService.ApagarVenda(id);
			if (apagar) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
}
	


