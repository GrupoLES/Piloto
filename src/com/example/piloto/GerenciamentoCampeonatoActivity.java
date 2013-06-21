package com.example.piloto;

import java.util.ArrayList;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GerenciamentoCampeonatoActivity extends Activity {
	
	private Button botaoEditarCampeonato;
	private Button botaoGerenciarEquipes;
	private Button botaoGerenciarJogos;
	private Button botaoFinalizar;
	private Button listarCampeonatos;
	private TextView nome;
	private TextView data;
	private TextView premiacao;
	private Intent intentEditCamp;
	private Intent intent;
	private Intent intentJogo;
	private Intent intentInicio;
	private Intent intentListarCampeonatos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gerenciamento_campeonato);
		
		nome = (TextView) findViewById(R.id.nomeView);
		nome.setText(MainActivity.campeonato.getNome());
		data = (TextView) findViewById(R.id.dataInicioView);
		data.setText(MainActivity.campeonato.getDates(MainActivity.campeonato.getDataInicio())[0] + "/" + MainActivity.campeonato.getDates(MainActivity.campeonato.getDataInicio())[1]
				+ "/" + MainActivity.campeonato.getDates(MainActivity.campeonato.getDataInicio())[2]);
		premiacao = (TextView) findViewById(R.id.premiacaoView);
		premiacao.setText(MainActivity.campeonato.getPremiacao());
		
		botaoFinalizar = (Button) findViewById(R.id.button1);
		listarCampeonatos = (Button) findViewById(R.id.button2);
		botaoEditarCampeonato = (Button) findViewById(R.id.botaoGerenciamentoCampeonato);
		botaoGerenciarEquipes = (Button) findViewById(R.id.botaoGerenciarEquipes);
		botaoGerenciarJogos = (Button) findViewById(R.id.botaoGerenciarJogos);
		intentEditCamp = new Intent(this, EditarCampeonatoActivity.class);
		intent = new Intent(this,ListActivity.class);
		intentJogo = new Intent(this,JogoActivity.class);
		intentInicio = new Intent(this, MainActivity.class);
		intentListarCampeonatos = new Intent(this, ListaCampeonatosActivity.class);
		
		botaoEditarCampeonato.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				startActivity(intentEditCamp);
				
			}
			
		});
		
		botaoGerenciarEquipes.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(intent);
				//finish();
			}
			
		});
		
		botaoGerenciarJogos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(intentJogo);
				//finish();
			}
			
		});
		
		botaoFinalizar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder alert = new AlertDialog.Builder(GerenciamentoCampeonatoActivity.this);
				alert.setTitle("Confirmação");
				alert.setMessage("Confirmar a finalização do campeonato?");
				alert.setNeutralButton("Finalizar!", new  DialogInterface.OnClickListener() {
				
					@Override
					public void onClick(DialogInterface dialog, int which) {
						MainActivity.campeonato.setState(false);
						Date date = new Date();
						MainActivity.campeonato.setDataFim(date.getDate(), date.getMonth(), date.getYear());
						MainActivity.listaCampeonato.addFirst(MainActivity.campeonato);
						startActivity(intentInicio);
						finish();
						
					}
				
			});
				alert.show();
		}});
		
		listarCampeonatos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				if(MainActivity.listaCampeonato.size() >= 1){
					startActivity(intentListarCampeonatos);
				}else{
					AlertDialog.Builder alert = new AlertDialog.Builder(GerenciamentoCampeonatoActivity.this);
					alert.setTitle("Alerta");
					alert.setMessage("Não existem Campeonatos finalizados!");
					alert.setNeutralButton("Voltar", null);
					alert.show();
					
					
				}
				
				
				
			}
			
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gerenciamento_campeonato, menu);
		return true;
	}

}
