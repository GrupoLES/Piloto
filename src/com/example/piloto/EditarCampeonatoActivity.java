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
	
	
	private EditText dia;
	private EditText mes;
	private EditText ano;
	private EditText nome;
	private EditText premiacao;
	private Button botaoSalvar;
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_campeonato);
		
		dia = (EditText) findViewById(R.id.diaEditLabel);
        mes = (EditText) findViewById(R.id.mesEditLabel);
        ano = (EditText) findViewById(R.id.anoEditLabel);
        nome = (EditText) findViewById(R.id.novoNomeEdit);
        
        premiacao = (EditText) findViewById(R.id.premiacaoEditLabel);
        intent = new Intent(this, GerenciamentoCampeonatoActivity.class);
        botaoSalvar = (Button) findViewById(R.id.botaoEdit);
        
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				
				
				
				try {
					//intent = setExtras(intent);
					MainActivity.campeonato.setDataInicio(Integer.parseInt(dia.getText().toString()),
							Integer.parseInt(mes.getText().toString()), Integer.parseInt(ano.getText().toString()));
					MainActivity.campeonato.setPremiacao(premiacao.getText().toString());
					MainActivity.campeonato.setNome(nome.getText().toString());
				} catch (Exception e) {
					AlertDialog.Builder alertError = new AlertDialog.Builder(EditarCampeonatoActivity.this);
					alertError.setTitle("Erro na Data");
					alertError.setMessage("O campo da Data possui erros de preenchimento!");
					alertError.setNeutralButton("Voltar para a edição", null);
					alertError.show();
					return;

				}
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
	
	private Intent setExtras(Intent intent){
		String[] list = new String[5];
		
		if(! nome.getText().toString().equals("")){
			String nomeEdited = nome.getText().toString();
			list[0] = nomeEdited;
		}else if(! dia.getText().toString().equals("")){
			String diaEdited = dia.getText().toString();
			list[1] = diaEdited;
		}else if(! mes.getText().toString().equals("")){
			String mesEdited = mes.getText().toString();
			list[2] = mesEdited;
		}else if(! ano.getText().toString().equals("")){
			String anoEdited = ano.getText().toString();
			list[3] = anoEdited;
		}else if(! premiacao.getText().toString().equals("")){
			String premiacaoEdited = premiacao.getText().toString();
			list[4] = premiacaoEdited;
		}else if( dia.getText().toString().equals("") && mes.getText().toString().equals("") && ano.getText().toString().equals("") ){
			dia.setText(MainActivity.campeonato.getDataInicio().getDate());
			mes.setText(MainActivity.campeonato.getDataInicio().getMonth());
			ano.setText(MainActivity.campeonato.getDataInicio().getYear() - 1900);
			
		}
		Bundle b = new Bundle();
		b.putStringArray("valores", list);
		intent.putExtras(b);
		return intent;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar_campeonato, menu);
		return true;
	}

}
