package com.example.a6530729.a04_calculo_de_rea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RetanguloResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retangulo_resultado);

        double alt = this.getIntent().getDoubleExtra("alt", -1);
        double base = this.getIntent().getDoubleExtra("base", -1);

        double resultado= alt*base;
        TextView text= findViewById(R.id.result);
        TextView textalt= findViewById(R.id.alt);
        TextView textbase= findViewById(R.id.base);
        NumberFormat numF = DecimalFormat.getInstance();
        numF.setMaximumFractionDigits(2);
        text.setText(numF.format(resultado)+"cm²");
        textalt.setText(alt+"");
        textbase.setText(base+"");

    }

    public void returnMenu(View V){

        Intent voltar =  new Intent(this, MainActivity.class);
        voltar.addFlags(voltar.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(voltar);
    }
}
