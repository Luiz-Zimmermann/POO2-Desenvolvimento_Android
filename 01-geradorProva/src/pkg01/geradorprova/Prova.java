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

    private String nomeDisciplina;
    private double peso;
    private String local;
    private String data;
    private Discursiva;
    private string Objetiva;
    
    
    

    //CONSTRUTOR
    public Prova(String nome, double nota) {

        this.setNomeDisciplina(nome);
        this.setPeso(nota);

    }

    //METODOS
    public String obtemDetalhes() {
        String retorno = "";
        retorno = retorno + "Nome: " + this.getNomeDisciplina() + "\n";
        retorno = retorno + "Local: " + this.getLocal() + "\n";
        retorno = retorno + "Data: " + this.getData() + "\n";
        retorno += retorno + "Peso: " + this.getPeso() + "\n";
        return retorno;
    }
    
    

    //GET AND SETTERS
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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
    
    

}
