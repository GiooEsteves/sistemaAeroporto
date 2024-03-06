package business.atualiza;

import java.util.ArrayList;
import aviao.Aviao;
import aviao.RepositorioAviao;
import business.busca.Busca;
import voo.Voo;
import voo.RepositorioVoo;

public class AtualizarVoo{
    public static void atualizarVoo(RepositorioVoo repVoo, RepositorioAviao repAviao, int escAtualizarVoo, String nomeVooAtualizar, String novoNome, String novoHorario, String novaData, double novoValor){
        ArrayList <Voo> voos = new ArrayList<Voo>();
        voos = repVoo.getArrayListVoo();
        Voo vooParaAtualizar;
        try{
            vooParaAtualizar = Busca.matchVoo(voos, nomeVooAtualizar);
            if(escAtualizarVoo == 1){
                ArrayList <Aviao> avioes = new ArrayList<Aviao>();
                avioes = repAviao.getArrayListAvioes();
                repVoo.atualizarAviaoVoo(avioes, vooParaAtualizar, novoNome, novoHorario, novaData, novoValor);
            }else if(escAtualizarVoo == 2){
                repVoo.atualizarHoraVoo(vooParaAtualizar, novoNome, novoHorario, novaData, novoValor);
            }else if(escAtualizarVoo == 3){
                repVoo.atualizarDataVoo(vooParaAtualizar, novoNome, novoHorario, novaData, novoValor);
            }else if(escAtualizarVoo == 4){
                repVoo.atualizarValorVoo(vooParaAtualizar, novoNome, novoHorario, novaData, novoValor);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
