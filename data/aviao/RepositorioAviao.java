package aviao;

import java.util.ArrayList;
import business.exceptions.ObjetoNaoCadastradoException;

public class RepositorioAviao{
    ArrayList <Aviao> avioes = new ArrayList<Aviao>();

    public void inserirAviao(String no, int ca, String ti){
        try{
            Aviao aviao = new Aviao();
            aviao.setAviao(no, ca, ti);
            avioes.add(aviao);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarAvioes() throws ObjetoNaoCadastradoException{
        if(avioes.isEmpty()){
            throw new ObjetoNaoCadastradoException();
        }
        for(Aviao a : avioes){
            System.out.println(a.getDadosAviao()); 
        }
    }

    public ArrayList<Aviao> getArrayListAvioes(){
        return avioes;
    }
}
