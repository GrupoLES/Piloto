package com.example.piloto;

import java.util.ArrayList;
import java.util.List;

import com.example.classes.logica.Jogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterJogos extends BaseAdapter{
	
	private LayoutInflater mInflater;
	private ArrayList<Jogo> jogos;
	
	public AdapterJogos(Context context, List<Jogo> jogos){
		this.jogos = this.jogos;
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return jogos.size();
	}

	@Override
	public Jogo getItem(int i) {
		return jogos.get(i);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		 //Pega o item de acordo com a pos��o.
        Jogo item = jogos.get(i);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.activity_jogo, null);
 
        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informa��es.
        
        //((TextView) view.findViewById(R.id.textList)).setText(item.toString());
 
        return view;
	}

}
