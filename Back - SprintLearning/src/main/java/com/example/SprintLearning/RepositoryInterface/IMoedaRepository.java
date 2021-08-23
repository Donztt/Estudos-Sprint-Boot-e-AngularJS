package com.example.SprintLearning.RepositoryInterface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SprintLearning.models.Moeda;

@Repository
public interface IMoedaRepository extends CrudRepository<Moeda,Long>{
	
	@Query(value = "Select * from Moeda m where m.nome = :nomeMoeda",nativeQuery=true)
	Moeda findByNome(@Param("nomeMoeda")String nome);
}
