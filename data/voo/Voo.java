package voo;

import java.util.ArrayList;
import aviao.Aviao;
import business.busca.Busca;
import business.exceptions.DadosVaziosException;

public class Voo {
    Aviao aviao;
    String nome;
    String horario;
    String data;
    String origem;
    String destino;
    public double valorUnitario;
    int aBordo;

    public void setVoo(Aviao a, String n, String h, String da, String o, String dest, double vUnit) throws DadosVaziosException{
        if(a == null || h == "" || da == "" || o == "" || dest == "" || vUnit == 0){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados VAZIOS.");
        }else if(a == null || h == null || da == null || o == null || dest == null || vUnit == 0){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados NULOS.");
        }else{
            aviao = a;
            nome = n;
            horario = h;
            data = da;
            origem = o;
            destino = dest;
            valorUnitario = vUnit;
        }
    }

    public void setAviaoDoVoo(ArrayList<Aviao> avioes, Voo vooParaAtualizar, String novoNome){
        try{
            Aviao a = Busca.matchAviao(avioes, novoNome);
            vooParaAtualizar.aviao = a;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void setHorario(Voo vooParaAtualizar, String h){
        vooParaAtualizar.horario = h;
    }

    public void setData(Voo vooParaAtualizar, String d){
        vooParaAtualizar.data = d;
    }

    public void setValor(Voo vooParaAtualizar, double v){
        vooParaAtualizar.valorUnitario = v;
    }

    public void setABordo(){
        aBordo = aBordo + 1;
    }

    public String getNome(){
        return nome;
    }

    public int getABordo(){
        return aBordo;
    }

    public String getData(){
        return data;
    }

    public String getDestino(){
        return destino;
    }

    public int getCapacidade(){
        return aviao.getCapacidade();
    }

    public String getPlaneInfo(){
        return "Aeroporto Guararapes" + "\nVoo: " + nome +"\nAvião: "+ aviao.getNome() +"\nData: " + data + "\nHorário: " + horario 
                + "\nOrigem: " +origem+ "   Destino: " +destino+"\n";
    }
}