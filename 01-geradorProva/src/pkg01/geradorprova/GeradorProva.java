package pkg01.geradorprova;

import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

/**
 *
 * @author 6530729 = Luiz Zimmermann
 */
public class GeradorProva {

    //Função que obtem os dados da prova
    static public void obtemProva(Prova x) {

        x.setNomeDaDisciplina(JOptionPane.showInputDialog("Informe o nome da disciplina."));
        x.setLocal(JOptionPane.showInputDialog("Informe o local da prova."));
        x.setData(JOptionPane.showInputDialog("Informe a data da prova."));
        while (true) {
            try {
                x.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Informe o peso da prova.")));
                break;
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, a.getMessage());
                JOptionPane.showMessageDialog(null, "Valor incorreto!!!!!");
            }
        }
    }

    //Função que retorna uma questão Discursiva
    static public Discursiva obtemDis(Discursiva x) {

        x.setPergunta(JOptionPane.showInputDialog("Informe a pergunta: "));

        x.setCriteriosCorrecao(JOptionPane.showInputDialog("Informe o critério de correção: "));

        while (true) {
            try {
                x.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o peso da questao: ")));

                break;
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, a.getMessage());
                JOptionPane.showMessageDialog(null, "Valor incorreto.");
            }

        }

        return x;
    }

    //Função que retorna uma questão objetiva
    static public Objetiva obtemObj(Objetiva x) {
        //Pergunta
        x.setPergunta(JOptionPane.showInputDialog("Informe a pergunta: "));

        //Declaração das opções 
        String[] op = new String[5];
        for (int i = 0; i < 5; i++) {
            op[i] = JOptionPane.showInputDialog("Informe a alternativa " + (i + 1) + ":");
        }
        x.setOpcoes(op);

        //Resposta correta e consistencia
        while (true) {
            try {
                x.setRespostaCorreta(Integer.parseInt(JOptionPane.showInputDialog("Informe a resposta correta(Entre 1 a 5).: ")));
                if (x.getRespostaCorreta() < 1 || x.getRespostaCorreta() > 5) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, a.getMessage());
                JOptionPane.showMessageDialog(null, "Valor incorreto.");
            }

        }
        //Peso da questão e consistencia
        while (true) {
            try {
                x.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o peso da questao: ")));

                break;
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, a.getMessage());
                JOptionPane.showMessageDialog(null, "Valor incorreto.");
            }
        }

        return x;
    }

    
   
    //FUNÇÃO MAIN DO PROGRAMA
    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
        Prova avaliacao = new Prova();

        obtemProva(avaliacao);

        boolean cond = true;

        ArrayList<Questao> lista = new ArrayList<>();

        do {
            String op = JOptionPane.showInputDialog("Discursiva(R) ou Objetiva(O)?");
            do {

                try {

                    if (!"O".equals(op) && !"R".equals(op)) {
                        JOptionPane.showMessageDialog(null, op);
                        throw new IllegalArgumentException();
                    }
                    break;

                } catch (IllegalArgumentException a) {
                    JOptionPane.showMessageDialog(null, a.getMessage());
                    JOptionPane.showMessageDialog(null, "Valor incorreto, informe novamente.");
                    op = JOptionPane.showInputDialog("Discursiva(R) ou Objetiva(O)?");
                }
            } while (true);

            if ("R".equals(op)) {
                Discursiva x = new Discursiva();
                lista.add(obtemDis(x));

            } else if ("O".equals(op)) {
                Objetiva x = new Objetiva();
                lista.add(obtemObj(x));

            } else {
                System.out.println("Não é possivel");
            }

            String condi = JOptionPane.showInputDialog("Deseja adicionar mais Questões?,Sim(S) ou Não(N)");
            do {
                if ("S".equals(condi)) {
                    cond = true;
                } else if ("N".equals(condi)) {
                    cond = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Valor incorreto, insira novamente.");
                    condi = JOptionPane.showInputDialog("Deseja adicionar mais Questões?,Sim(S) ou Não(N)");

                }
            } while (!"S".equals(condi) && !"N".equals(condi));

        } while (cond == true);

        avaliacao.setQuestao(lista);
        System.out.println(avaliacao.obtemProvaImpressao());

        FileOutputStream escrever = null;
        String salvar = avaliacao.obtemProvaImpressao();

        try {

            File file = new File("C:\\Users\\Luiz Zimmermann\\Desktop\\newfile.txt");
            boolean vCria = file.createNewFile();
            escrever = new FileOutputStream(file);
            
            
            if (vCria) {
                JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso.");

            } else {
                JOptionPane.showMessageDialog(null, "O arquivo ja existe");
            }

            byte[] bytesArray = salvar.getBytes();
            escrever.write(bytesArray);
            escrever.flush();
            System.out.println("File Written Successfully");

        } catch (IOException a) {
            JOptionPane.showMessageDialog(null, a.getMessage());

        } catch (SecurityException a) {
            JOptionPane.showMessageDialog(null, a.getMessage() + "\tAcesso negado");
        } finally {
            try {
                if (escrever != null) {

                    escrever.close();
                }
            } catch (IOException esc) {
                JOptionPane.showMessageDialog(null, esc.getMessage());
            }
        }

    }

}
