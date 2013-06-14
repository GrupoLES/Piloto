package com.example.piloto;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

	private static Repositorio instânciaÚnica = null;
	
	List<Jogo> jogos;
	
	private Repositorio(){
		jogos = new ArrayList<Jogo>();
	}
	
	public static Repositorio getInstance() {
		 if(instânciaÚnica == null) {
			 instânciaÚnica = new Repositorio();
		 }
		 return instânciaÚnica;
	}
	
	public void addJogo(Jogo jogo){
		jogos.add(jogo);
	}
	
	public List<Jogo> getJogos(){
		return jogos;
	}
}
