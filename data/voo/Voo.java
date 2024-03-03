package voo;

import aviao.Aviao;
import aviao.RepositorioAviao;
import business.exceptions.DadosVaziosException;

public class Voo {
    Aviao aviao;
    String horario;
    String data;
    String origem;
    String destino;
    public double valorUnitario;
    int aBordo;

    public void setVoo(Aviao a, String h, String da, String o, String dest, double vUnit) throws DadosVaziosException{
        if(a == null || h == "" || da == "" || o == "" || dest == "" || vUnit == 0){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados VAZIOS.");
        }else if(a == null || h == null || da == null || o == null || dest == null || vUnit == 0){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados NULOS.");
        }else{
            aviao = a;
            horario = h;
            data = da;
            origem = o;
            destino = dest;
            valorUnitario = vUnit;
        }
    }

    public void setAviaoDoVoo(Voo vooParaAtualizar, String novoNome){
        RepositorioAviao repAviao = new RepositorioAviao();
        try{
            Aviao a = repAviao.matchAviao(novoNome); // NÃO ESTÁ FUNCIONANDO
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

    public void setABordo(int qtd){
        aBordo = aBordo + qtd;
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
        return "Aeroporto Guararapes" + "\nAvião: "+ aviao.getNome() +"\nData: " + data + "\nHorário: " + horario 
                + "\nOrigem: " +origem+ "   Destino: " +destino+"\n";
    }
}