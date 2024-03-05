package business.cadastro;

import aviao.RepositorioAviao;

public class CadastroDeAviao{
    public static void cadastroDeAviao(RepositorioAviao repAviao, String nomeAviao, int capacAviao, String tipoAviao){
        repAviao.inserirAviao(nomeAviao, capacAviao, tipoAviao);
    }
}
