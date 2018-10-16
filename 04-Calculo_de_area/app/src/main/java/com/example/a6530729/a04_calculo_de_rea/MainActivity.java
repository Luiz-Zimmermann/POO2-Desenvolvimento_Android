package com.example.a6530729.a04_calculo_de_rea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escolha(View v){
        RadioGroup ops= findViewById(R.id.Escolha);

        if(ops.getCheckedRadioButtonId()==R.id.radioButtonCirc){
            Intent dadosCirculo = new Intent(this, DadosCirculoActivity.class);
            this.startActivity(dadosCirculo);
        }else if(ops.getCheckedRadioButtonId()==R.id.radioButtonTriang){
            Intent dadosTriangulo = new Intent(this, DadosTrianguloActivity.class);
            this.startActivity(dadosTriangulo);
        }else if(ops.getCheckedRadioButtonId()==R.id.radioButtonRetan){
            Intent dadosRetangulo = new Intent(this, DadosRetanguloActivity.class);
            this.startActivity(dadosRetangulo);
        }else{
            Toast.makeText(this, getString(R.string.warning), Toast.LENGTH_SHORT ).show();
        }
    }



}



