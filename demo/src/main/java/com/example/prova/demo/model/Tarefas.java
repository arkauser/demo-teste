package com.example.prova.demo.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarefas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idfTarefa;
	
	private String nmeTarefa;
	
	@Enumerated
	private Status status;

	public long getIdfTarefa() {
		return idfTarefa;
	}

	public void setIdfTarefa(long idfTarefa) {
		this.idfTarefa = idfTarefa;
	}

	public String getNmeTarefa() {
		return nmeTarefa;
	}

	public void setNmeTarefa(String nmeTarefa) {
		this.nmeTarefa = nmeTarefa;
	}

}
