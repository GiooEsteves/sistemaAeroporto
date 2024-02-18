package src;

import java.util.ArrayList;
import java.util.Scanner;

import business.Passagem;
import business.exceptions.DadosVaziosException;
import business.exceptions.ObjetoNaoCadastradoException;

public class Passageiro {
    String nome;
    String dataNascimento;
    String CPF;

    ArrayList <Passageiro> passageiros = new ArrayList<Passageiro>();
    Scanner scanner = new Scanner(System.in);                 

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

    public void inserirPassageiros(Voo v, int numPassageiro) throws DadosVaziosException{
        if(numPassageiro <= 0){
            throw new DadosVaziosException("\nERRO: Número de passageiros inválido.");
        }

        try{
            for(int i = 0; i<numPassageiro; i++){
                System.out.println("\nDados do passageiro ");
                System.out.print("Digite o nome: ");
                String nomePassageiro = scanner.next();
                System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
                String nascPassageiro = scanner.next();
                System.out.print("Digite o CPF: ");
                String cpfPassageiro = scanner.next();
    
                Passageiro passageiro = new Passageiro();
                passageiro.setPassageiro(nomePassageiro, nascPassageiro, cpfPassageiro);
                passageiros.add(passageiro);
                
                Passagem passagem = new Passagem();
                Passagem p = passagem.inserirPassagem(v, passageiro); 
                System.out.println("\n" + passagem.getPassagem(p));

                v.setABordo(numPassageiro);        
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarPassageiros() throws ObjetoNaoCadastradoException{
        if(passageiros.isEmpty()){
            throw new ObjetoNaoCadastradoException();
        }
        for(Passageiro p : passageiros){
            System.out.println(p.getDadosPassageiro());    
        }
    }
}