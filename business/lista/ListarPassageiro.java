package business.lista;

import business.exceptions.ObjetoNaoCadastradoException;
import passageiro.RepositorioPassageiro;

public class ListarPassageiro{
    public static void listarPassageiro(RepositorioPassageiro repPassageiro){
        try{
            repPassageiro.listarPassageiros();
        }catch(ObjetoNaoCadastradoException e){
            System.err.println(e.getMessage());
        }
    }
}
