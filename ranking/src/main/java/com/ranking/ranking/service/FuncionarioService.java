package com.ranking.ranking.service;


import com.ranking.ranking.entity.Funcionario;
import com.ranking.ranking.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public Funcionario adicionarPontos(Long id, int pontos, String meta) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
        funcionario.setPontos(funcionario.getPontos() + pontos);
        funcionario.setMeta(meta);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario novoFuncionario) {
        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(id);
        if (funcionarioExistente.isPresent()) {
            Funcionario funcionario = funcionarioExistente.get();
            funcionario.setNome(novoFuncionario.getNome());
            funcionario.setPontos(novoFuncionario.getPontos());
            funcionario.setMeta(novoFuncionario.getMeta());
            return funcionarioRepository.save(funcionario);
        } else {
            throw new RuntimeException("Funcionário não encontrado");
        }
    }

    public void deletarFuncionario(Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Funcionário não encontrado");
        }
    }

}