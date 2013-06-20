package com.example.piloto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.classes.logica.Equipe;
import com.example.classes.logica.Jogo;
import com.example.classes.logica.Repositorio;

public class CriaJogoActivity extends Activity {
	
	private Button botaoCriar;
	private Intent intent;
	private String equipe1;
	private String equipe2;
	private Spinner spn1;
	private Spinner spn2;
	private ArrayAdapter<String> arrayAdapter1;
	private ArrayAdapter<String> arrayAdapter2;
	private List<String> equipes;
	private DatePicker data;
	private Calendar calendario;
	
	private void converteString(){
		List<Equipe> aux = Repositorio.getInstance().getEquipes();
		equipes = new ArrayList<String>();
		for (int i = 0; i < aux.size(); i++) {
			equipes.add(aux.get(i).getNome());
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cria_jogo);
		
		botaoCriar = (Button) findViewById(R.id.botaoCriar);
		intent = new Intent(this,JogoActivity.class);
		converteString();
		
		spn1 = (Spinner) findViewById(R.id.spinner1);
		arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipes);
		arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spn1.setAdapter(arrayAdapter1);
		
		spn2 = (Spinner) findViewById(R.id.spinner2);
		arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, equipes);
		arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spn2.setAdapter(arrayAdapter2);
		
		data = (DatePicker) findViewById(R.id.datePicker1);
		
		spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			 
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				equipe1 = parent.getItemAtPosition(posicao).toString();
			}
 
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
 
			}
		});
		
		spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			 
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
				equipe2 = parent.getItemAtPosition(posicao).toString();
			}
 
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
 
			}
		});
		
		botaoCriar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calendario = new GregorianCalendar();
				calendario.set(data.getYear(), data.getMonth(), data.getDayOfMonth());
				Repositorio.getInstance().addJogo(new Jogo(equipe1, equipe2, calendario));
				AlertDialog.Builder adb=new AlertDialog.Builder(CriaJogoActivity.this);
	            //adb.setTitle("Delete?");
	            adb.setMessage("Cadastro concluido com sucesso!");
	            adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                	startActivity(intent);
	                }});
	            adb.show();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cria_jogo, menu);
		return true;
	}

}
