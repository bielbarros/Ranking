package com.ranking.ranking.service;


import com.ranking.ranking.entity.Funcionario;
import com.ranking.ranking.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario criarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }


    public List<Funcionario> listarRanking() {
        return funcionarioRepository.findAllByOrderByPontosDesc();
    }

    public Funcionario adicionarPontos(Long id, int pontos) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
        funcionario.setPontos(funcionario.getPontos() + pontos);
        return funcionarioRepository.save(funcionario);
    }
}