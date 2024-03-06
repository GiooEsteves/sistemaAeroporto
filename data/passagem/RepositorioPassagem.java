package passagem;

import java.util.ArrayList;
import business.exceptions.DadosVaziosException;
import business.exceptions.ObjetoNaoCadastradoException;
import passageiro.Passageiro;
import voo.Voo;

public class RepositorioPassagem{
    ArrayList <Passagem> passagens = new ArrayList<Passagem>();

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

    public void listarPassageirosPorPassagem() throws ObjetoNaoCadastradoException{ // LISTA PASSAGEIRO POR VOO
        if(passagens.isEmpty()){
            throw new ObjetoNaoCadastradoException();
        }
        for(Passagem p : passagens){
            System.out.println("Voo " + p.voo.getNome() + "\n" +p.passageiro.getDadosPassageiro());
        }
    }
}
