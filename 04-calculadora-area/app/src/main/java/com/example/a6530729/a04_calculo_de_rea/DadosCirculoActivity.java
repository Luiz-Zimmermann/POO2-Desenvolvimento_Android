package com.example.a6530729.a04_calculo_de_rea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DadosCirculoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_circulo);
    }

    public void calcularArea(View v){

        EditText raio = findViewById(R.id.Raioinfo);
        try {
            double raioD = Double.parseDouble(raio.getText().toString());
            Intent resultadoCirculo = new Intent(this, CirculoResultadoctivity.class);
            resultadoCirculo.putExtra("raio", raioD);
            this.startActivity(resultadoCirculo);
        }catch(Exception e){
            raio.setError(getString(R.string.warninginfo));
            return;
        }

    }

}
