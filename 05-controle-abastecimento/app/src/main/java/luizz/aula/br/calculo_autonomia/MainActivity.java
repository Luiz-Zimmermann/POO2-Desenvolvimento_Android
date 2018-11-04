package luizz.aula.br.calculo_autonomia;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);

    }

    public void onclick(View v){

       Intent trocar_act = new Intent(this.getApplicationContext(), list_View.class);
       startActivity(trocar_act);
        //startActivityForResult(trocar_act, codigo);
    }
}
