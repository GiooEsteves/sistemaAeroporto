package business.cadastro;

import funcionario.RepositorioFuncionario;

public class CadastroDeFuncionario{
    public static void cadastroDeFuncionario(RepositorioFuncionario repFuncionario, int tipoDeFuncCadastro, String nomeFunc, String cpfFunc, double salarioFunc){
        repFuncionario.inserirFuncionario(tipoDeFuncCadastro, nomeFunc, cpfFunc, salarioFunc);
    }
}
