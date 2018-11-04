package luizz.aula.br.calculo_autonomia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//quando o botao salvar for precionado os dados serao pegos
public class Adicionar_dados extends AppCompatActivity {

    private EditText km, data, fuel;
    private Spinner posto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_dados);

        posto = findViewById(R.id.spinPosto);
        km = findViewById(R.id.editkm);
        data = findViewById(R.id.editdate);
        fuel = findViewById(R.id.editfuel);

        //dapta o vetor de opções para usar no spinner
        ArrayAdapter<CharSequence> adapterSpin = ArrayAdapter.createFromResource(this.getApplicationContext(), R.array.lista_postos, android.R.layout.simple_spinner_item);
        //como vai ser visto o vetor
        adapterSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        posto.setAdapter(adapterSpin);
    }

    public  void onclickdado(View v){

        //Cria um item sem nada
        Info_List_Item item = new Info_List_Item();

        item.setData(data.getText().toString());
        item.setDistancia(Integer.parseInt(km.getText().toString()));
        item.setLitros(Integer.parseInt(fuel.getText().toString()));
        item.setPosto(posto.getSelectedItemPosition());

        //salvando
        boolean sucesso = Info_ListDAO.salvar(this.getApplicationContext(), item);

        if(sucesso){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_LONG).show();
        }
    }
}