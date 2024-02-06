package business;

import src.Passageiro;
import src.Voo;

public class Passagem{
    Voo voo;
    Passageiro passageiro;
    
    public Passagem(Voo v){
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

    public void getPassageirosDoVoo(){
        
    }
}