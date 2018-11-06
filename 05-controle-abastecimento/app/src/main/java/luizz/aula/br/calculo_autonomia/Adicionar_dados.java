package luizz.aula.br.calculo_autonomia;

import android.content.Intent;
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
    double kmOld;

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

        kmOld = this.getIntent().getDoubleExtra("kmAntigo", -1);
    }

    public  void onclickdado(View v){

        //Cria um item sem nada
        Info_List_Item item = new Info_List_Item();


        if(km.getText().toString().equals("")){
            this.km.setError(getString(R.string.warning));
            return;
        }
        if(fuel.getText().toString().equals("")){
            this.fuel.setError(getString(R.string.warning));
            return;
        }
        if(data.getText().toString().equals("")){
            this.data.setError(getString(R.string.warning));
            return;
        }
        if(Double.parseDouble(km.getText().toString())<=this.kmOld){
            this.km.setError(getString(R.string.warningOver));
            return;
        }

        item.setData(data.getText().toString());
        item.setDistancia(Double.parseDouble(km.getText().toString()));
        item.setLitros(Double.parseDouble(fuel.getText().toString()));
        item.setPosto(posto.getSelectedItemPosition());

        //salvando
        boolean sucesso = Info_ListDAO.salvar(this.getApplicationContext(), item);

        if(sucesso){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), getString(R.string.warningSave), Toast.LENGTH_LONG).show();
        }
    }
}