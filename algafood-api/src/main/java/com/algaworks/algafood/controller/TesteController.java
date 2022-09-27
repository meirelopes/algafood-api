package com.algaworks.algafood.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping(value = "/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome (String nome){
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping(value = "/cozinhas/unica-por-nome")
	public Optional<Cozinha> cozinhaPorNome (String nome){
		return cozinhaRepository.findByNome(nome);
	}
	
	@GetMapping(value = "/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantePortaxaFrete (String nome, BigDecimal taxaFreteInicial,
			BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}
		
	/*@GetMapping(value = "/restaurantes/por-nome")
	public List<Restaurante> restaurantePorNome (String nome, Long cozinhaId){
		return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
	}*/
	
	@GetMapping(value = "/restaurantes/por-nome")
	public List<Restaurante> restaurantePorNome (String nome, Long cozinhaId){
		return restauranteRepository.consultarPorNome(nome, cozinhaId);
	}


	@GetMapping(value = "/restaurantes/primeiro-por-nome")
	public Optional<Restaurante> primeiroRestaurantePorNome (String nome){
		return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
	}

	@GetMapping(value = "/restaurantes/top2")
	public List<Restaurante> top2Restaurante (String nome){
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}

	@GetMapping(value = "/restaurantes/count")
	public int count (Long cozinhaId){
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}
	
	@GetMapping(value = "/restaurantes/por-nome-e-frete")
	public List<Restaurante> restaurantesPorNomeFrete (String nome,
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}



}
