package com.ranking.ranking.controller;

import com.ranking.ranking.entity.Funcionario;
import com.ranking.ranking.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Adicionar um novo funcionário
    @PostMapping("/criar")
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.criarFuncionario(funcionario);
    }


    // Listar ranking dos funcionários
    @GetMapping("/ranking")
    public List<Funcionario> listarRanking() {
        return funcionarioService.listarRanking();
    }

    // Adicionar pontos a um funcionário
    @PostMapping("/{id}/adicionar-pontos")
    public Funcionario adicionarPontos(@PathVariable Long id, @RequestParam int pontos, @RequestParam String meta) {
        return funcionarioService.adicionarPontos(id, pontos, meta);
    }


}