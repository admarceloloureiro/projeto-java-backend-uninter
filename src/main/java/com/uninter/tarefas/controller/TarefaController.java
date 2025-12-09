package com.uninter.tarefas.controller;

import com.uninter.tarefas.model.Tarefa;
import com.uninter.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    // 1. Criar tarefa (POST)
    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    // 2. Listar todas (GET)
    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    // 3. Buscar por ID (GET) - Requisito funcional [cite: 39]
    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // 4. Atualizar (PUT)
    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        return repository.findById(id).map(tarefa -> {
            tarefa.setNome(tarefaAtualizada.getNome());
            tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
            tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
            return repository.save(tarefa);
        }).orElse(null);
    }

    // 5. Deletar (DELETE)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}