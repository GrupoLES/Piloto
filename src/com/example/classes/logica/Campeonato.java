package com.example.classes.logica;

import java.util.Date;
import java.util.LinkedList;

public class Campeonato {
	
	
	private int dia;
	private int mes;
	private int ano;
	private Date dataInicio;
	private Date dataFim;
	private String premiacao;
	private String nome;
	private LinkedList<Equipe> equipes = new LinkedList<Equipe>();
	private LinkedList<Jogo> jogos = new LinkedList<Jogo>();
	private Boolean state = true;
	

	public Campeonato (int dia, int mes, int ano, String premiacao, String nome){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.premiacao = premiacao;
		this.nome = nome;
		this.dataInicio = new Date(ano, mes, dia);
		
	}
	
	public boolean getState(){
		return state;
	}
	
	public void setState(boolean state){
		this.state = state;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
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
		this.dataInicio = new Date(ano, mes, dia);
	}
	
	public void setDataFim(int dia, int mes, int ano){
		dataFim = new Date(ano, mes, dia);	
	}
	
	public String toString(){
		int dia = dataFim.getDate();
		int mes = dataFim.getMonth() + 1;
		int ano = dataFim.getYear() + 1900;
		return this.nome + " - Finalizado: " + Integer.toString(dia) + " / " + Integer.toString(mes) + " / " + Integer.toString(ano);
		
		
	}
	
	public int[] getDates(Date data){
		int[] array = new int[3];
		array[0] = data.getDate();
		array[1] = data.getMonth() + 1;
		array[2] = data.getYear();
		
		return array;
		
	}

}
