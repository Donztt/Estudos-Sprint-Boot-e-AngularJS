package com.example.SprintLearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SprintLearning.ServiceInterface.CotacoesService;
import com.example.SprintLearning.models.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Cotacoes")
@CrossOrigin(origins = "*")
public class CotacoesController {

	@Autowired
	private CotacoesService _cotacoesService;

	@GetMapping("/Cotacoes")
	@ApiOperation(value = "Retorna todas as cotacoes salvas")
	public List<Cotacoes> listaCotacoes() {

		return _cotacoesService.RetornarTodasCotacoes();
	}

	@GetMapping("/Cotacoes/{id}")
	@ApiOperation(value = "Retonar todos os valores respectivos a moeda selecionada")
	public Cotacoes verificarMoeda(@PathVariable(value = "id") long id) {

		return _cotacoesService.RetornarCotacao(id);
	}

	@PostMapping("/Cotacoes/Dolar")
	@ApiOperation(value = "Retorna o valor mais recente do Dólar")
	public Cotacoes getValorMaisRecente() {

		return _cotacoesService.AddNovaCotacao();
	}

}
