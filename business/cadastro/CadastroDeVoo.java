package business.cadastro;

import aviao.Aviao;
import aviao.RepositorioAviao;
import voo.RepositorioVoo;

public class CadastroDeVoo{

    //RepositorioVoo repVoo = new RepositorioVoo();

    public static void criarVoo(RepositorioAviao repAviao, RepositorioVoo repVoo, String aviaoNome, String horaVoo, String dtaPartida, String cidOrigem, String cidDestino, double valorAssento){
        try{                                        
            Aviao a = repAviao.matchAviao(aviaoNome);
            System.out.println(a.getNome());
            repVoo.inserirVoo(a, horaVoo, dtaPartida, cidOrigem, cidDestino, valorAssento);         
            //return repVoo;
        }catch(Exception e){
            System.out.println(e.getMessage());
            //return null;
        }
    }
}
