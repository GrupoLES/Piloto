package com.example.piloto;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditarCampeonatoActivity extends Activity {
	
	
	private EditText nome;
	private EditText premiacao;
	private Button botaoSalvar;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_campeonato);
		
        nome = (EditText) findViewById(R.id.novoNomeEdit);
        
        premiacao = (EditText) findViewById(R.id.premiacaoEditLabel);
        intent = new Intent(this, GerenciamentoCampeonatoActivity.class);
        botaoSalvar = (Button) findViewById(R.id.botaoEdit);
        
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
					
				MainActivity.campeonato.setPremiacao(premiacao.getText().toString());
				MainActivity.campeonato.setNome(nome.getText().toString());

				AlertDialog.Builder alert = new AlertDialog.Builder(EditarCampeonatoActivity.this);
				alert.setTitle("Confirmação");
				alert.setMessage("O campeonato foi editado com sucesso!");
				alert.setNeutralButton("Voltar ao Gerenciamento", new  DialogInterface.OnClickListener() {
					public  void  onClick(DialogInterface dialog, int  whichButton) {
						startActivity(intent);
						finish();
					}
				});
				alert.show();
				
			}
        	
        });
		
		
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar_campeonato, menu);
		return true;
	}

}
