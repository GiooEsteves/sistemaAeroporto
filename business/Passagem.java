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

    public void getPagamento(int qtdPassageiro, double valorUnitario){      // COLOCAR UM EXCEPTION
        System.out.println("Valor da passagem: R$" + valorUnitario);
        System.out.println(qtdPassageiro + " assento(s)" + " * " + valorUnitario);
        System.out.println("Total a pagar R$" + (qtdPassageiro * valorUnitario));
    }

    public String getPassagem(Passagem p){
        return "    PASSAGEM" + p.voo.getPlaneInfo() + "  " + p.passageiro.getDadosPassageiro();
    }

    public void getPassageirosDoVoo(){      // COLOCOAR EXCEPTION
        for(Passagem p : passagens){
            System.out.println(p.passageiro.getDadosPassageiro());
        }
    }

    public Passagem inserirPassagem(Voo v, Passageiro p){       // COLOCAR TRY CATCH
        Passagem passagem = new Passagem();
        passagem.setPassagem(v, p);
        passagens.add(passagem);
        System.out.println("Passagem de " + passagem.passageiro.getNome() +" comprada com sucesso.");
        return passagem;
    }
}