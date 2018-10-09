package luizz.aula.br.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1, spinner2;
    private TextView texto1, texto2, t1;
    private Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9,buttondot, buttonerase, buttonclear, buttonx10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String warning="@string/aviso";
        Toast aviso = Toast.makeText(this, getString(R.string.aviso), Toast.LENGTH_LONG);
        aviso.show();

        spinner1= (Spinner) findViewById(R.id.spinnerbut1);
        spinner2= (Spinner) findViewById(R.id.spinnerbut2);
        texto1 = (TextView) findViewById(R.id.text1);
        texto2 = (TextView) findViewById(R.id.text2);

        button1 = (Button) findViewById(R.id.but1);
        button2 = (Button) findViewById(R.id.but2);
        button3 = (Button) findViewById(R.id.but3);
        button4 = (Button) findViewById(R.id.but4);
        button5 = (Button) findViewById(R.id.but5);
        button6 = (Button) findViewById(R.id.but6);
        button7 = (Button) findViewById(R.id.but7);
        button8 = (Button) findViewById(R.id.but8);
        button9 = (Button) findViewById(R.id.but9);
        button0 = (Button) findViewById(R.id.but0);
        buttondot = (Button) findViewById(R.id.butdot);
        buttonerase = (Button) findViewById(R.id.buterase);
        buttonclear = (Button) findViewById(R.id.butclear);
        buttonx10 = (Button) findViewById(R.id.buttonof);

        //adapta o vetor de opções para usar no spinner
        ArrayAdapter<CharSequence> adapter1 =
        ArrayAdapter.createFromResource(this, R.array.array1, android.R.layout.simple_spinner_item);
        //como vai ser visto o vetor
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        //spinner1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 =
                ArrayAdapter.createFromResource(this, R.array.array2, android.R.layout.simple_spinner_item);
        //como vai ser visto o vetor
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        //spinner2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //pega o item selecionado no spinner e transforma pra string
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    boolean x10=false;
    public  void aperto(View v) {

       int  op1 = spinner1.getSelectedItemPosition();
       int  op2 = spinner2.getSelectedItemPosition();

       try{
               double nun1= Double.parseDouble(texto1.getText().toString());
               double resultadoD=0;
               String resultadoS="";

               if(x10){
                   resultadoS= operacoes2(op1,op2, nun1);
                   texto2.setText(""+resultadoS);
               }else{
                   resultadoD = operacoes(op1, op2 , nun1);
                   texto2.setText(""+resultadoD);
               }
       }catch(Exception e){
           /*
           String texto = texto1.getText().toString();
           int cont=0;
           for(int i=0;i<texto.length();i++){
               if(cont>1){
                   texto1.setError("Sómente 1 ponto");
                   break;
               }
               if(texto.charAt(i) == '.'){
                   cont++;
               }
           }
           texto1.setText("");
           */
           return;
       }

    }

    public  double operacoes(int op1, int op2, double num1){

        double resultado=0;

        if(op1==0){//km
            resultado=op0(op2,num1);
        }else if(op1==1){//m
            resultado=op1(op2,num1);
        }else if(op1==2){//cm
            resultado=op2(op2,num1);
        }else if(op1==3){//mm
            resultado=op3(op2,num1);
        }else if(op1==4){//um
            resultado=op4(op2,num1);
        }else if(op1==5){//nm
            resultado=op5(op2,num1);
        }
        return resultado;
    }

    public  String operacoes2(int op1, int op2, double num1){

        String resultado="";

        if(op1==0){//km
            resultado=op0s(op2,num1);
        }else if(op1==1){//m
            resultado=op1s(op2,num1);
        }else if(op1==2){//cm
            resultado=op2s(op2,num1);
        }else if(op1==3){//mm
            resultado=op3s(op2,num1);
        }else if(op1==4){//um
            resultado=op4s(op2,num1);
        }else if(op1==5){//nm
            resultado=op5s(op2,num1);
        }
        return resultado;
    }

    public double op0(int op, double num){

        double resultado=0;
        long x=1000000000000L;
        if(op==0){
            resultado=num;
        }else if(op==1){

            resultado=num*1000;
        }else if(op==2){
            resultado=num*100000;
        }else if(op==3){
            resultado=num*1000000;
        }else if(op==4){
            resultado=num*1000000000;
        }else if(op==5){
            resultado=num*x;
        }

        return resultado;
    }

    public double op1(int op, double num){

        double resultado=0;
        long x=1000000000L;
        if(op==0){//kmetro
            resultado=num/1000;
        }else if(op==1){//m
            resultado=num;
        }else if(op==2){//cm
            resultado=num*100;
        }else if(op==3){//mm
            resultado=num*1000;
        }else if(op==4){//um
            resultado=num*1000000;
        }else if(op==5){//nm
            resultado=num*x;
        }

        return resultado;
    }

    public double op2(int op, double num){

        double resultado=0;

        if(op==0){//km
            resultado=num/100000;
        }else if(op==1){//m
            resultado=num/100;
        }else if(op==2){//cm
            resultado=num;

        }else if(op==3){//mm
            resultado=num*10;
        }else if(op==4){//um
            resultado=num*10000;
        }else if(op==5){//nm
            resultado=num*10000000;
        }

        return resultado;
    }

    public double op3(int op, double num){

        double resultado=0;

        if(op==0){//km
            resultado=num/1000000;
        }else if(op==1){//m
            resultado=num/1000;
        }else if(op==2){//cm
            resultado=num/10;
        }else if(op==3){//mm
            resultado=num;
        }else if(op==4){//um
            resultado=num*1000;
        }else if(op==5){//nm
            resultado=num*1000000;
        }

        return resultado;
    }

    public double op4(int op, double num){

        double resultado=0;

        if(op==0){//km
            resultado=num/1000000000;
        }else if(op==1){//m
            resultado=num/1000000;
        }else if(op==2){//cm
            resultado=num/1000;
        }else if(op==3){//mm
            resultado=num/100;
        }else if(op==4){//um
            resultado=num;
        }else if(op==5){//nm
            resultado=num*1000;
        }

        return resultado;
    }

    public double op5(int op, double num){

        double resultado=0;
        long x=1000000000000L;

        if(op==0){//km
            resultado=num/x;
        }else if(op==1){//m
            resultado=num/1000000000;
        }else if(op==2){//cm
            resultado=num/10000000;
        }else if(op==3){//mm
            resultado=num/1000000;
        }else if(op==4){//um
            resultado=num/1000;
        }else if(op==5){//nm
            resultado=num;
        }

        return resultado;
    }

    DecimalFormat formatador = new DecimalFormat("0.000");

    ///Operações para base 10
    public String op0s(int op, double num){

        String resultado="";
        String result;
        int exp=0;


        if(op==0){//km

            resultado=""+num+"x10^0";

        }else if(op==1){//m

            result = formatador.format(desc(num));
            exp=3+casas;
            resultado=result+"x10^"+exp;

        }else if(op==2){//cm
            result = formatador.format(desc(num));
            exp=5+casas;
            resultado=result+"x10^"+exp;
        }else if(op==3){//mm
            result = formatador.format(desc(num));
            exp=6+casas;
            resultado=result+"x10^"+exp;
        }else if(op==4){//um
            result = formatador.format(desc(num));
            exp=9+casas;
            resultado=result+"x10^"+exp;
        }else if(op==5){//nm
            result = formatador.format(desc(num));
            exp=12+casas;
            resultado=result+"x10^"+exp;
        }

        return resultado;
    }

    public String op1s(int op, double num){

        String resultado="";
        String result;
        int exp=0;

        if(op==0){//kmetro
            result = formatador.format(desc(num));
            exp=-3+casas;
            resultado=result+"x10^"+exp;

        }else if(op==1){//m
            resultado=num+"x10^0";
        }else if(op==2){//cm
            result = formatador.format(desc(num));
            exp=2+casas;
            resultado=result+"x10^"+exp;

        }else if(op==3){//mm
            result = formatador.format(desc(num));
            exp=3+casas;
            resultado=result+"x10^"+exp;

        }else if(op==4){//um
            result = formatador.format(desc(num));
            exp=6+casas;
            resultado=result+"x10^"+exp;

        }else if(op==5){//nm
            result = formatador.format(desc(num));
            exp=9+casas;
            resultado=result+"x10^"+exp;
        }

        return resultado;
    }

    public String op2s(int op, double num){

        String resultado="";
        String result="";
        int exp=0;

        if(op==0){//km

            result = formatador.format(desc(num));
            exp=-5+casas;
            resultado=result+"x10^"+exp;

        }else if(op==1){//m

            result = formatador.format(desc(num));
            exp=-2+casas;
            resultado=result+"x10^"+exp;

        }else if(op==2){//cm
            resultado=num+"x10^0";

        }else if(op==3){//mm
            result = formatador.format(desc(num));
            exp=1+casas;
            resultado=result+"x10^"+exp;

        }else if(op==4){//um

            result = formatador.format(desc(num));
            exp=4+casas;
            resultado=result+"x10^"+exp;

        }else if(op==5){//nm
            result = formatador.format(desc(num));
            exp=7+casas;
            resultado=result+"x10^"+exp;
        }

        return resultado;
    }

    public String op3s(int op, double num){

        String resultado="";
        String result="";
        int exp=0;

        if(op==0){//km
            result = formatador.format(desc(num));
            exp=-6+casas;
            resultado=result+"x10^"+exp;
        }else if(op==1){//m
            result = formatador.format(desc(num));
            exp=-3+casas;
            resultado=result+"x10^"+exp;
        }else if(op==2){//cm
            result = formatador.format(desc(num));
            exp=-1+casas;
            resultado=result+"x10^"+exp;
        }else if(op==3){//mm
            resultado=num+"x10^0";
        }else if(op==4){//um
            result = formatador.format(desc(num));
            exp=3+casas;
            resultado=result+"x10^"+exp;
        }else if(op==5){//nm
            result = formatador.format(desc(num));
            exp=6+casas;
            resultado=result+"x10^"+exp;
        }
        return resultado;
    }

    public String op4s(int op, double num){

        String resultado="";
        String result="";
        int exp=0;

        if(op==0){//km
            result = formatador.format(desc(num));
            exp=-9+casas;
            resultado=result+"x10^"+exp;
        }else if(op==1){//m
            result = formatador.format(desc(num));
            exp=-6+casas;
            resultado=result+"x10^"+exp;
        }else if(op==2){//cm
            result = formatador.format(desc(num));
            exp=-4+casas;
            resultado=result+"x10^"+exp;
        }else if(op==3){//mm
            result = formatador.format(desc(num));
            exp=-3+casas;
            resultado=result+"x10^"+exp;
        }else if(op==4){//um
            resultado=num+"x10^0";
        }else if(op==5){//nm
            result = formatador.format(desc(num));
            exp=3+casas;
            resultado=result+"x10^"+exp;
        }
        return resultado;
    }

    public String op5s(int op, double num){

        String resultado="";
        String result="";
        int exp=0;


        if(op==0){//km
            result = formatador.format(desc(num));
            exp=-12+casas;
            resultado=result+"x10^"+exp;
        }else if(op==1){//m
            result = formatador.format(desc(num));
            exp=-9+casas;
            resultado=result+"x10^"+exp;
        }else if(op==2){//cm
            result = formatador.format(desc(num));
            exp=-7+casas;
            resultado=result+"x10^"+exp;
        }else if(op==3){//mm
            result = formatador.format(desc(num));
            exp=-6+casas;
            resultado=result+"x10^"+exp;
        }else if(op==4){//um
            result = formatador.format(desc(num));
            exp=-3+casas;
            resultado=result+"x10^"+exp;
        }else if(op==5){//nm
            resultado=num+"x10^0";
        }
        return resultado;
    }

    int casas=0;
    public double desc(double num){

        double resultado=0;
        if(num>=10000000){
            resultado = num/10000000;
            casas=7;
        }else if(num>=1000000){
            resultado = num/1000000;
            casas=6;
        }else if(num>=100000){
            resultado = num/100000;
            casas=5;
        }else if(num>=10000){
            resultado = num/10000;
            casas=4;
        }else if(num>=1000){
            resultado = num/1000;
            casas=3;
        }else if(num>=100){
            resultado =num/100;
            casas=2;
        }else if(num>=10){
            resultado =num/10;
            casas=1;
        }else{
            resultado=num;
            casas=0;
        }
        return resultado;
    }

    public void button_0(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "0");
    }
    public void button_1(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "1");
    }
    public void button_2(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "2");
    }
    public void button_3(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "3");
    }
    public void button_4(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "4");
    }
    public void button_5(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "5");
    }
    public void button_6(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "6");
    }
    public void button_7(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "7");
    }
    public void button_8(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "8");
    }
    public void button_9(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + "9");
    }
    public void button_dot(View v) {
        String valor = texto1.getText().toString();
        texto1.setText(valor + ".");
    }
    public void button_erase(View v) {
        String valor = texto1.getText().toString();

        if (valor.length() > 0) {
            texto1.setText(valor.substring(0, valor.length() - 1));

        } else {
            texto1.setText("");
        }
    }
    public void button_clear(View v){
        texto1.setText("");
        texto2.setText("");
    }

    public void button_x10(View v) {
        if(x10){
            x10=false;
        }else{
            x10=true;
        }
    }

}
