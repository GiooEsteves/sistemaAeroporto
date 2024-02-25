package src.funcionarios;

import java.util.ArrayList;
import java.util.Scanner;

import business.exceptions.DadosVaziosException;
import business.exceptions.FuncionarioInvalidoException;
import business.exceptions.ObjetoNaoCadastradoException;

public class Funcionario{
    String nome;
    String CPF;
    Float salario;

    Scanner scanner = new Scanner(System.in); 
    ArrayList <Funcionario> funcionarios = new ArrayList<Funcionario>();  

    public void setFuncionario(String n, String c, Float s) throws DadosVaziosException{
        if(n == "" || c == "" || s == 0){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados VAZIOS.");
        }else if(n == null || c == null || s == null){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados NULOS.");
        }else{                
            nome = n;
            CPF = c;
            salario = s;
        }
    }

    public String getCPF(){
        return CPF;
    }

    public String getDadosFuncionarios(){
        return "Nome: " + nome + "\nCPF: " + CPF + "\nSalário: " + salario + "\n";
    }

    public void setNome(Funcionario objFunc, String nome){
        objFunc.nome = nome;
    }

    public void setSalario(Funcionario objFunc, float salario){
        objFunc.salario = salario;
    }

    public void inserirFuncionario(int func, String n, String c, Float s, String t){
        try{
            if(func == 1){
                Piloto piloto = new Piloto();
                piloto.setFuncionario(n, c, s);
                piloto.setTipoPiloto(t);
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
            System.out.println("\nFuncionário cadastrado!");
        }catch(Exception e){
            System.out.println(e.getMessage());
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

    public void atualizarFuncionario(String cpfPassado, int esc){
        try{
            Funcionario funcionarioParaAtualizar = matchFuncionario(cpfPassado);
            if(esc == 1){
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.next(); 
                setNome(funcionarioParaAtualizar, novoNome);
            }else if(esc == 2){
                System.out.print("Digite o novo salário: ");
                Float novoSalario = scanner.nextFloat();
                setSalario(funcionarioParaAtualizar, novoSalario);
            }
            System.out.println("\nFuncionário atualizado com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirFuncionarios(String cpfPassado){
        try{
            Funcionario funcionarioParaExcluir = matchFuncionario(cpfPassado);
            funcionarios.remove(funcionarioParaExcluir);
            System.out.println("\nFuncionário removido com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
