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
    
    private String[] opcoes;
    private int resposta;
    
    //CONSTRUTOR
    public Objetiva(){
        
        this.opcoes = new String[5];
        
    }
    
    
    //GET and SETTERS
    public String[] getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }
    
    
    
    
    
    
    
    
}
