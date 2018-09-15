/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.ArrayList;


/**
 *
 * @author 6530729
 */
public class Prova {

    private String nomeDaDisciplina;
    private String local;
    private String data;
    private ArrayList<Questao> questao;
    private int peso;

    //CONSTRUTOR
    public Prova() {
        questao= new ArrayList<>();
    }

    
    //METODOS
    public String obtemDetalhes() {

        String retorno = "";

        retorno += "Nome da disciplina: " + this.getNomeDaDisciplina() + "\r\n";
        retorno += "Local da prova: " + this.getLocal() + "\r\n";
        retorno += "Data da prova: " + this.getData() + "\r\n";
        retorno += "Peso da prova: " + this.getPeso();

        return retorno;

    }

    public String obtemProvaImpressao() {

        String retorno = this.obtemDetalhes();
        boolean empty = true;
        retorno += "\r\n================================================================\r\n\r\n";

        //QUESTÕES DISCURSIVAS
        for (Questao x : questao) {
            if (x != null) {
                empty = false;
                break;
            }
        }

        if (empty == false) {

            for (int i = 0; i < questao.size() ; i++) {
                retorno += (i + 1) + "-" + this.questao.get(i).retornaQuestao();
            }
            
        } else {
            retorno += "Nao ha questoes.\r\n";
        }

        return retorno;
    }
    
    //Get and Setters
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

    public ArrayList<Questao> getQuestao() {
        return questao;
    }

    public void setQuestao(ArrayList<Questao> questao) {
        this.questao = questao;
    }

    

    
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
    

}
