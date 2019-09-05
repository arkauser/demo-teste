package com.example.prova.demo.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.prova.demo.controller.TarefaController;

@WebMvcTest(value = TarefaController.class)
public class TarefaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
}
