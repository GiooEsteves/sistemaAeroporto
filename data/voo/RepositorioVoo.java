package voo;

import java.util.ArrayList;
import business.exceptions.ObjetoNaoCadastradoException;
import business.exceptions.VooInvalidoException;
import business.exceptions.VooLotadoException;
import aviao.Aviao;

public class RepositorioVoo{
    ArrayList <Voo> voos = new ArrayList<Voo>();    
    Voo voo = new Voo();
    
    public void inserirVoo(Aviao a, String h, String da, String o, String dest, double vUnit){
        try{
            Voo voo = new Voo();
            voo.setVoo(a, h, da, o, dest, vUnit); 
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

    public Voo escolherVoo(String dta, String nDestino, int numPassageiro) throws VooInvalidoException, VooLotadoException{
        for(Voo v : voos){
            if(v.getData().equals(dta) && v.getDestino().equals(nDestino) && v.getCapacidade() >= (v.getABordo() + numPassageiro)){
                return v;
            }else if(v.getData().equals(dta) && v.getDestino().equals(nDestino) && v.getCapacidade() < (v.getABordo() + numPassageiro)){
                throw new VooLotadoException("Há apenas " + (v.getCapacidade() - v.getABordo()) + " assento(s)");
            }
        }
        throw new VooInvalidoException();
    }

    public Voo matchVoo(String dta, String nDestino) throws VooInvalidoException{
        for(Voo v : voos){
            if(v.getData().equals(dta) && v.getDestino().equals(nDestino)){
                System.out.print(v.getPlaneInfo());
                return v;
            }
        }
        throw new VooInvalidoException();
    }

    public void atualizarVoo(int esc, String dta, String nDestino, String novoNome, String novoHorario, String novaData, double novoValor){
        try{
            Voo vooParaAtualizar = matchVoo(dta, nDestino);
            if(esc == 1){
                voo.setAviaoDoVoo(vooParaAtualizar, novoNome);  // NÃO ESTÁ FUNCIONANDO, ESTOURA ERRO DE AVIÃO INVÁLIDO
            }else if(esc == 2){
                voo.setHorario(vooParaAtualizar, novoHorario);
            }else if(esc == 3){
                voo.setData(vooParaAtualizar, novaData);
            }else if(esc == 4){
                voo.setValor(vooParaAtualizar, novoValor);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirVoo(String data, String destino){
        try{
            Voo vooParaExcluir = matchVoo(data, destino);
            voos.remove(vooParaExcluir);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
