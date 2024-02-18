package src;

import java.util.ArrayList;
import business.exceptions.AviaoInvalidoException;
import business.exceptions.DadosVaziosExceptions;
import business.exceptions.ObjetoNaoCadastradoException;

public class Aviao{
    String nome;
    int capacidade;
    String tipo;
     
    ArrayList <Aviao> avioes = new ArrayList<Aviao>();
    
    public void setAviao(String no, int ca, String ti) throws DadosVaziosExceptions{
        if(no == "" || ca == 0 || ti == ""){
            throw new DadosVaziosExceptions("\nERRO: Está sendo passado dados VAZIOS.");
        }else if(no == null || ca == 0 || ti == null){
            throw new DadosVaziosExceptions("\nERRO: Está sendo passado dados NULOS.");
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

    public void inserirAviao(String no, int ca, String ti){
        try{
            Aviao aviao = new Aviao();
            aviao.setAviao(no, ca, ti);
            avioes.add(aviao);
            //avioesDisponiveis.add(aviao);
            System.out.println("\nAvião cadastrado!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarAvioes() throws ObjetoNaoCadastradoException{
        for(Aviao a : avioes){
            if(a == null){
                throw new ObjetoNaoCadastradoException();
            }else{
                System.out.println(a.getDadosAviao());
            }
        }
    }

    public Aviao matchAviao(String aviaoNome) throws AviaoInvalidoException{
        for(Aviao a : avioes){
            if(a.getNome().equals(aviaoNome)){
                return a;
            }
        }
        throw new AviaoInvalidoException("\nERRO: Avião inválido, ou inexistente.");     
    }
}