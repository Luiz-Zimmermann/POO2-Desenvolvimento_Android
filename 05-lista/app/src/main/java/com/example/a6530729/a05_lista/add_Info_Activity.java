package com.example.a6530729.a05_lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class add_Info_Activity extends AppCompatActivity {

    private Spinner spinner;
    private EditText fuel, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__info);

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter1 =
                ArrayAdapter.createFromResource(this, R.array.lista_postos, android.R.layout.simple_spinner_item);
        //como vai ser visto o vetor
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        fuel = findViewById(R.id.fuel);
        price = findViewById(R.id.price);

    }

    public void finish(View v){
        int  op = spinner.getSelectedItemPosition();
        String sla = spinner.getSelectedItem().toString();

        fuel.setText(sla);
    }
}
