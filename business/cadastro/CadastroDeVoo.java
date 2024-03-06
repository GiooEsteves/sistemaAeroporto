package business.cadastro;

import java.util.ArrayList;
import aviao.Aviao;
import aviao.RepositorioAviao;
import business.busca.Busca;
import voo.RepositorioVoo;

public class CadastroDeVoo{
    public static void cadastroDeVoo(RepositorioAviao repAviao, RepositorioVoo repVoo, String aviaoNome, String nomeVoo, String horaVoo, String dtaPartida, String cidOrigem, String cidDestino, double valorAssento){
        try{     
            ArrayList <Aviao> avioes = new ArrayList<Aviao>();
            avioes = repAviao.getArrayListAvioes();                                   
            Aviao a = Busca.matchAviao(avioes, aviaoNome);
            repVoo.inserirVoo(a, nomeVoo, horaVoo, dtaPartida, cidOrigem, cidDestino, valorAssento);         
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
