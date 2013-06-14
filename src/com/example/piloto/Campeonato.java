package com.example.piloto;

import java.util.Date;
import java.util.LinkedList;

public class Campeonato {
	
	
	private int dia;
	private int mes;
	private int ano;
	private Date dataInicio;
	private Date dataFim;
	private String premiacao;
	private LinkedList<Equipes> equipes = new LinkedList<Equipes>();
	private LinkedList<Jogos> jogos = new LinkedList<Jogos>();
	

	public Campeonato (int dia, int mes, int ano, String premiacao){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.premiacao = premiacao;
		this.dataInicio = new Date(ano, mes, dia);
		
	}
	
	
	public String getPremiacao(){
		return this.premiacao;
	}
	
	public Date getDataInicio(){
		return dataInicio;
		
	}
	
	public Date getDataFim(){
		return dataFim;
		
	}
	
	public void setPremiacao(String premiacao){
		this.premiacao = premiacao;
	}
	
	public void setDataInicio(int dia, int mes, int ano){
		dataInicio = new Date(ano, mes, dia);
	}
	
	public void setDataFim(int dia, int mes, int ano){
		dataFim = new Date(ano, mes, dia);	
	}
	
	public String toString(Date data){
		int dia = data.getDate();
		int mes = data.getMonth();
		int ano = data.getYear();
		return Integer.toString(dia) + " - " + Integer.toString(mes) + " - " + Integer.toString(ano);
		
		
	}

}
