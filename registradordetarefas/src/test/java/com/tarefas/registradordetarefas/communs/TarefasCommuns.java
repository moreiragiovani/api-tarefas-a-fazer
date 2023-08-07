package com.tarefas.registradordetarefas.communs;

import java.util.UUID;

import com.tarefas.registradordetarefas.dto.TarefaDto;
import com.tarefas.registradordetarefas.entitie.Tarefas;

public class TarefasCommuns {
    public static final UUID ID = UUID.fromString("a7f5ef48-a07c-4703-885f-8b6b115a9a01");

    public static final Tarefas TAREFA = new Tarefas(ID, "Tomar remedio", "Tomar remedio as 12h", 1, null);
    public static final TarefaDto TAREFA_DTO = new TarefaDto(ID,"Tomar remedio", "Tomar remedio as 12h",  1, null);
    public static final TarefaDto TAREFA_INVALID_DTO = new TarefaDto(null,"", "", null, null);
    public static final Tarefas TAREFA_INVALID = new Tarefas(null, "", "", null, null);

    
}
