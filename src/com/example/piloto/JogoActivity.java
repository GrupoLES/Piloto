package com.example.piloto;

import java.util.ArrayList;
import java.util.List;

import com.example.classes.logica.Jogo;
import com.example.classes.logica.Repositorio;

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
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class JogoActivity extends Activity {
	
	private Button botaoCadastra;
	private Intent intent;
	private Intent intentEditar;
	private ArrayAdapter<String> listAdapter;
	private Repositorio repositorio;
	private List<String> list;
	
	private List<String> converteString(List<Jogo> jogos){
		List<String> result = new ArrayList<String>();
		
		for (int i = 0; i < jogos.size(); i++) {
			result.add(jogos.get(i).toString());
		}
		
		return result;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_jogo);
		
		botaoCadastra = (Button) findViewById(R.id.botaoCadastraJogo);
		intent = new Intent(this,CriaJogoActivity.class);
		intentEditar = new Intent(this,EditarJogoActivity.class);
		
		repositorio = Repositorio.getInstance();
		final ListView listView = (ListView) findViewById(R.id.listView1);
		
		/*listView.setOnItemClickListener(this);
		listAdapter = new AdapterJogos(this, repositorio.getJogos());
	    listView.setAdapter(listAdapter); */
		
		list = converteString(repositorio.getJogos());
		listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(listAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> a, View v, int position, long id) {
	        	intentEditar.putExtra("position", position);
	        	startActivity(intentEditar);
	        	finish();
	            }
	        });
		
		
		botaoCadastra.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(intent);
				finish();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jogo, menu);
		return true;
	}

}
