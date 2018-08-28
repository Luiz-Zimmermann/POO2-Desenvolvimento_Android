/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import javax.swing.JOptionPane;

/**
 *
 * @author 6530729
 */
public class GeradorProva {

    public static void main(String[] args) {

        String materia = JOptionPane.showInputDialog("Informe a materia.");

        double nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a Nota."));

        Prova x = new Prova(materia, nota);

        int numeroQuestoes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de questoes Discursivas."));

        String dados = JOptionPane.showInputDialog("Informe a materia.");
        
        for (int i = 0; i < numeroQuestoes; i++) {

            //opcao=JOptionPane.showInputDialog("Descreva a pergunta.");
        }

        //Objetiva a= new Objetiva();
        /*a.setPergunta("Oque e a vida?");
        a.setPeso(1000);
        String[] opcoes=new String[5];
        opcoes[0]="Eu n sei";
        opcoes[1]="sla po";
        opcoes[2]="Eu qro dormir po";
        opcoes[3]="Ninguem sabe";
        opcoes[4]="So Deus sabe";
        
        a.setOpcoes(opcoes);
        a.setRespostaCorreta(4);
        
        Discursiva o= new Discursiva();
        o.setPergunta("Nome da disciplina: ");
        o.setCriterioCorrecao("N tem");
        o.setPeso(2);
         */
    }

}
