package com.example.piloto;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.classes.logica.Jogo;
import com.example.classes.logica.Repositorio;

public class EditarJogoActivity extends Activity {
	
	private List<Jogo> jogos;
	private int position;
	private Button botaoRemove;
	private Button botaoData;
	private Intent intent;
	private DatePicker data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_jogo);
		jogos = Repositorio.getInstance().getJogos();
		intent = new Intent(this,JogoActivity.class);
		
		Bundle extras = getIntent().getExtras();
		position = extras.getInt("position");
		
		botaoRemove = (Button) findViewById(R.id.button1);
		botaoData = (Button) findViewById(R.id.button2);
		data = (DatePicker) findViewById(R.id.datePicker1);
		
		
		((TextView) findViewById(R.id.textView2)).setText(jogos.get(position).getEquipe1());
		((TextView) findViewById(R.id.textView3)).setText(jogos.get(position).getEquipe2());
		
		botaoRemove.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder adb=new AlertDialog.Builder(EditarJogoActivity.this);
	            adb.setTitle("Delete?");
	            adb.setMessage("Deseja remover o jogo?");
	            final int positionToRemove = position;
	            adb.setNegativeButton("Cancel", null);
	            adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                    Repositorio.getInstance().removeJogo(positionToRemove);
	                    startActivity(intent);
	                    finish();
	                }});
	            adb.show();
			}
			
		});
		
		botaoData.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Calendar calendario = new GregorianCalendar(data.getYear(), data.getMonth(), data.getDayOfMonth());
				jogos.get(position).setCalendar(calendario);
				startActivity(intent);
				finish();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar_jogo, menu);
		return true;
	}

}
