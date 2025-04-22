package com.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.map.entities.Produto;
import com.map.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private ProdutoRepository produtoRepository;
@Autowired
public ProdutoService(ProdutoRepository ProdutoRepository) {
	this.produtoRepository = produtoRepository;
}
public List <Produto>BuscaProduto() {
	return produtoRepository.findAll();
}
public Produto buscaProdutoById(Long id) {
	Optional <Produto> Produto = produtoRepository.findById(id);
	return Produto.orElse(null);
}
public Produto salvarProduto(Produto produto) {
	return produtoRepository.save(produto); //erro corrido
}
public Produto alterarProduto (Long id, Produto alterarU) {
	Optional <Produto> existeProduto = produtoRepository.findById(id);
	if (existeProduto.isPresent()) {
		alterarU.setId(id);
		return produtoRepository.save(alterarU);
}
 	return null;
}
public boolean ApagarProduto(long id) {
	Optional <Produto> existeProduto = produtoRepository.findById(id);
	if (existeProduto.isPresent()) {
		 produtoRepository.deleteById(id);
		return true;
}
	return false;
}

}
