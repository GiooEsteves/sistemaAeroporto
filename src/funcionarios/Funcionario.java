package src.funcionarios;

import java.util.ArrayList;

public class Funcionario {
    String nome;
    String CPF;
    Float salario;

    ArrayList <Funcionario> funcionarios = new ArrayList<Funcionario>();  

    public void setFuncionario(String n, String c, Float s){
        nome = n;
        CPF = c;
        salario = s;
    }

    public String getDadosFuncionarios(){
        return "Nome: " + nome + "\nCPF: " + CPF + "\nSalário: " + salario + "\n\n";
    }
 
    public void inserirFuncionario(int func, String n, String c, Float s, String t){
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
    }

    public void listarFuncionario(){
        for(Funcionario f : funcionarios){
            System.out.println(f.getDadosFuncionarios());
        }
    }

    public void excluirFuncionarios(){
        
    }
}
