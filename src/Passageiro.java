package src;

public class Passageiro {
    String nome;
    String dataNascimento;
    String CPF;

    public Passageiro(String nome, String dataNascimento, String CPF){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.CPF = CPF;
    }

    public String getNome(){
        return nome;
    }

    public String getCPF(){
        return CPF;
    }

    public String getDtaNascimento(){
        return dataNascimento;
    } 
    public String getDadosPassageiro(){
        return "\nNome: " + nome + "\nCPF: " + CPF + "\nNascimento: " + dataNascimento;
    }
}