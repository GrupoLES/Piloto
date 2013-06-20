package com.example.piloto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.classes.logica.Equipe;
import com.example.classes.logica.Repositorio;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListActivity extends Activity {
	ArrayAdapter<String> listAdapter;
	ArrayList<String> list;
	Repositorio repo;
	public List<String> getJogadores(List<Equipe> list){
		
		List<String> retorno = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++) {
			retorno.add(list.get(i).getNome());
		}
		return retorno;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		repo = Repositorio.getInstance();
		ListView listview = (ListView) findViewById(R.id.listEquipe);
		list = (ArrayList<String>) getJogadores(repo.getEquipes());
		      
	    // Create ArrayAdapter using the planet list.  
	     listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);  
	      
	    listview.setAdapter(listAdapter); 
	    listview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> a, View v, int position, long id) {
	            AlertDialog.Builder adb=new AlertDialog.Builder(ListActivity.this);
	            adb.setTitle("Delete?");
	            adb.setMessage("Deseja remover o time: " + list.get(position)+" ?");
	            final int positionToRemove = position;
	            adb.setNegativeButton("Cancel", null);
	            adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                    repo.removeEquipe(positionToRemove);
	                    list.remove(positionToRemove);
	                	listAdapter.notifyDataSetChanged();
	                }});
	            adb.show();
	        	
	            }
	        });
	    Button btn = (Button) findViewById(R.id.bataoVoltar);
			btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent it = new Intent(ListActivity.this,GerenciamentoCampeonatoActivity.class);
					startActivity(it);
					
				}
			});
		Button btnAdd = (Button) findViewById(R.id.bataoAdd);
		btnAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent ite = new Intent(ListActivity.this,AddEquipe.class);
				startActivity(ite);
				finish();
			}
		});
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}
	
	private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }

}
