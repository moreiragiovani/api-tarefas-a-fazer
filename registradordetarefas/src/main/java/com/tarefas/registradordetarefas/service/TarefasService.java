package com.tarefas.registradordetarefas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarefas.registradordetarefas.entitie.Tarefas;
import com.tarefas.registradordetarefas.repository.TarefasRepository;

@Service
public class TarefasService {
    
    @Autowired
    TarefasRepository tarefasRepository;

    public Tarefas createTarefa(Tarefas tarefa){
        tarefa.setMoment(LocalDateTime.now());
        tarefa.setIndex(findAllTarefas().size() + 1);
        return tarefasRepository.save(tarefa);
    }

    public List<Tarefas> findAllTarefas(){
        return tarefasRepository.findAll();
    }

    public Tarefas findByIdTarefa(UUID id){
        return tarefasRepository.findById(id).get();
    }

    public void deleteTarefa(UUID id){
        tarefasRepository.deleteById(id);
    }

    public Tarefas updateTarefa(UUID id, Tarefas tarefa){
        return tarefasRepository.save(tarefaConverter(id, tarefa));
    }

    public Tarefas tarefaConverter(UUID id, Tarefas t){
        Tarefas tarefa = tarefasRepository.getReferenceById(id);
        tarefa.setName(t.getName());
        tarefa.setDescription(t.getDescription());
        return tarefa;
    }
}
