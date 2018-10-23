package com.example.a6530729.a04_calculo_de_rea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CirculoResultadoctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_resultadoctivity);

        double raioD = this.getIntent().getDoubleExtra("raio", -1);
        double resultado = Math.PI*Math.pow(raioD,2);

        TextView text= findViewById(R.id.result);
        TextView raio= findViewById(R.id.raio);
        NumberFormat numF = DecimalFormat.getInstance();
        numF.setMaximumFractionDigits(2);
        text.setText(numF.format(resultado)+"cm²");
        raio.setText(raioD+"");

    }

    public void returnMenu(View V){

        Intent voltar =  new Intent(this, MainActivity.class);
        voltar.addFlags(voltar.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(voltar);
    }

}
