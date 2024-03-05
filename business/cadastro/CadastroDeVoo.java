package business.cadastro;

import aviao.Aviao;
import aviao.RepositorioAviao;
import voo.RepositorioVoo;

public class CadastroDeVoo{
    public static void cadastroDeVoo(RepositorioAviao repAviao, RepositorioVoo repVoo, String aviaoNome, String nomeVoo, String horaVoo, String dtaPartida, String cidOrigem, String cidDestino, double valorAssento){
        try{                                        
            Aviao a = repAviao.matchAviao(aviaoNome);
            repVoo.inserirVoo(a, nomeVoo, horaVoo, dtaPartida, cidOrigem, cidDestino, valorAssento);         
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
