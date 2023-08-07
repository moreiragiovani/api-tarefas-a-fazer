package com.tarefas.registradordetarefas.serviceTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.tarefas.registradordetarefas.communs.TarefasCommuns.TAREFA_DTO;
import static com.tarefas.registradordetarefas.communs.TarefasCommuns.TAREFA;
import static com.tarefas.registradordetarefas.communs.TarefasCommuns.TAREFA_INVALID_DTO;
import static com.tarefas.registradordetarefas.communs.TarefasCommuns.TAREFA_INVALID;
import static com.tarefas.registradordetarefas.communs.TarefasCommuns.ID;




import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    public void createTarefa_invalidData_throwsExepition(){
        when(tarefasRepository.save(TAREFA_INVALID)).thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> tarefasService.createTarefa(TAREFA_INVALID_DTO)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void findByid_getTarefaId_returnsTarefa(){
        when(tarefasRepository.findById(ID)).thenReturn(Optional.of(TAREFA));

        TarefaDto tarefa = tarefasService.findByIdTarefa(ID);

        assertThat(tarefa).isNotNull();

        assertThat(tarefa).isEqualTo(TAREFA_DTO);
    }

    @Test
    public void findById_unexistingId_returnsEmpity(){
        when(tarefasRepository.findById(ID)).thenReturn(Optional.empty());   

        assertThatThrownBy(() -> tarefasService.findByIdTarefa(ID)).isInstanceOf(RuntimeException.class);
    }
}
