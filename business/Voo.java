package business;

import data.Aviao;

public class Voo {
    Aviao aviao;
    String horario;
    String data;
    String origem;
    String destino;
    double valorUnitario;
    int aBordo;

    public Voo(Aviao aviao, String horario, String data, String origem, String destino, double valorUnitario){
        this.aviao = aviao;
        this.horario = horario;
        this.data = data;
        this.origem = origem;
        this.destino = destino;
        this.valorUnitario = valorUnitario;
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

    public int _getCapacidade(){
        return aviao.getCapacidade();
    }

    public String getPlaneInfo(){
        return "\nAeroporto Guararapes" + "\nData: " + data + "\nHorário: " + horario + "\nOrigem: " +origem+ "   Destino: " +destino;
    }
}