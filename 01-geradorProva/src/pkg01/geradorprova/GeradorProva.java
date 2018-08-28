/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author 6530729
 */
public class GeradorProva {

    
    
          
    
    
    public static void main(String[] args) {
        Prova x= new Prova("POO");
        //x.nomeDisciplina="POO";
        //x.setData("2018.08.28");
        //x.setLocal("Univali, Lab 3 - Bloco B6");
        //x.peso=4;
        
        Objetiva a= new Objetiva();
        a.setPergunta("Oque e a vida?");
        a.setPeso(1000);
        String[] opcoes=new String[5];
        opcoes[0]="Eu n sei";
        opcoes[1]="sla po";
        opcoes[2]="Eu qro dormir po";
        opcoes[3]="Ninguem sabe";
        opcoes[4]="So Deus sabe";
        
        a.setOpcoes(opcoes);
        a.setResposta(4);
        
        Discursiva o= new Discursiva();
        o.setPergunta("Nome da disciplina: ");
        o.setCriterioCorrecao("N tem");
        o.setPeso(2);
        //System.out.println(x.obtemDetalhes());
          
    }
    
}
