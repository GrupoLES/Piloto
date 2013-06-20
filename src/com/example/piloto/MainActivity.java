package com.example.piloto;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.classes.logica.Campeonato;
import com.example.piloto.GerenciamentoCampeonatoActivity;

public class MainActivity extends Activity {

	private Button novoCampeonato;
	private Button campeonatoExistente;
	private Intent intentNovoCamp;
	private Intent intentExistenteCamp;
	public static Campeonato campeonato;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        novoCampeonato = (Button) findViewById(R.id.novoCampeonatoBotao);
        campeonatoExistente = (Button) findViewById(R.id.campExistenteBotao);
        intentNovoCamp = new Intent(this, CadastraCampeonatoActivity.class);
        intentExistenteCamp = new Intent(this, GerenciamentoCampeonatoActivity.class);
        
        novoCampeonato.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(intentNovoCamp);
				
			}
        	
        });
        
        campeonatoExistente.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//TODO rotina de captura de campeonatos!
				startActivity(intentExistenteCamp);
				
			}
        	
        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
