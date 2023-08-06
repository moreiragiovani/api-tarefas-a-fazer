package com.tarefas.registradordetarefas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarefas.registradordetarefas.dto.TarefaDto;
import com.tarefas.registradordetarefas.entitie.Tarefas;
import com.tarefas.registradordetarefas.repository.TarefasRepository;

@Service
public class TarefasService {
    
    @Autowired
    TarefasRepository tarefasRepository;

    public TarefaDto createTarefa(TarefaDto tarefaDto){
        Tarefas tarefa = new Tarefas();

        tarefa.setMoment(LocalDateTime.now());
        tarefa.setIndex(findAllTarefas().size() + 1);
        DtoToTarefa(tarefa, tarefaDto);  
        
        return tarefaToDto(tarefasRepository.save(tarefa), tarefaDto);
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

    public TarefaDto tarefaToDto(Tarefas t, TarefaDto tD){
        tD.setName(t.getName());
        tD.setDescription(t.getDescription());
        tD.setIndex(t.getIndex());
        tD.setMoment(t.getMoment());
        return tD;
    }

    public Tarefas DtoToTarefa(Tarefas tD, TarefaDto t){
        tD.setName(t.getName());
        tD.setDescription(t.getDescription());
        tD.setIndex(t.getIndex());
        tD.setMoment(t.getMoment());
        return tD;
    }
}
