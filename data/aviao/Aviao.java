package aviao;

import business.exceptions.DadosVaziosException;

public class Aviao{
    String nome;
    int capacidade;
    String tipo;
    
    public void setAviao(String no, int ca, String ti) throws DadosVaziosException{
        if(no == "" || ca == 0 || ti == ""){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados VAZIOS.");
        }else if(no == null || ca == 0 || ti == null){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados NULOS.");
        }else{
            nome = no;
            capacidade = ca;
            tipo = ti;
        }
    }

    public String getNome(){
        return nome;
    }
    
    public int getCapacidade(){
        return capacidade;
    }

    public String getDadosAviao(){
        return "Nome: " + nome + "\nCapacidade: " + capacidade + "\nTipo de avião: " + tipo + "\n";
    }
}