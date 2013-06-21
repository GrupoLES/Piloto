package com.example.piloto;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastraCampeonato2 extends Activity {
	
	private EditText nome;
	private EditText premiacao;
	private Button botaoCriar;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastra_campeonato2);
	    nome = (EditText) findViewById(R.id.campeonatoNome);
	    premiacao = (EditText) findViewById(R.id.campPremiacao);
		botaoCriar = (Button) findViewById(R.id.botaoCriar);
		intent = new Intent(this, GerenciamentoCampeonatoActivity.class);
		botaoCriar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				MainActivity.campeonato.setNome(nome.getText().toString());
				MainActivity.campeonato.setPremiacao(premiacao.getText().toString());
				
				AlertDialog.Builder alert = new AlertDialog.Builder(CadastraCampeonato2.this);
				alert.setTitle("Confirmação");
				alert.setMessage("O campeonato foi criado com sucesso!");
				alert.setNeutralButton("Iniciar Gerenciamento", new  DialogInterface.OnClickListener() {
				
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						startActivity(intent);
						
					}
				
				
			});
				alert.show();
		}});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastra_campeonato2, menu);
		return true;
	}

}
