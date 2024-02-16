package src;

import java.util.ArrayList;
import business.exceptions.AviaoInvalidoException;

public class Aviao {
    String nome;
    int capacidade;
    String tipo;
     
    ArrayList <Aviao> avioes = new ArrayList<Aviao>();
    
    public void setAviao(String no, int ca, String ti){
        nome = no;
        capacidade = ca;
        tipo = ti;
    }

    public String getNome(){
        return nome;
    }
    
    public int getCapacidade(){
        return capacidade;
    }

    public String getDadosAviao(){
        return "Nome: " + nome + "\nCapacidade: " + capacidade + "\nTipo de avião: " + tipo+"\n\n";
    }

    public void inserirAviao(String no, int ca, String ti){
        Aviao aviao = new Aviao();
        aviao.setAviao(no, ca, ti);
        avioes.add(aviao);
        //avioesDisponiveis.add(aviao);
        System.out.println("\nAvião cadastrado!");
    }

    public void listarAvioes(){
        for(Aviao a : avioes){
            System.out.println(a.getDadosAviao());
        }
    }

    public Aviao matchAviao(String aviaoNome) throws AviaoInvalidoException{
        try{
            for(Aviao a : avioes){
                if(a.getNome().equals(aviaoNome)){
                    return a;
                }
            }
            throw new AviaoInvalidoException("ERRO! Avião: "+ aviaoNome +" inválido, ou inexistente.");
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new AviaoInvalidoException("ERRO ao procurar avião: " + e.getMessage());
        }    
    }
}