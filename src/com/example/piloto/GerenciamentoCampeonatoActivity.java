package com.example.piloto;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class GerenciamentoCampeonatoActivity extends Activity {
	
	private Button botaoEditarCampeonato;
	private Button botaoGerenciarEquipes;
	private Button botaoGerenciarJogos;
	private Intent intentEditCamp;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gerenciamento_campeonato);
		
		
		
		botaoEditarCampeonato = (Button) findViewById(R.id.botaoGerenciamentoCampeonato);
		botaoGerenciarEquipes = (Button) findViewById(R.id.botaoGerenciarEquipes);
		botaoGerenciarJogos = (Button) findViewById(R.id.botaoGerenciarJogos);
		intentEditCamp = new Intent(this, EditarCampeonatoActivity.class);
		intent = new Intent(this,AddEquipe.class);
		
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
				// TODO TELA DE JOGOS
				
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
