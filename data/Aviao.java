package data;

public class Aviao {
    String nome;
    int capacidade;
    String tipo;
     
    public Aviao(String nome, int capacidade, String tipo){
        this.nome = nome;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getCapacidade(){
        return capacidade;
    }

    public String getDadosAviao(){
        return "Nome: " + nome + "\nCapacidade: " + capacidade + "\nTipo de avião: " + tipo;
    }
}