package com.example.SprintLearning.RepositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SprintLearning.models.*;

public interface ICotacoesRepository extends JpaRepository<Cotacoes,Long>{
	Cotacoes findById(long id);
}
