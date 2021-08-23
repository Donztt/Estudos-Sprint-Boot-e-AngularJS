package com.example.SprintLearning.RepositoryInterface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SprintLearning.models.*;

@Repository
public interface ICotacoesRepository extends CrudRepository<Cotacoes,Long>{
	Cotacoes findById(long id);
}
