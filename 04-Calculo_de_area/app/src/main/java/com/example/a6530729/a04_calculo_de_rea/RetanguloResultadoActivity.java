package com.example.a6530729.a04_calculo_de_rea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RetanguloResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retangulo_resultado);

        double result = this.getIntent().getDoubleExtra("Retangulo", -1);
        TextView text= findViewById(R.id.result);
        NumberFormat numF = DecimalFormat.getInstance();
        numF.setMaximumFractionDigits(2);
        text.setText(numF.format(result));

    }
}
