package business.atualiza;

import java.util.ArrayList;
import business.busca.Busca;
import funcionario.Funcionario;
import funcionario.RepositorioFuncionario;

public class AtualizarFuncionario{
    public static void atualizarFuncionario(RepositorioFuncionario repFuncionario, int escAtualizarFuncionario, String cpfFuncionarioAtualizar, String novoNome, double novoSalario){
        ArrayList <Funcionario> funcionarios = new ArrayList<Funcionario>();  
        funcionarios = repFuncionario.getArrayListFuncionario();
        try{
            Funcionario funcionarioParaAtualizar = Busca.matchFuncionario(funcionarios, cpfFuncionarioAtualizar);
            if(escAtualizarFuncionario == 1){
                repFuncionario.atualizarNomeFuncionario(funcionarioParaAtualizar, novoNome, novoSalario);
            }else if(escAtualizarFuncionario == 2){
                repFuncionario.atualizarSalarioFuncionario(funcionarioParaAtualizar, novoNome, novoSalario);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
