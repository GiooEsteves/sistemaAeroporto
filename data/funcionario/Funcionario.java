package funcionario;

import business.exceptions.DadosVaziosException;

public class Funcionario{
    String nome;
    String CPF;
    double salario;

    public void setFuncionario(String n, String c, double s) throws DadosVaziosException{
        if(n == "" || c == "" || s == 0){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados VAZIOS.");
        }else if(n == null || c == null || s == 0){
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

    public void setSalario(Funcionario objFunc, double novoSalario){
        objFunc.salario = novoSalario;
    }
}
