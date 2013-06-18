package com.example.piloto;

import com.example.classes.logica.Jogo;
import com.example.classes.logica.Repositorio;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CriaJogoActivity extends Activity {
	
	private Button botaoCriar;
	private Intent intent;
	private TextView equipe1;
	private TextView equipe2;
	private TextView data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cria_jogo);
		
		botaoCriar = (Button) findViewById(R.id.botaoCriar);
		intent = new Intent(this,JogoActivity.class);
		
		equipe1 = (TextView) findViewById(R.id.editText1);
		equipe2 = (TextView) findViewById(R.id.editText2);
		data = (TextView) findViewById(R.id.editText3);
		
		botaoCriar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Repositorio.getInstance().addJogo(new Jogo(equipe1.getText().toString(),equipe2.getText().toString(), data.getText().toString()));
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
