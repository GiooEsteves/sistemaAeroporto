package business.lista;

import business.exceptions.ObjetoNaoCadastradoException;
import funcionario.RepositorioFuncionario;

public class ListarFuncionario{
    public static void listarFuncionario(RepositorioFuncionario repFuncionario){
        try{
            repFuncionario.listarFuncionario();
        }catch(ObjetoNaoCadastradoException e){
            System.err.println(e.getMessage());
        }
    }
}
