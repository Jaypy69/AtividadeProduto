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
import com.map.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	private final ProdutoService produtoService;
	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable Long id) {
		Produto produto = produtoService.buscaProdutoById(id);
		if (produto != null) {
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		@GetMapping("/")
		public ResponseEntity<List<Produto>> buscaTodosProdutosControl() {
			List<Produto> Produtos = produtoService.BuscaProduto();
			return ResponseEntity.ok(Produtos);	
	}
		@PostMapping("/{id}")
		public ResponseEntity<Produto> alterarProduto(@PathVariable Long id, @RequestBody Produto produto) {
			Produto alterarProduto = produtoService.alterarProduto(id, produto);
			if (alterarProduto != null) {
				return ResponseEntity.ok(alterarProduto);
			
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<Produto> apagarProduto(@PathVariable Long id) {
			boolean apagar = produtoService.ApagarProduto(id);
			if (apagar) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
}
	
		
	

