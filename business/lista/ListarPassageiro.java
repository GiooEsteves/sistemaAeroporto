package business.lista;

import business.exceptions.ObjetoNaoCadastradoException;
import passagem.RepositorioPassagem;

public class ListarPassageiro{
    public static void listarPassageiro(RepositorioPassagem repPassagem){
        try{
            repPassagem.getPassageirosDoVoo();
        }catch(ObjetoNaoCadastradoException e){
            System.err.println(e.getMessage());
        }
    }
}
