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
import com.example.piloto.GerenciamentoCampeonatoActivity;

public class MainActivity extends Activity {

	private EditText dia;
	private EditText mes;
	private EditText ano;
	private EditText premiacao;
	private Button botaoCriar;
	public static Campeonato campeonato;
	private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dia = (EditText) findViewById(R.id.editText1);
        mes = (EditText) findViewById(R.id.editText2);
        ano = (EditText) findViewById(R.id.editText3);
        premiacao = (EditText) findViewById(R.id.editText4);
        intent = new Intent(this, GerenciamentoCampeonatoActivity.class);
        botaoCriar = (Button) findViewById(R.id.botaoCriar);
        botaoCriar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				campeonato = new Campeonato(Integer.parseInt(dia.getText().toString()),
						Integer.parseInt(mes.getText().toString()), Integer.parseInt(ano.getText().toString()), premiacao.getText().toString());
				AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
