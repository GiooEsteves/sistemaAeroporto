package funcionario;

import java.util.ArrayList;
import business.busca.Busca;
import business.exceptions.ObjetoNaoCadastradoException;

public class RepositorioFuncionario {
    ArrayList <Funcionario> funcionarios = new ArrayList<Funcionario>();  
    Funcionario funcionario = new Funcionario();

    public void inserirFuncionarioPiloto(String n, String c, double s){
        try{
            Piloto piloto = new Piloto();
            piloto.setFuncionario(n, c, s);
            funcionarios.add(piloto);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void inserirFuncionarioAg(String n, String c, double s){
        try{
            AgenteDeBordo ag = new AgenteDeBordo();
            ag.setFuncionario(n, c, s);
            funcionarios.add(ag);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void inserirFuncionarioVendedor(String n, String c, double s){
        try{
            Vendedor vendedor = new Vendedor();
            vendedor.setFuncionario(n, c, s);
            funcionarios.add(vendedor);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void listarFuncionario() throws ObjetoNaoCadastradoException{
        if(funcionarios.isEmpty()){
            throw new ObjetoNaoCadastradoException();
        }
        for(Funcionario f : funcionarios){
            System.out.println(f.getDadosFuncionarios());    
        }
    }

    public void atualizarNomeFuncionario(Funcionario funcionarioParaAtualizar, String novoNome, double novoSalario){
        funcionario.setNome(funcionarioParaAtualizar, novoNome); 
    }

    public void atualizarSalarioFuncionario(Funcionario funcionarioParaAtualizar, String novoNome, double novoSalario){
        funcionario.setSalario(funcionarioParaAtualizar, novoSalario);    
        
    }

    public void excluirFuncionarios(String cpfPassado){
        try{
            Funcionario funcionarioParaExcluir = Busca.matchFuncionario(funcionarios, cpfPassado);
            funcionarios.remove(funcionarioParaExcluir);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Funcionario> getArrayListFuncionario(){
        return funcionarios;
    }
}
