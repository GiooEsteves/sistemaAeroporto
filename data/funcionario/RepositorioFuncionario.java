package funcionario;

import java.util.ArrayList;

import business.exceptions.FuncionarioInvalidoException;
import business.exceptions.ObjetoNaoCadastradoException;

public class RepositorioFuncionario {
    ArrayList <Funcionario> funcionarios = new ArrayList<Funcionario>();  
    Funcionario funcionario = new Funcionario();

    public void inserirFuncionario(int func, String n, String c, double s){
        try{
            if(func == 1){
                Piloto piloto = new Piloto();
                piloto.setFuncionario(n, c, s);
                funcionarios.add(piloto);
            }else if(func == 2){
                AgenteDeBordo ag = new AgenteDeBordo();
                ag.setFuncionario(n, c, s);
                funcionarios.add(ag);
            }else if(func == 3){
                Vendedor vendedor = new Vendedor();
                vendedor.setFuncionario(n, c, s);
                funcionarios.add(vendedor);
            }
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

    public Funcionario matchFuncionario(String funcCPF) throws FuncionarioInvalidoException{
        for(Funcionario f : funcionarios){
            if(f.getCPF().equals(funcCPF)){
                return f;
            }
        }
        throw new FuncionarioInvalidoException();     
    }

    public void atualizarFuncionario(String cpfPassado, int esc, String novoNome, double novoSalario){
        try{
            Funcionario funcionarioParaAtualizar = matchFuncionario(cpfPassado);
            if(esc == 1){
                funcionario.setNome(funcionarioParaAtualizar, novoNome);
            }else if(esc == 2){     
                funcionario.setSalario(funcionarioParaAtualizar, novoSalario);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void excluirFuncionarios(String cpfPassado){
        try{
            Funcionario funcionarioParaExcluir = matchFuncionario(cpfPassado);
            funcionarios.remove(funcionarioParaExcluir);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
