package com.example.prova.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.prova.demo.model.Tarefas;

public interface TarefasRepository extends CrudRepository<Tarefas, Integer> {

}
