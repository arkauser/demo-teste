package com.example.prova.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TarefaNotFoundException extends RuntimeException {

	public TarefaNotFoundException(String message) {
		super(message);
	}
}
