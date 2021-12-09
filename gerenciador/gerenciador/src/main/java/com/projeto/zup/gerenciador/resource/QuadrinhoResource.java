package com.projeto.zup.gerenciador.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.zup.gerenciador.repositories.QuadrinhoRepository;
import com.projeto.zup.gerenciador.models.Quadrinho;

@RestController
@RequestMapping(path="/quadrinhos")

public class QuadrinhoResource {

	private QuadrinhoRepository quadrinhoRepository;
	
	public QuadrinhoResource(QuadrinhoRepository quadrinhoRepository) {
		super();
		this.quadrinhoRepository = quadrinhoRepository;
	}
	
	@PostMapping
	public ResponseEntity<Quadrinho> save(@RequestBody Quadrinho quadrinho){
		quadrinhoRepository.save(quadrinho);
		return new ResponseEntity<>(quadrinho, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Quadrinho>> getAll(){
		List<Quadrinho> quadrinhos = new ArrayList<>();
		quadrinhos = quadrinhoRepository.findAll();
		return new ResponseEntity<>(quadrinhos, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Quadrinho>> getById(@PathVariable Integer id){
		Optional<Quadrinho> quadrinho;
		try {
			quadrinho = quadrinhoRepository.findById(id);
			return new ResponseEntity<Optional<Quadrinho>>(quadrinho, HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Quadrinho>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Quadrinho>> deleteById(@PathVariable Integer id){
		try {
			quadrinhoRepository.deleteById(id);
			return new ResponseEntity<Optional<Quadrinho>>(HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Quadrinho>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Quadrinho> update(@PathVariable Integer id, @RequestBody Quadrinho newQuadrinho){		
		 return quadrinhoRepository.findById(id)
		           .map(quadrinho -> {
		        	   quadrinho.setTitulo(newQuadrinho.getTitulo());
		        	   quadrinho.setPreco(newQuadrinho.getPreco());
		        	   quadrinho.setAutores(newQuadrinho.getAutores());
		        	   quadrinho.setIsbn(newQuadrinho.getIsbn());
		        	   quadrinho.setDescricao(newQuadrinho.getDescricao());
		        	   Quadrinho quadrinhoUpdated = quadrinhoRepository.save(quadrinho);
		               return ResponseEntity.ok().body(quadrinhoUpdated);
		           }).orElse(ResponseEntity.notFound().build());
	}

	
}
