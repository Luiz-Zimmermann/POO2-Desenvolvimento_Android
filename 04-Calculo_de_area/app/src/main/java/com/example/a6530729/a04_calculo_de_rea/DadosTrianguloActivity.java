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

        EditText altura= findViewById(R.id.alturainfo2);
        EditText base= findViewById(R.id.baseinfo2);
        try {
            double altD = Double.parseDouble(altura.getText().toString());
            double baseD = Double.parseDouble(base.getText().toString());
            Intent resultadoTrinagulo = new Intent(this, TrinaguloResultadoActivity.class);
            resultadoTrinagulo.putExtra("alt", altD);
            resultadoTrinagulo.putExtra("base", baseD);
            this.startActivity(resultadoTrinagulo);
        }catch (Exception e){
            altura.setError(getString(R.string.warninginfo));
            base.setError(getString(R.string.warninginfo));
        }
    }
}
