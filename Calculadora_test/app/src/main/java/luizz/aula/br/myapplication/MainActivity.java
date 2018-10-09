package luizz.aula.br.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton soma, menos, multip, divisao, igual;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, apagar;
    TextView text1, text2;
    boolean verf = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.but1);
        button2 = (Button) findViewById(R.id.but2);
        button3 = (Button) findViewById(R.id.but3);
        button4 = (Button) findViewById(R.id.but4);
        button4 = (Button) findViewById(R.id.but4);
        button4 = (Button) findViewById(R.id.but4);
        button4 = (Button) findViewById(R.id.but4);
        button4 = (Button) findViewById(R.id.but4);
        button4 = (Button) findViewById(R.id.but4);
        button4 = (Button) findViewById(R.id.but4);
        button4 = (Button) findViewById(R.id.but4);
        apagar = (Button) findViewById(R.id.buttonDEL);

        soma = (ImageButton) findViewById(R.id.sum);
        menos = (ImageButton) findViewById(R.id.minus);
        multip = (ImageButton) findViewById(R.id.multi);
        divisao = (ImageButton) findViewById(R.id.division);
        igual = (ImageButton) findViewById(R.id.result);

        text1 = (TextView) findViewById(R.id.valores);
        text2 = (TextView) findViewById(R.id.resultado);


    }

    public void button_0(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "0");

    }

    public void button_1(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "1");

    }

    public void button_2(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "2");

    }

    public void button_3(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "3");

    }

    public void button_4(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "4");

    }

    public void button_5(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "5");

    }

    public void button_6(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "6");

    }

    public void button_7(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "7");

    }

    public void button_8(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "8");

    }

    public void button_9(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "9");

    }

    public void button_point(View v) {

        String valor = text1.getText().toString();
        text1.setText(valor + ".");

    }

    public void button_sum(View v) {

        String valor = text1.getText().toString();
        text1.setText(valor + "+");

    }

    public void button_multi(View v) {

        String valor = text1.getText().toString();
        text1.setText(valor + "x");

    }

    public void button_divis(View v) {

        String valor = text1.getText().toString();
        text1.setText(valor + "/");

    }

    public void button_minus(View v) {
        if (verf) {
            text1.setText("");
            verf = false;
        }
        String valor = text1.getText().toString();
        text1.setText(valor + "-");

    }

    public void button_erase(View v) {
        String valor = text1.getText().toString();

        if (valor.length() > 0) {
            text1.setText(valor.substring(0, valor.length() - 1));

        } else {
            text1.setText("");
        }
    }

    public void button_result(View v) {

        String valor = text1.getText().toString();
        valor += "#";
        String valor1 = "", valor2 = "";
        char operacao = 0;
        boolean newconta = false;

        for (int i = 0; i < valor.length() - 1; i++) {
            if (valor.charAt(i) == '-' || valor.charAt(i) == '+' || valor.charAt(i) == '/' || valor.charAt(i) == 'x') {
                if (valor.charAt(i) == '-' || i == 0) {
                    valor1 += valor.charAt(i);
                } else if (valor.charAt(i) == '-') {
                    operacao = '-';
                    newconta = true;
                } else if (valor.charAt(i) == '+') {
                    operacao = '+';
                    newconta = true;
                } else if (valor.charAt(i) == '/') {
                    operacao = '/';
                    newconta = true;
                } else if (valor.charAt(i) == 'x') {
                    operacao = 'x';
                    newconta = true;
                } else {
                    break;
                }

                if (!newconta) {
                    valor2 += valor.charAt(i);
                } else {
                    valor1 += valor.charAt(i);
                }
            }



            text2.setText(""+fazconta(valor1,valor2.substring(1, valor2.length()), operacao));

                /*if (valor.charAt(i) == '+') {

                    newconta=true;
                }

                }
            if (!newconta) {
                valor1 += valor.charAt(i);
            } else {
                if(valor.charAt(i)=='+'){
                    valor2+="";
                }
                valor2 += valor.charAt(i);
            }
            }
            String val= ""+valor2;


        text2.setText(val.substring(1, val.length()));
        */
            verf = true;

        }
    }

    public double fazconta(String A, String B, char conta) {

        double x= Double.parseDouble(A);
        double y= Double.parseDouble(B);
        double result=0;

        switch (conta){
            case '+':
                result=x+y;
        }

        return result;
    }

}
