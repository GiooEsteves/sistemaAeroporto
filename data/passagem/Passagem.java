package passagem;

import business.exceptions.DadosVaziosException;
import passageiro.Passageiro;
import voo.Voo;

public class Passagem{
    Voo voo;
    Passageiro passageiro;

    public void setPassagem(Voo v, Passageiro p) throws DadosVaziosException{
        if(v == null || p == null){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados NULOS.");
        }else{
            voo = v;
            passageiro = p;
        }
    }

    public String getPassagem(Passagem p) throws DadosVaziosException{
        if(p.equals(null)){
            throw new DadosVaziosException("\nERRO: A passagem está SEM DADOS.");
        }
        return "    PASSAGEM\n" + p.voo.getPlaneInfo() + p.passageiro.getDadosPassageiro();
    }
}