package com.tarefas.registradordetarefas.dto;

import java.time.LocalDateTime;
import java.util.UUID;


public class TarefaDto {
    
    private UUID id;
    private String name;
    private String description;
    private Integer index;
    private LocalDateTime moment;
    
    public TarefaDto() {
    }

    public TarefaDto(UUID id, String name, String description, Integer index, LocalDateTime moment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.index = index;
        this.moment = moment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((index == null) ? 0 : index.hashCode());
        result = prime * result + ((moment == null) ? 0 : moment.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TarefaDto other = (TarefaDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (index == null) {
            if (other.index != null)
                return false;
        } else if (!index.equals(other.index))
            return false;
        if (moment == null) {
            if (other.moment != null)
                return false;
        } else if (!moment.equals(other.moment))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TarefaDto [id=" + id + ", name=" + name + ", description=" + description + ", index=" + index
                + ", moment=" + moment + "]";
    }
}
