package com.ranking.ranking.controller;

import com.ranking.ranking.entity.Funcionario;
import com.ranking.ranking.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        return ResponseEntity.ok(funcionario);
    }

    // Adicionar pontos a um funcionário
    @PostMapping("/{id}/adicionar-pontos")
    public Funcionario adicionarPontos(@PathVariable Long id, @RequestParam int pontos, @RequestParam String meta) {
        return funcionarioService.adicionarPontos(id, pontos, meta);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return funcionarioService.atualizarFuncionario(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }



}