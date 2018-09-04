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
public class Prova {

    //ATRIBUTOS
    private String nomeDaDisciplina;
    private String local;
    private String data;
    private Discursiva[] questoesDiscursivas;
    private Objetiva[] questoesObjetivas;
    private int peso;

    //CONSTRUTOR
    public Prova() {

    }

    //METODOS
    public String obtemDetalhes() {

        String retorno = "------------------------------------------\n\n";

        retorno += "Nome da disciplina: " + this.getNomeDaDisciplina() + "\n";
        retorno += "Local da prova: " + this.getLocal() + "\n";
        retorno += "Data da prova: " + this.getData() + "\n";
        retorno += "Peso da prova: " + this.getPeso();

        return retorno;

    }

    public String obtemProvaImpressao() {

        String retorno = "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n\n";
        //QUESTÕES DISCURSIVAS
        boolean empty = true;

        for (Discursiva x : questoesDiscursivas) {
            if (x != null) {
                empty = false;
                break;
            }
        }

        if (empty == false) {

            retorno += "Questões Discursivas. \n";
            for (int i = 0; i < this.questoesDiscursivas.length; i++) {

                retorno += (i + 1) + "-" + this.questoesDiscursivas[i].getPergunta() + " [" + this.questoesDiscursivas[i].getPeso() + "]" + "\n\n";
                retorno += "Critério: " + this.questoesDiscursivas[i].getCriteriosCorrecao() + "\n\n";

            }
        } else {
            retorno += "Nao ha questoes discursivas.\n";
        }

        retorno += "___________________________\n\n";

        //QUESTÕES OBJETIVAS
        for (Objetiva x : questoesObjetivas) {
            if (x != null) {
                empty = false;
                break;
            }
        }

        if (empty == false) {

            retorno += "Questões Objetivas. \n";
            for (int i = 0; i < this.questoesObjetivas.length; i++) {

                retorno += (i + 1) + "-" + this.questoesObjetivas[i].getPergunta() + " " + "[" + this.questoesObjetivas[i].getPeso() + "]" + "\n";

                String[] op = this.questoesObjetivas[i].getOpcoes();
                for (int j = 0; j < 5; j++) {
                    retorno += " (" + (j + 1) + ") " + op[j] + "\n";
                }
                retorno += "R: " + this.questoesObjetivas[i].getRespostaCorreta() + "\n\n";
            }
        } else {
            retorno += "Nao ha questoes objetivas.\n";
        }

        retorno += "\n\n";

        return retorno;
    }

    //GET and SETTERS
    public String getNomeDaDisciplina() {
        return nomeDaDisciplina;
    }

    public void setNomeDaDisciplina(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Discursiva[] getQuestoesDiscursivas() {
        return questoesDiscursivas;
    }

    public void setQuestoesDiscursivas(Discursiva[] questoesDiscursivas) {
        this.questoesDiscursivas = questoesDiscursivas;
    }

    public Objetiva[] getQuestoesObjetivas() {
        return questoesObjetivas;
    }

    public void setQuestoesObjetivas(Objetiva[] questoesObjetivas) {
        this.questoesObjetivas = questoesObjetivas;
    }

}
