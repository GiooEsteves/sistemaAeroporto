package business.cadastro;

import funcionario.RepositorioFuncionario;

public class CadastroDeFuncionario{
    public static void cadastroDeFuncionario(RepositorioFuncionario repFuncionario, int tipoDeFuncCadastro, String nomeFunc, String cpfFunc, double salarioFunc){
        if(tipoDeFuncCadastro == 1){
            repFuncionario.inserirFuncionarioPiloto(nomeFunc, cpfFunc, salarioFunc);
        }else if(tipoDeFuncCadastro == 2){
            repFuncionario.inserirFuncionarioAg(nomeFunc, cpfFunc, salarioFunc);
        }else if(tipoDeFuncCadastro == 3){
            repFuncionario.inserirFuncionarioVendedor(nomeFunc, cpfFunc, salarioFunc);
        }
    }
}
