package com.example.piloto;

import java.util.ArrayList;

import com.example.classes.logica.Campeonato;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastraCampeonatoActivity extends Activity {
	
	private EditText dia;
	private EditText mes;
	private EditText ano;
	private EditText nome;
	private EditText premiacao;
	private Button botaoCriar;
	private Intent intent;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastra_campeonato);
		dia = (EditText) findViewById(R.id.cadastroDia);
        mes = (EditText) findViewById(R.id.cadastraMes);
        ano = (EditText) findViewById(R.id.cadastroAno);
        nome = (EditText) findViewById(R.id.campeonatoNome);
        premiacao = (EditText) findViewById(R.id.campPremiacao);
        intent = new Intent(this, GerenciamentoCampeonatoActivity.class);
        botaoCriar = (Button) findViewById(R.id.botaoCriar);
        botaoCriar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				
				
				try {
					//intent = setExtras(intent);
					MainActivity.campeonato = new Campeonato(Integer.parseInt(dia.getText().toString()),
							Integer.parseInt(mes.getText().toString()), Integer.parseInt(ano.getText().toString()), premiacao.getText().toString(), nome.getText().toString());
					
				} catch (Exception e) {
					AlertDialog.Builder alertError = new AlertDialog.Builder(CadastraCampeonatoActivity.this);
					alertError.setTitle("Erro na Data");
					alertError.setMessage("O campo da Data possui erros de preenchimento!");
					alertError.setNeutralButton("Voltar para a edição", null);
					alertError.show();
					return;
				}
				
				
				AlertDialog.Builder alert = new AlertDialog.Builder(CadastraCampeonatoActivity.this);
				alert.setTitle("Confirmação");
				alert.setMessage("O campeonato foi criado com sucesso!");
				alert.setNeutralButton("Iniciar Gerenciamento", new  DialogInterface.OnClickListener() {
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
		getMenuInflater().inflate(R.menu.cadastra_campeonato, menu);
		return true;
	}

}
