package passageiro;

import business.exceptions.DadosVaziosException;

public class Passageiro {
    String nome;
    String dataNascimento;
    String CPF;

    public void setPassageiro(String n, String dtaNasc, String c) throws DadosVaziosException{
        if(n == "" || dtaNasc == "" || c == ""){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados VAZIOS.");
        }else if(n == null || dtaNasc == null || c == null){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados NULOS.");
        }else{
            nome = n;
            dataNascimento = dtaNasc;
            CPF = c;
        }
    }

    public void setPassageiroAtualizado(Passageiro p, String n, String dtaNasc, String c) throws DadosVaziosException{
        if(n == "" || dtaNasc == "" || c == ""){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados VAZIOS.");
        }else if(n == null || dtaNasc == null || c == null){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados NULOS.");
        }else{
            p.nome = n;
            p.dataNascimento = dtaNasc;
            p.CPF = c;
        }
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
        return "Nome: " + nome + "\nCPF: " + CPF + "\nNascimento: " + dataNascimento +"\n";
    }
}