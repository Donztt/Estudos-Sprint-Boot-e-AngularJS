package com.example.SprintLearning.ServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SprintLearning.RepositoryInterface.IMoedaRepository;

@Service
public class MoedaService {
	@Autowired
	private IMoedaRepository _moedaRepository;
	
	public Long PegarIdPeloNome(String nome) {
		return _moedaRepository.findByNome(nome).getId();
	}
}
