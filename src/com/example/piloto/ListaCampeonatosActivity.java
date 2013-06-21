package com.example.piloto;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.example.classes.logica.Campeonato;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListaCampeonatosActivity extends Activity {
	
	private ArrayAdapter<String> listAdapter;
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_campeonatos);
		System.out.println("1");
		System.out.println("2");
		
		
		List<String> list = getCampeonatos(MainActivity.listaCampeonato);
		listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, list); 
		listView = (ListView) findViewById(R.id.listaCampeonatos);
		
		
		System.out.println("3");
		System.out.println("4 size: "+ list.size() + list.get(0));
		try {
			listView.setAdapter(listAdapter);
		} catch (Exception e) {
			System.out.println("deu erro!: "+e);
		}
		
		System.out.println("5");
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				
				Campeonato camp = MainActivity.listaCampeonato.get(position);

				int[] dInicio = camp.getDates(camp.getDataInicio());
				int[] dFim = camp.getDates(camp.getDataFim());
				dFim[2] = dFim[2] + 1900;
				
				AlertDialog.Builder alert = new AlertDialog.Builder(ListaCampeonatosActivity.this);
				alert.setTitle("Informação do Campeonato");
				alert.setMessage("Nome: " + camp.getNome() + "\nData inicio:" + dInicio[0] + "/"+dInicio[1] + "/" + dInicio[2]
						+"\nData Fim:" + dFim[0] + "/"+dFim[1] + "/" + dFim[2]);
				alert.setNeutralButton("Voltar", null);
				alert.show();
				
			}
			 
		 });
		
		
		
		
		
	}

	private List<String> getCampeonatos(LinkedList<Campeonato> listaCampeonato) {
		List<String> auxList = new ArrayList<String>();
		for(int i = 0; i < listaCampeonato.size(); i++){
			auxList.add(i, listaCampeonato.get(i).toString());
			
		}
		
		return auxList;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_campeonatos, menu);
		return true;
	}

}
