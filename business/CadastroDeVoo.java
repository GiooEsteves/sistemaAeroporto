package business;

import aviao.Aviao;
import aviao.RepositorioAviao;
import voo.RepositorioVoo;

public class CadastroDeVoo{
    
    RepositorioAviao repAviao = new RepositorioAviao();
    RepositorioVoo repVoo = new RepositorioVoo();

    public void criarVoo(String aviaoNome, String horaVoo, String dtaPartida, String cidOrigem, String cidDestino, double valorAssento){
        try{                                        
            Aviao a = repAviao.matchAviao(aviaoNome);
            repVoo.inserirVoo(a, horaVoo, dtaPartida, cidOrigem, cidDestino, valorAssento);         
            System.out.println("\nVoo criado");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
