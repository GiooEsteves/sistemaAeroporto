package business;

import data.Passageiro;

public class ComprarPassagem {
    Voo voo;
    Passageiro passageiro;
    
    public ComprarPassagem(Voo v){
        this.voo = v;
    }

    public void setPassageiro(Passageiro p){
        passageiro = p;
    }

    public void getPagamento(int qtdPassageiro){
        System.out.println("Valor da passagem: R$" + voo.valorUnitario);
        System.out.println(qtdPassageiro + " assentos" + " * " + voo.valorUnitario);
        System.out.println("Total a pagar R$" + (qtdPassageiro * voo.valorUnitario));
    }

    public String getPassagem(){
        return "    PASSAGEM" + voo.getPlaneInfo() + "  " +passageiro.getDadosPassageiro()+"\n\n";
    }
}