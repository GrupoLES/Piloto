package com.example.piloto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.example.classes.logica.Campeonato;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class CadastraCampeonatoActivity extends Activity {
	
	private EditText dia;
	private EditText mes;
	private EditText ano;
	private EditText nome;
	private EditText premiacao;
	private Button botaoProximo;
	private Intent intent;
	private DatePicker data;
	private Calendar calendario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastra_campeonato);
       // nome = (EditText) findViewById(R.id.campeonatoNome);
       // premiacao = (EditText) findViewById(R.id.campPremiacao);
        intent = new Intent(this, CadastraCampeonato2.class);
        botaoProximo = (Button) findViewById(R.id.botaoProximo);
        data = (DatePicker) findViewById(R.id.datePicker1);
        calendario = new GregorianCalendar();
        calendario.set(data.getYear(), data.getMonth(), data.getDayOfMonth());
        
        botaoProximo.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View arg0) {
				
				
				
				try {
					
					MainActivity.campeonato = new Campeonato((data.getDayOfMonth()),
							data.getMonth(), data.getYear(), "", "");
					
				} catch (Exception e) {
					AlertDialog.Builder alertError = new AlertDialog.Builder(CadastraCampeonatoActivity.this);
					alertError.setTitle("Erro na Data");
					alertError.setMessage("O campo da Data possui erros de preenchimento!");
					alertError.setNeutralButton("Voltar para a edição", null);
					alertError.show();
					return;
				}
				startActivity(intent);
				
			}
        	
        });
		
		
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastra_campeonato, menu);
		return true;
	}

}
