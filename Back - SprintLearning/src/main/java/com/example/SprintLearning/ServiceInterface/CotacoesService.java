package com.example.SprintLearning.ServiceInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SprintLearning.RepositoryInterface.ICotacoesRepository;
import com.example.SprintLearning.Utilities.Utilitario;
import com.example.SprintLearning.models.Cotacoes;

@Service
public class CotacoesService {
	
	@Autowired
	private ICotacoesRepository _cotacoesRepository;
	@Autowired
	private MoedaService _moedaService;
	
	public Cotacoes AddNovaCotacao() {
		var json = Utilitario.pegarJSONURL("https://economia.awesomeapi.com.br/last/USD-BRL");

		Cotacoes cotacao = new Cotacoes();
		try {
			Date data = new Date(System.currentTimeMillis());
			Long idMoeda = _moedaService.PegarIdPeloNome(json.getJSONObject("USDBRL").getString("code"));
			Double valorMoeda = Double.parseDouble(json.getJSONObject("USDBRL").getString("low"));

			cotacao.setData(data);
			cotacao.setIdMoeda(idMoeda);
			cotacao.setValor(valorMoeda);

			_cotacoesRepository.save(cotacao);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return cotacao;
	}
	public Cotacoes RetornarCotacao(long id) {
		return _cotacoesRepository.findById(id);
	}
	public List<Cotacoes> RetornarTodasCotacoes() {
		return (List<Cotacoes>) _cotacoesRepository.findAll();
	}
}
