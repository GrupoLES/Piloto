package com.example.classes.logica;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	
	List<Jogador> time;
	String nome;
	public Equipe(String nome) {
		time = new ArrayList<Jogador>();
		this.nome = nome;
	}
	public void addJogador(Jogador jogador){
		time.add(jogador);
	}
	public Jogador remove(String numerocamisa){
		Jogador retorno = null;
		for (int i = 0; i < time.size(); i++) {
			if(time.get(i).getCamisa().equals(numerocamisa)){
				retorno = time.remove(i);
			}
		}
		return retorno;
	}
	public String getNome(){
		return nome;
	}
}
