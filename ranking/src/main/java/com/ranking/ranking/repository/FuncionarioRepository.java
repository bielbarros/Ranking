package com.ranking.ranking.repository;

import com.ranking.ranking.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findAllByOrderByPontosDesc();// Ordena pelo ranking

}