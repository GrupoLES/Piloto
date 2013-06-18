package com.example.classes.logica;

public class Jogo {
	
	String equipe1, equipe2, data;
	
	public Jogo(String equipe1, String equipe2, String data){
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.data = data;
	}
	
	public String toString(){
		return equipe1 + " x " + equipe2 + "    " + data;
	}
}
