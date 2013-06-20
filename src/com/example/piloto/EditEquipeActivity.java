package com.example.piloto;

import java.util.List;

import com.example.classes.logica.Equipe;
import com.example.classes.logica.Repositorio;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditEquipeActivity extends Activity {
	Repositorio repo = Repositorio.getInstance();
	String positionEquipe;
	EditText nomeEquipe;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_equipe);
		nomeEquipe = (EditText) findViewById(R.id.nameEditEquipe);
		positionEquipe = getIntent().getStringExtra("EquipeEdit");
		
		nomeEquipe.setText(repo.getEquipes().get(Integer.valueOf(positionEquipe)).getNome());
		Button botaoSalvarAlteracao = (Button) findViewById(R.id.bataoSalvarAlteracao);
		Button botaoEditVoltar = (Button) findViewById(R.id.bataoEditeVoltar);
		
		botaoSalvarAlteracao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				repo.removeEquipe(Integer.valueOf(positionEquipe));
				repo.addEquipe(nomeEquipe.getText().toString());
				List<Equipe> list = repo.getEquipes();
				list.remove(Integer.valueOf(positionEquipe));
				repo.editList(list);
				Intent it = new Intent(EditEquipeActivity.this,ListActivity.class);
				startActivity(it);
				finish();
				
			}
		});
		botaoEditVoltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(EditEquipeActivity.this,ListActivity.class);
				startActivity(it);
				finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_equipe, menu);
		return true;
	}

}
