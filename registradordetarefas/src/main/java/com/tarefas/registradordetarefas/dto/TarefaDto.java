package com.tarefas.registradordetarefas.dto;

import java.time.LocalDateTime;


public class TarefaDto {
    
    
    private String name;
    private String description;
    private Integer index;
    private LocalDateTime moment;
    
    public TarefaDto() {
    }

    public TarefaDto(String name, String description, Integer index, LocalDateTime moment) {
        this.name = name;
        this.description = description;
        this.index = index;
        this.moment = moment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    
    
   
}
