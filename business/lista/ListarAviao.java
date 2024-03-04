package business.lista;

import aviao.RepositorioAviao;
import business.exceptions.ObjetoNaoCadastradoException;

public class ListarAviao{
    public static void listarAviao(RepositorioAviao repAviao){
        try{
            repAviao.listarAvioes();
        }catch(ObjetoNaoCadastradoException e){
            System.err.println(e.getMessage());
        }
    }
}
