package com.tarefas.registradordetarefas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefas.registradordetarefas.entitie.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, UUID>{
    
}
