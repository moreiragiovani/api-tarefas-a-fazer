package com.tarefas.registradordetarefas.communs;

import java.time.LocalDateTime;

import com.tarefas.registradordetarefas.dto.TarefaDto;
import com.tarefas.registradordetarefas.entitie.Tarefas;

public class TarefasCommuns {

    public static final Tarefas TAREFA = new Tarefas("Tomar remedio", "Tomar remedio as 12h", 1, LocalDateTime.now());
    public static final TarefaDto TAREFA_INVALID_DTO = new TarefaDto("", "", null, null);
    public static final Tarefas TAREFA_INVALID = new Tarefas("", "", null, null);



    public static final TarefaDto TAREFA_DTO = new TarefaDto("Tomar remedio", 
    "Tomar remedio as 12h", 
    1, 
    LocalDateTime.now());
    
    

}
