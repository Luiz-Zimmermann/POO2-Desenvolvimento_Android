package com.example.a6530729.a04_calculo_de_rea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DadosTrianguloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_triangulo);
    }

    public void calcularArea(View v){

        EditText altura= findViewById(R.id.alturainfo);
        EditText base= findViewById(R.id.baseinfo);

        double altD= Double.parseDouble(altura.getText().toString());
        double baseD= Double.parseDouble(base.getText().toString());
        double resultado= altD*baseD;

        Intent resultadoTrinagulo= new Intent(this, RetanguloResultadoActivity.class);
        resultadoTrinagulo.putExtra("Triangulo", resultado);
        this.startActivity(resultadoTrinagulo);

    }
}
