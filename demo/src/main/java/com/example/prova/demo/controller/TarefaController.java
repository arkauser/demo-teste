package com.example.prova.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.prova.demo.model.Tarefas;
import com.example.prova.demo.repository.TarefasRepository;

public class TarefaController {
	
	@Autowired
	private TarefasRepository taR;
	
	@GetMapping("/users")
	public List<Tarefas> findAll() {
		return (List<Tarefas>) taR.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<Tarefas> findTarefas(@PathVariable Integer id) {
		Optional<Tarefas> achado = taR.findById(id);
		
		if(achado.get() == null) {
			throw new TarefaNotFoundException("Tarefa Não Encontrada");
		}
		
		return achado;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createTarefa(@RequestBody Tarefas tarefa) {
		Tarefas saved = taR.save(tarefa);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getIdfTarefa()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public BodyBuilder deleteUser(@PathVariable Integer id) {
		Optional<Tarefas> tarefa = findTarefas(id);
		
		taR.delete(tarefa.get());
		
		return ResponseEntity.ok();
	}
	
	@PutMapping("/users/{id}")
	public BodyBuilder updateUser(@PathVariable Integer id, @RequestBody Tarefas tarefa) {
		Optional<Tarefas> existe = taR.findById(id);
		
		if(existe != null) {
			tarefa.setIdfTarefa(id);
			taR.save(tarefa);
		} else {
			throw new TarefaNotFoundException("Tarefa Não Encontrada");
		}
		
		return ResponseEntity.ok();
	}
}
