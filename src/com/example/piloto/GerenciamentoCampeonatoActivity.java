package com.example.piloto;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gerenciamento_campeonato);
		
		nome = (TextView) findViewById(R.id.nomeView);
		nome.setText(MainActivity.campeonato.getNome());
		data = (TextView) findViewById(R.id.dataInicioView);
		data.setText(MainActivity.campeonato.getDataInicio().getDate() + "/" + MainActivity.campeonato.getDataInicio().getMonth() + "/" + MainActivity.campeonato.getDataInicio().getYear());
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
				finish();
			}
			
		});
		
		botaoGerenciarJogos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(intentJogo);
				finish();
			}
			
		});
		
		botaoFinalizar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
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
