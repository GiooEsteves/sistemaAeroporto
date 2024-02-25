package ui;

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
            System.out.println("9. Atualizar funcionario");
            System.out.println("10. Atualizar voo");
            System.out.println("11. Atualizar passageiro");
            System.out.println("12. Excluir funcionairo"); 
            System.out.println("13. Excluir voo");
            System.out.println("14. Sair"); 
            System.out.print("\nDigite a sua opção: ");
            
            int entradaMenuPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch(entradaMenuPrincipal){
                case 1:
                    System.out.println("\nQual o tipo de funcionário? ");
                    System.out.println("1. Piloto");
                    System.out.println("2. Agente de Bordo"); 
                    System.out.println("3. Vendedor");  
                    System.out.print("\nDigite a sua opção: ");
                    int tipoDeFuncCadastro = scanner.nextInt();

                    System.out.println("\n-- Cadastro de funcionário --");
                    System.out.print("Digite o nome do funcionário: ");
                    String nomeFunc = scanner.next();
                    System.out.print("Digite o CPF do funcionário: ");
                    String cpfFunc = scanner.next();
                    System.out.print("Digite o salário do funcionário: ");
                    Float salarioFunc = scanner.nextFloat();
                    
                    if(tipoDeFuncCadastro == 1){
                        System.out.print("Qual o tipo do piloto? ");
                        String tipoPiloto = scanner.next();
                        funcionario.inserirFuncionario(tipoDeFuncCadastro, nomeFunc, cpfFunc, salarioFunc, tipoPiloto);
                    }else{
                        funcionario.inserirFuncionario(tipoDeFuncCadastro, nomeFunc, cpfFunc, salarioFunc, null);
                    }
                    break;
                case 2:
                    System.out.println("\n-- Cadastro de aviões --"); 
                    System.out.print("Nome: ");
                    String nomeAviao = scanner.next();
                    System.out.print("Capacidade: ");
                    int capacAviao = scanner.nextInt();
                    System.out.print("Tipo de avião: ");
                    String tipoAviao = scanner.next();

                    aviao.inserirAviao(nomeAviao, capacAviao, tipoAviao);
                    break;
                case 3:
                    System.out.println("\n-- Cadastro de voo --");
                    System.out.print("Horário: ");
                    String horaVoo = scanner.next();
                    System.out.print("Data da partida (dd/mm): ");
                    String dtaPartida = scanner.next();
                    System.out.print("Cidade da origem: ");
                    String cidOrigem = scanner.next();
                    System.out.print("Cidade de destino: ");
                    String cidDestino = scanner.next();
                    System.out.print("Valor do assento: ");
                    double valorAssento = scanner.nextDouble();

                    System.out.println("\nEscolha um avião a ser cadastrado no voo.. ");
                    System.out.print("Digite o nome do avião escolhido: ");
                    String aviaoNome = scanner.next();
                    
                    try{                                        
                        Aviao a = aviao.matchAviao(aviaoNome);
                        voo.inserirVoo(a, horaVoo, dtaPartida, cidOrigem, cidDestino, valorAssento);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }   
                    break;
                case 4:
                    System.out.println("\n-- Lista de Funcionários --");
                    try{
                        funcionario.listarFuncionario();
                    }catch(ObjetoNaoCadastradoException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\n-- Lista de aviões --");
                    try{
                        aviao.listarAvioes();
                    }catch(ObjetoNaoCadastradoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("\n-- Lista de voos --");
                    try{
                        voo.listarVoos();
                    }catch(ObjetoNaoCadastradoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("\n-- Lista de passageiros --");
                    try{
                        passageiro.listarPassageiros();
                    }catch(ObjetoNaoCadastradoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("\n-- Compra de passagem --");
                    System.out.println("Escolha o voo ");
                    System.out.print("Digite a data que deseja viajar: ");
                    String dtaPassagemCompra = scanner.next();
                    System.out.print("Digite o nome da cidade de destino: ");
                    String nomeDestinoCompra = scanner.next();

                    System.out.print("\nQuantos passageiros? ");
                    int numPassageiro = scanner.nextInt();
                    
                    try{                                          
                        Voo v = voo.escolherVoo(dtaPassagemCompra, nomeDestinoCompra, numPassageiro);
                        try{
                            passagem.getPagamento(numPassageiro, v.valorUnitario);
                            passageiro.inserirPassageiros(v, numPassageiro);
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    } 
                    break;
                case 9:
                    System.out.println("\n--  Atualizar funcionário --");
                    System.out.print("Qual o CPF do funcionário que se deseja atualizar? ");
                    String cpfFuncionarioAtualizar = scanner.next();
                    System.out.println("1. Nome\n2. Salário");
                    System.out.print("\nO que deseja atualizar? ");
                    int escAtualizarFuncionario = scanner.nextInt();      
                    funcionario.atualizarFuncionario(cpfFuncionarioAtualizar, escAtualizarFuncionario);
                    break;
                case 10:
                    System.out.println("\n--  Atualizar voo --");
                    System.out.print("Qual a data do voo que deseja atualizar? ");
                    String dataVooAtualizar = scanner.next();
                    System.out.print("Qual o nome do destino do voo que deseja atualizar? ");
                    String nomeDestinoVooAtualizar = scanner.next();
                    System.out.println("1. Avião\n2. Horário\n3. Data\n4. Valor da passagem");
                    System.out.print("\nO que deseja atualizar? ");
                    int escAtualizarVoo = scanner.nextInt();
                    voo.atualizarVoo(escAtualizarVoo, dataVooAtualizar, nomeDestinoVooAtualizar);
                    break;
                case 11:
                    System.out.println("Atualizar passageiro");
                    System.out.print("Qual o CPF do passageiro que se deseja atualizar? ");
                    String cpfPassageiroAtualizar = scanner.next();   
                    passageiro.atualizarPassageiro(cpfPassageiroAtualizar);
                    break;
                case 12:
                    System.out.println("\n-- Excluir funcionário --");
                    System.out.print("Qual o CPF do funcionário que se deseja excluir? ");
                    String cpfExcluir = scanner.next();
                    funcionario.excluirFuncionarios(cpfExcluir);
                    break;
                case 13: 
                    System.out.println("\n-- Excluir voo --");
                    System.out.print("Digite a data do voo: ");
                    String dataDoVooExcluir = scanner.next();
                    System.out.print("Digite o nome do destino do voo: ");
                    String nomeDestinoExcluir = scanner.next();
                    voo.excluirVoo(dataDoVooExcluir, nomeDestinoExcluir);
                    break;
                case 14:
                    System.out.println("\nSaindo...");
                    loop = false;
                    scanner.close();    
                    break;
                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
        }
    }   
}