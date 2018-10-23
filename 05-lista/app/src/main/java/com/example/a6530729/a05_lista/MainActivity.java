package com.example.a6530729.a05_lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Postos> listPostos;
    private adaptadorpostos adaptador;
    TextView quilometragem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quilometragem = findViewById(R.id.kmperfuel);

    }

    public void addNew(View v){
        Intent addItem = new Intent(this, add_Info_Activity.class);
        this.startActivity(addItem);
    }

    public void viewList(View v){
        Intent viewLista = new Intent(this, view_ListActivity.class);
        this.startActivity(viewLista);
    }

}
