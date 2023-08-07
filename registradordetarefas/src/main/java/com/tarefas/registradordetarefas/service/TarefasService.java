package com.tarefas.registradordetarefas.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public List<TarefaDto> findAllTarefas(){
        List<TarefaDto> tarefaDtos = new ArrayList<>();
        for(Tarefas t : tarefasRepository.findAll()){
            tarefaDtos.add(tarefaToDto(t, new TarefaDto()));
        }
        return tarefaDtos;
    }

    public TarefaDto findByIdTarefa(UUID id){
        return tarefaToDto(tarefasRepository.findById(id).get(), new TarefaDto());
    }

    public TarefaDto findByName(String nome){
        return tarefaToDto(tarefasRepository.findByNome(nome).get(), new TarefaDto());
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
        tD.setId(t.getId());
        tD.setName(t.getName());
        tD.setDescription(t.getDescription());
        tD.setIndex(t.getIndex());
        tD.setMoment(t.getMoment());
        return tD;
    }

    public Tarefas DtoToTarefa(Tarefas tD, TarefaDto t){
        tD.setId(t.getId());
        tD.setName(t.getName());
        tD.setDescription(t.getDescription());
        tD.setIndex(t.getIndex());
        tD.setMoment(t.getMoment());
        return tD;
    }
}
