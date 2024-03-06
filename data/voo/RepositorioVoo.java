package voo;

import java.util.ArrayList;
import business.busca.Busca;
import business.exceptions.ObjetoNaoCadastradoException;
import aviao.Aviao;

public class RepositorioVoo{
    ArrayList <Voo> voos = new ArrayList<Voo>();    
    Voo voo = new Voo();
    
    public void inserirVoo(Aviao a, String n, String h, String da, String o, String dest, double vUnit){
        try{
            Voo voo = new Voo();
            voo.setVoo(a, n, h, da, o, dest, vUnit); 
            voos.add(voo);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void listarVoos() throws ObjetoNaoCadastradoException{
        if(voos.isEmpty()){
            throw new ObjetoNaoCadastradoException();
        }
        for(Voo v : voos){
            System.out.println(v.getPlaneInfo());    
        }
    }

    public void atualizarAviaoVoo(ArrayList<Aviao> avioes, Voo vooParaAtualizar, String novoNome, String novoHorario, String novaData, double novoValor){
        voo.setAviaoDoVoo(avioes, vooParaAtualizar, novoNome);
    }

    public void atualizarHoraVoo(Voo vooParaAtualizar, String novoNome, String novoHorario, String novaData, double novoValor){
        voo.setHorario(vooParaAtualizar, novoHorario);        
    }

    public void atualizarDataVoo(Voo vooParaAtualizar, String novoNome, String novoHorario, String novaData, double novoValor){
        voo.setData(vooParaAtualizar, novaData);        
    }

    public void atualizarValorVoo(Voo vooParaAtualizar, String novoNome, String novoHorario, String novaData, double novoValor){
        voo.setValor(vooParaAtualizar, novoValor);            
    }

    public void excluirVoo(String nomeVoo){
        try{
            Voo vooParaExcluir = Busca.matchVoo(voos, nomeVoo);
            voos.remove(vooParaExcluir);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Voo> getArrayListVoo(){
        return voos;
    }
}
