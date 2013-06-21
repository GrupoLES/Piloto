package com.example.piloto;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EditarCampeonato2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_campeonato2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar_campeonato2, menu);
		return true;
	}

}
