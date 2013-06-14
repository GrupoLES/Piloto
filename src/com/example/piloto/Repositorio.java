package com.example.piloto;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

	private static Repositorio inst�ncia�nica = null;
	
	List<Jogo> jogos;
	
	private Repositorio(){
		jogos = new ArrayList<Jogo>();
	}
	
	public static Repositorio getInstance() {
		 if(inst�ncia�nica == null) {
			 inst�ncia�nica = new Repositorio();
		 }
		 return inst�ncia�nica;
	}
	
	public void addJogo(Jogo jogo){
		jogos.add(jogo);
	}
	
	public List<Jogo> getJogos(){
		return jogos;
	}
}
