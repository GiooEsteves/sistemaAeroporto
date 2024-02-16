package src;

import java.util.ArrayList;
import java.util.Scanner;

import business.Passagem;

public class Passageiro {
    String nome;
    String dataNascimento;
    String CPF;

    ArrayList <Passageiro> passageiros = new ArrayList<Passageiro>();
    Scanner scanner = new Scanner(System.in);                 

    public void setPassageiro(String n, String dtaNasc, String c){
        nome = n;
        dataNascimento = dtaNasc;
        CPF = c;
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

    public void inserirPassageiros(Voo v, int numPassageiro){
        for(int i = 0; i<numPassageiro; i++){
            System.out.println("Dados do passageiro ");
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
            passagem.setPassagem(v, passageiro);
            passagem.inserirPassagem(passagem);            
        }
    }

    public void listarPassageiros(){
        for(Passageiro p : passageiros){
            System.out.println(p.getDadosPassageiro());
        }
    }
}