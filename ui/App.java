package ui;

// CRIAR UM METODO PARA ADICIONAR NO ARRAYLIST E PUXAR PELO CONSTRUTOR
// ADICIONAR EXCLUIR E ATUALIZAR
// COLOCAR TRATAMENTO DE ERRO NO CÓDIGO (USO DE EXCESSÃO)

import java.util.Scanner;

import business.Passagem;
import business.exceptions.ObjetoNaoCadastradoException;
import src.Aviao;
import src.Passageiro;
import src.Voo;
import src.funcionarios.Funcionario;

public class App{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);                 

        Funcionario funcionario = new Funcionario();
        Aviao aviao = new Aviao();
        Voo voo = new Voo();
        Passagem passagem = new Passagem();
        Passageiro passageiro = new Passageiro();      

        boolean loop = true;
        while(loop){
            System.out.println(" \n-- Aeroporto --");
            System.out.println("1. Cadastro de funcionário");
            System.out.println("2. Cadastro de aviões");
            System.out.println("3. Cadastro de voo"); 
            System.out.println("4. Lista de funcionários");         
            System.out.println("5. Lista de aviões");
            System.out.println("6. Lista de voos");
            System.out.println("7. Lista de passageiros");
            System.out.println("8. Compra de passagem");
            System.out.println("9. Atualizar");
            System.out.println("10.");
            System.out.println("11. Excluir"); 
            System.out.println("12. Sair"); 
            System.out.print("\nDigite a sua opção: ");
            
            int ent = scanner.nextInt();
            scanner.nextLine();

            switch(ent){
                case 1:
                    System.out.println("\nQual o tipo de funcionário? ");
                    System.out.println("1. Piloto");
                    System.out.println("2. Agente de Bordo"); 
                    System.out.println("3. Vendedor");  
                    System.out.print("\nDigite a sua opção: ");
                    int func = scanner.nextInt();

                    System.out.println("\n-- Cadastro de funcionário --");
                    System.out.print("Digite o nome do funcionário: ");
                    String n = scanner.next();
                    System.out.print("Digite o CPF do funcionário: ");
                    String c = scanner.next();
                    System.out.print("Digite o salário do funcionário: ");
                    Float s = scanner.nextFloat();
                    
                    if(func == 1){
                        System.out.print("Qual o tipo do piloto? ");
                        String tipo = scanner.next();
                        funcionario.inserirFuncionario(func, n, c, s, tipo);
                    }else{
                        funcionario.inserirFuncionario(func, n, c, s, null);
                    }
                    break;
                case 2:
                    System.out.println("\n-- Cadastro de aviões --"); 
                    System.out.print("Nome: ");
                    String no = scanner.next();
                    System.out.print("Capacidade: ");
                    int cap = scanner.nextInt();
                    System.out.print("Tipo de avião: ");
                    String ti = scanner.next();

                    aviao.inserirAviao(no, cap, ti);
                    break;
                case 3:
                    System.out.println("\n-- Cadastro de voo --");
                    System.out.print("Horário: ");
                    String h = scanner.next();
                    System.out.print("Data da partida (dd/mm): ");
                    String dtaPartida = scanner.next();
                    System.out.print("Cidade da origem: ");
                    String cidOrigem = scanner.next();
                    System.out.print("Cidade de destino: ");
                    String cidDestino = scanner.next();
                    System.out.print("Valor do assento: ");
                    double valorU = scanner.nextDouble();

                    System.out.println("\nEscolha um avião a ser cadastrado no voo.. ");
                    System.out.print("Digite o nome do avião escolhido: ");
                    String aviaoNome = scanner.next();
                    
                    try{
                        Aviao a = aviao.matchAviao(aviaoNome);
                        voo.inserirVoo(a, h, dtaPartida, cidOrigem, cidDestino, valorU);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }   
                    break;
                case 4:
                    System.out.println("\n-- Lista de Funcionários --");
                    try{
                        funcionario.listarFuncionario();
                    }catch(ObjetoNaoCadastradoException e){         // DANDO ERRO
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\n-- Lista de aviões --");
                    try{
                        aviao.listarAvioes();
                    }catch(ObjetoNaoCadastradoException e){        // DANDO ERRO
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("\n-- Lista de voos --");
                    try{
                        voo.listarVoos();
                    }catch(ObjetoNaoCadastradoException e){       // DANDO ERRO
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("\n-- Lista de passageiros --");
                    try{
                        passageiro.listarPassageiros();
                    }catch(ObjetoNaoCadastradoException e){       // DANDO ERRO
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("\n-- Compra de passagem --");
                    System.out.println("Escolha o voo ");
                    System.out.print("Digite a data que deseja viajar: ");
                    String dta = scanner.next();
                    System.out.print("Digite o nome da cidade de destino: ");
                    String nDestino = scanner.next();

                    System.out.print("\nQuantos passageiros? ");
                    int numPassageiro = scanner.nextInt();
                    
                    try{
                        Voo v = voo.matchVoo(dta, nDestino, numPassageiro);
                        passagem.getPagamento(numPassageiro, v.valorUnitario);
                        passageiro.inserirPassageiros(v, numPassageiro);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    } 
                    break;
                case 12:
                    System.out.println("\nSaindo...");
                    loop = false;
                    scanner.close();    
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }   
}