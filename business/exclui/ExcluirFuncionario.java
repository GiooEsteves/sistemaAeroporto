package business.exclui;

import funcionario.RepositorioFuncionario;

public class ExcluirFuncionario{
    public static void excluirFuncionario(RepositorioFuncionario repFuncionario, String cpfExcluir){
        repFuncionario.excluirFuncionarios(cpfExcluir);
    }
}
