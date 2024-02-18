package business;

import java.util.ArrayList;

import business.exceptions.DadosVaziosException;
import src.Passageiro;
import src.Voo;

public class Passagem{
    Voo voo;
    Passageiro passageiro;

    ArrayList <Passagem> passagens = new ArrayList<Passagem>();

    public void setPassagem(Voo v, Passageiro p) throws DadosVaziosException{
        if(v == null || p == null){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados NULOS.");
        }else{
            voo = v;
            passageiro = p;
        }
    }

    public void getPagamento(int qtdPassageiro, double valorUnitario){
        System.out.println("Valor da passagem: R$" + valorUnitario);
        System.out.println(qtdPassageiro + " assento(s)" + " * " + valorUnitario);
        System.out.println("Total a pagar R$" + (qtdPassageiro * valorUnitario));
    }

    public String getPassagem(Passagem p){
        return "    PASSAGEM" + p.voo.getPlaneInfo() + "  " + p.passageiro.getDadosPassageiro();
    }

    public void getPassageirosDoVoo(){          // COLOCAR EXCEPTION SE FOR USAR
        for(Passagem p : passagens){
            System.out.println(p.passageiro.getDadosPassageiro());
        }
    }

    public Passagem inserirPassagem(Voo v, Passageiro p){
        try{
            Passagem passagem = new Passagem();
            passagem.setPassagem(v, p);
            passagens.add(passagem);
            System.out.println("\nPassagem de "+ passagem.passageiro.getNome() +" comprada com sucesso.");
            return passagem;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}