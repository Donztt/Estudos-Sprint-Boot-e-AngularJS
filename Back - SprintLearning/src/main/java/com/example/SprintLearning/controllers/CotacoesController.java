package com.example.SprintLearning.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SprintLearning.RepositoryInterface.*;
import com.example.SprintLearning.Utilities.Utilitario;
import com.example.SprintLearning.models.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Cotacoes")
@CrossOrigin(origins="*")
public class CotacoesController {
	@Autowired
	ICotacoesRepository _cotacoesRepository;
	
	@GetMapping("/Cotacoes")
	@ApiOperation(value="Retorna todas as cotacoes salvas")
	public List<Cotacoes> listaCotacoes(){
		
		try {
			var json = Utilitario.pegarJSONURL("https://economia.awesomeapi.com.br/last/USD-BRL");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@      " + json.getString("name"));
		} catch (Exception e) { System.out.println("-------ERRO: "+ e.getMessage());}
		
		return _cotacoesRepository.findAll();
	}
	@GetMapping("/Cotacoes/{id}")
	@ApiOperation(value="Retonar todos os valores respectivos a moeda selecionada")
	public Cotacoes verificarMoeda(@PathVariable(value="id") long id){
		
		return _cotacoesRepository.findById(id);
	}

}
