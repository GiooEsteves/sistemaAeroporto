package business.atualiza;

import funcionario.RepositorioFuncionario;

public class AtualizarFuncionario{
    public static void atualizarFuncionario(RepositorioFuncionario repFuncionario, int escAtualizarFuncionario, String cpfFuncionarioAtualizar, String novoNome, double novoSalario){
        repFuncionario.atualizarFuncionario(cpfFuncionarioAtualizar, escAtualizarFuncionario, novoNome, novoSalario);
    }
}
