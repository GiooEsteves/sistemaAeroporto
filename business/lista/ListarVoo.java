package business.lista;

import business.exceptions.ObjetoNaoCadastradoException;
import voo.RepositorioVoo;

public class ListarVoo{
    public static void listarVoo(RepositorioVoo repVoo){
        try{
            repVoo.listarVoos();
        }catch(ObjetoNaoCadastradoException e){
            System.err.println(e.getMessage());
        }
    }
}
