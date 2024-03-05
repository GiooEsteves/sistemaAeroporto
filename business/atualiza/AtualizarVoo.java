package business.atualiza;

import aviao.RepositorioAviao;
import voo.RepositorioVoo;

public class AtualizarVoo{
    public static void atualizarVoo(RepositorioVoo repVoo, RepositorioAviao repAviao, int escAtualizarVoo, String dataVooAtualizar, String nomeDestinoVooAtualizar, String novoNome, String novoHorario, String novaData, double novoValor){
        repVoo.atualizarVoo(repAviao, escAtualizarVoo, dataVooAtualizar, nomeDestinoVooAtualizar, novoNome, novoHorario, novaData, novoValor);    
    }
}
