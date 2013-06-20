package com.example.classes.logica;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

	private static Repositorio instancia = null;
	
	List<Jogo> jogos;
	List<Equipe> equipes;
	
	private Repositorio(){
		jogos = new ArrayList<Jogo>();
		equipes = new ArrayList<Equipe>();
	}
	
	public static Repositorio getInstance() {
		 if(instancia == null) {
			 instancia = new Repositorio();
		 }
		 return instancia;
	}
	
	public void addJogo(Jogo jogo){
		jogos.add(jogo);
	}
	
	public List<Jogo> getJogos(){
		return jogos;
	}
	public void addEquipe(String nomeEquipe){
		equipes.add(new Equipe(nomeEquipe));
	}
	public List<Equipe> getEquipes(){
		return equipes;
	}
	public void removeEquipe(Integer position){
		equipes.remove(position);
	}
	
}
