package com.example.classes.logica;

import java.util.Calendar;

public class Jogo {
	
	String equipe1, equipe2;
	Calendar data;
	
	public Jogo(String equipe1, String equipe2, Calendar data){
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.data = data;
	}
	
	private String formataData(){
		String anoString = Integer.toString(data.get(data.YEAR));
		String mesString = Integer.toString(data.get(data.MONTH));
		String diaString = Integer.toString(data.get(data.DAY_OF_MONTH));
		
		return diaString + "/" + mesString + "/" + anoString;
	}
	
	public String toString(){
		return equipe1 + " x " + equipe2 + "    " + formataData();
	}
	
	public String getEquipe1(){
		return equipe1;
	}
	
	public String getEquipe2(){
		return equipe2;
	}
	
	public Calendar getData(){
		return data;
	}
	
	public void setCalendar(Calendar novaData){
		data = novaData;
	}
}
