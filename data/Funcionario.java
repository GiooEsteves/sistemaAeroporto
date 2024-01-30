package data;

public class Funcionario {
    String nome;
    String CPF;
    Double salario;

    public Funcionario(String nome, String CPF, Double salario){
        this.nome = nome;
        this.CPF = CPF;
        this.salario = salario;
    }

    public String getNome(){
        return nome;
    }

    public String getCPF(){
        return CPF;
    }

    public String getDadosFuncionarios(){
        return "Nome: " + nome + "\nCPF: " + CPF + "\nSalário: " + salario;
    }
}
