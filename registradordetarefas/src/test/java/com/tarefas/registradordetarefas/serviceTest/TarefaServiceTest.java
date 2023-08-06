package com.tarefas.registradordetarefas.serviceTest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.tarefas.registradordetarefas.communs.TarefasCommuns.TAREFA_DTO;
import static com.tarefas.registradordetarefas.communs.TarefasCommuns.TAREFA;
import static org.assertj.core.api.Assertions.assertThat;

import com.tarefas.registradordetarefas.dto.TarefaDto;
import com.tarefas.registradordetarefas.repository.TarefasRepository;
import com.tarefas.registradordetarefas.service.TarefasService;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {
    
    @InjectMocks
    private TarefasService tarefasService;

    @Mock
    private TarefasRepository tarefasRepository;

    @Test
    public void createTarefa_validData_returnsTarefa(){
        when(tarefasRepository.save(TAREFA)).thenReturn(TAREFA);

        TarefaDto tarefaDto = tarefasService.createTarefa(TAREFA_DTO);

        assertThat(tarefaDto).isEqualTo(TAREFA_DTO);

    }

}