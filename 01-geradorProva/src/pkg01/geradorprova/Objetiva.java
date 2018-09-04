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
final class Objetiva extends Questao {

    //ATRIBUTOS
    private String[] opcoes;
    private int respostaCorreta;

    //CONSTRUTOR
    public Objetiva() {

        this.opcoes = new String[5];

    }

    @Override
    public String retornaQuestao() {

        String retorno = "";

        //QUESTÕES OBJETIVAS
        retorno += "Questões Objetivas. \n";

        retorno +=  this.getPergunta() + " " + "[" + this.getPeso() + "]" + "\n";

        String[] op = this.getOpcoes();
        for (int j = 0; j < 5; j++) {
            retorno += " (" + (j + 1) + ") " + op[j] + "\n";
        }
        retorno += "R: " + this.getRespostaCorreta() + "\n\n";

        return retorno;
    }

    //GET and SETTERS
    public String[] getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    

}
