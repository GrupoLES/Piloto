package com.example.classes.logica;

public class Jogador {
	String nomeJogador;
	Integer camisa;
	public Jogador(String nomeJogador,Integer camisa) {
		this.nomeJogador = nomeJogador;
		this.camisa = camisa;
	}
	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public Integer getCamisa() {
		return camisa;
	}
	public void setCamisa(Integer camisa) {
		this.camisa = camisa;
	}
}
