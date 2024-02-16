package business;

import java.util.ArrayList;

import src.Passageiro;
import src.Voo;

public class Passagem{
    Voo voo;
    Passageiro passageiro;

    ArrayList <Passagem> passagens = new ArrayList<Passagem>();

    public void setPassagem(Voo v, Passageiro p){
        voo = v;
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
        for(Passagem p : passagens){
            System.out.println(p.passageiro.getDadosPassageiro());
        }
    }

    public void inserirPassagem(Passagem p){
        
        passagens.add(p);
    }
}