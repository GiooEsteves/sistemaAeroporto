package business.compra;

import passageiro.Passageiro;
import passageiro.RepositorioPassageiro;
import passagem.Passagem;
import passagem.RepositorioPassagem;
import voo.RepositorioVoo;
import voo.Voo;

public class CompraPassagem{
    public static Voo escolherVoo(RepositorioVoo repVoo, String dtaPassagemCompra, String nomeDestinoCompra){
        try{
            Voo v = repVoo.escolherVoo(dtaPassagemCompra, nomeDestinoCompra, 1);
            return v;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static Passagem compraDePassagem(RepositorioPassageiro repPassageiro, RepositorioPassagem repPassagem, String nomePassageiro, String nascPassageiro, String cpfPassageiro, Voo v){
        Passageiro passageiroDoVoo = repPassageiro.inserirPassageiros(nomePassageiro, nascPassageiro, cpfPassageiro);
        Passagem passagemComprada = repPassagem.inserirPassagem(v, passageiroDoVoo);
        v.setABordo();
        return passagemComprada;
    }
}
