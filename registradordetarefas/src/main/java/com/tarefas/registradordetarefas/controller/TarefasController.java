package com.tarefas.registradordetarefas.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefas.registradordetarefas.dto.TarefaDto;
import com.tarefas.registradordetarefas.service.TarefasService;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefasController {
    
    @Autowired
    TarefasService tarefasService;

    @GetMapping("/tarefas")
    public ResponseEntity<List<TarefaDto>> findAllTarefas(){
        return ResponseEntity.ok().body(tarefasService.findAllTarefas());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> findByIdTarefa(@PathVariable(name = "id") UUID id){
        return ResponseEntity.ok().body(tarefasService.findByIdTarefa(id));
    }
    
    @GetMapping("/{nome}")
    public ResponseEntity<TarefaDto> findByName(@PathVariable(name = "nome") String nome){
        return ResponseEntity.ok().body(tarefasService.findByName(nome));
    }

    @PostMapping("/create")
    public ResponseEntity<TarefaDto> createTarefa(@RequestBody TarefaDto tarefa){
        return ResponseEntity.ok().body(tarefasService.createTarefa(tarefa));
    }
}