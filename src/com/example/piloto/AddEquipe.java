package com.example.piloto;

import java.util.ArrayList;
import java.util.List;

import com.example.classes.logica.Repositorio;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddEquipe extends Activity {
	List<String> listaDeEquipes;
	EditText text;
	Repositorio repo;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_equipe);
        repo = Repositorio.getInstance();
        
        text = (EditText) findViewById(R.id.nameEquipe);
        Button botaoSalvarEquipe = (Button) findViewById(R.id.bataoSalvarEquipe);
        listaDeEquipes = new ArrayList<String>();
        botaoSalvarEquipe.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				repo.addEquipe(text.getText().toString());
				Intent intent = new Intent(AddEquipe.this,ListActivity.class);
				startActivity(intent);
				finish();
				
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
