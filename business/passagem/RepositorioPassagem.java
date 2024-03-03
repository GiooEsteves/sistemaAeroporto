package business.passagem;

import java.util.ArrayList;

import business.exceptions.DadosVaziosException;
import passageiro.Passageiro;
import voo.Voo;

public class RepositorioPassagem{
    ArrayList <Passagem> passagens = new ArrayList<Passagem>();

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
            return passagem;
        }catch(DadosVaziosException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
