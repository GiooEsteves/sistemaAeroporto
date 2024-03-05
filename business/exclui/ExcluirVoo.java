package business.exclui;

import voo.RepositorioVoo;

public class ExcluirVoo{
    public static void excluirVoo(RepositorioVoo repVoo, String dataDoVooExcluir, String nomeDestinoExcluir){
        repVoo.excluirVoo(dataDoVooExcluir, nomeDestinoExcluir);
    }
}
