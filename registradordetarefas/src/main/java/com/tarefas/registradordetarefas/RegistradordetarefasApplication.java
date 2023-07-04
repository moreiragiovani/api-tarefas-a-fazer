package com.tarefas.registradordetarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com/tarefas/registradordetarefas/entitie")
@EnableJpaRepositories(value = "com/tarefas/registradordetarefas/repository")
@SpringBootApplication
public class RegistradordetarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistradordetarefasApplication.class, args);
	}

}
