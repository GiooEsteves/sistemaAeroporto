package ui;

import java.util.Scanner;

import business.exceptions.ObjetoNaoCadastradoException;
import business.passagem.Passagem;
import business.passagem.RepositorioPassagem;
import aviao.Aviao;
import aviao.RepositorioAviao;
import passageiro.Passageiro;
import passageiro.RepositorioPassageiro;
import voo.RepositorioVoo;
import voo.Voo;
import funcionario.RepositorioFuncionario;

public class App{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);                 

        RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
        RepositorioAviao repAviao = new RepositorioAviao();
        RepositorioVoo repVoo = new RepositorioVoo();
        RepositorioPassageiro repPassageiro = new RepositorioPassageiro();
        Passagem passagem = new Passagem();
        RepositorioPassagem repPassagem = new RepositorioPassagem();

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
                    double salarioFunc = scanner.nextDouble();
                    
                    if(tipoDeFuncCadastro == 1){
                        System.out.print("Qual o tipo do piloto? ");
                        String tipoPiloto = scanner.next();
                        repFuncionario.inserirFuncionario(tipoDeFuncCadastro, nomeFunc, cpfFunc, salarioFunc, tipoPiloto);
                    }else{
                        repFuncionario.inserirFuncionario(tipoDeFuncCadastro, nomeFunc, cpfFunc, salarioFunc, null);
                    }
                    System.out.println("\nFuncionário cadastrado!");
                    break;
                case 2:
                    System.out.println("\n-- Cadastro de aviões --"); 
                    System.out.print("Nome: ");
                    String nomeAviao = scanner.next();
                    System.out.print("Capacidade: ");
                    int capacAviao = scanner.nextInt();
                    System.out.print("Tipo de avião: ");
                    String tipoAviao = scanner.next();

                    repAviao.inserirAviao(nomeAviao, capacAviao, tipoAviao);
                    System.out.println("\nAvião cadastrado!");
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
                        Aviao a = repAviao.matchAviao(aviaoNome);
                        repVoo.inserirVoo(a, horaVoo, dtaPartida, cidOrigem, cidDestino, valorAssento);         
                        System.out.println("\nVoo criado");
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }  
                     
                    break;
                case 4:
                    System.out.println("\n-- Lista de Funcionários --");
                    try{
                        repFuncionario.listarFuncionario();
                    }catch(ObjetoNaoCadastradoException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\n-- Lista de aviões --");
                    try{
                        repAviao.listarAvioes();
                    }catch(ObjetoNaoCadastradoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("\n-- Lista de voos --");
                    try{
                        repVoo.listarVoos();
                    }catch(ObjetoNaoCadastradoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("\n-- Lista de passageiros --");
                    try{
                        repPassageiro.listarPassageiros();
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
                        Voo v = repVoo.escolherVoo(dtaPassagemCompra, nomeDestinoCompra, numPassageiro);
                        System.out.println("\nVoo encontrado: ");
                        System.out.print(v.getPlaneInfo());
                        System.out.println("\nVoo selecionado!");
                        try{
                            for(int i = 0; i<numPassageiro; i++){
                                System.out.println("\nDados do passageiro ");
                                System.out.print("Digite o nome: ");
                                String nomePassageiro = scanner.next();
                                System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
                                String nascPassageiro = scanner.next();
                                System.out.print("Digite o CPF: ");
                                String cpfPassageiro = scanner.next();
   
                                Passageiro passageiroDoVoo = repPassageiro.inserirPassageiros(numPassageiro, nomePassageiro, nascPassageiro, cpfPassageiro);
                                Passagem passagemComprada = repPassagem.inserirPassagem(v, passageiroDoVoo); 
                                System.out.println("\nPassagem de "+ passageiroDoVoo.getNome() +" comprada com sucesso.");  
                                System.out.println("\n" + passagem.getPassagem(passagemComprada));
                            }
                            v.setABordo(numPassageiro); 
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

                    if(escAtualizarFuncionario == 1){
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.next();
                        repFuncionario.atualizarFuncionario(cpfFuncionarioAtualizar, escAtualizarFuncionario, novoNome, 4728.43);
                    }else if(escAtualizarFuncionario == 2){
                        System.out.print("Digite o novo salário: ");
                        double novoSalario = scanner.nextDouble();
                        repFuncionario.atualizarFuncionario(cpfFuncionarioAtualizar, escAtualizarFuncionario, "qualquer", novoSalario);
                    } 
                    System.out.println("\nFuncionário atualizado com sucesso!");
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

                    if(escAtualizarVoo == 1){
                        System.out.print("Digite o nome do novo avião: ");
                        String novoNome = scanner.next();
                        repVoo.atualizarVoo(escAtualizarVoo, dataVooAtualizar, nomeDestinoVooAtualizar, novoNome, "qualquer", "qualquer", 467.3);
                    }else if(escAtualizarVoo == 2){
                        System.out.print("Digite o novo horário: ");
                        String novoHorario = scanner.next();
                        repVoo.atualizarVoo(escAtualizarVoo, dataVooAtualizar, nomeDestinoVooAtualizar, "qualquer", novoHorario, "qualquer", 7482.42);
                    }else if(escAtualizarVoo == 3){
                        System.out.print("Digite a nova data: ");
                        String novaData = scanner.next();
                        repVoo.atualizarVoo(escAtualizarVoo, dataVooAtualizar, nomeDestinoVooAtualizar, "qualquer", "qualquer", novaData, 7329.2);
                    }else if(escAtualizarVoo == 4){
                        System.out.print("Digite o novo valor da passagem: ");
                        double novoValor = scanner.nextDouble();
                        repVoo.atualizarVoo(escAtualizarVoo, dataVooAtualizar, nomeDestinoVooAtualizar, "qualquer", "qualquer", "qualquer", novoValor);
                    }    
                    System.out.println("\nVoo atualizado com sucesso!");
                    break;
                case 11:
                    System.out.println("Atualizar passageiro");
                    System.out.print("Qual o CPF do passageiro que se deseja atualizar? ");
                    String cpfPassageiroAtualizar = scanner.next();   
                    System.out.print("\nDigite o novo nome: ");
                    String novoNome = scanner.next();
                    System.out.print("\nDigite o novo cpf: ");
                    String novoCPF = scanner.next();
                    System.out.print("\nDigite a nova data de nascimento: ");
                    String novaDtaNasc = scanner.next();
                    repPassageiro.atualizarPassageiro(cpfPassageiroAtualizar, novoNome, novaDtaNasc, novoCPF);
                    System.out.println("\nPassageiro atualizado com sucesso!");
                    break;
                case 12:
                    System.out.println("\n-- Excluir funcionário --");
                    System.out.print("Qual o CPF do funcionário que se deseja excluir? ");
                    String cpfExcluir = scanner.next();
                    repFuncionario.excluirFuncionarios(cpfExcluir);
                    System.out.println("\nFuncionário removido com sucesso!");
                    break;
                case 13: 
                    System.out.println("\n-- Excluir voo --");
                    System.out.print("Digite a data do voo: ");
                    String dataDoVooExcluir = scanner.next();
                    System.out.print("Digite o nome do destino do voo: ");
                    String nomeDestinoExcluir = scanner.next();
                    repVoo.excluirVoo(dataDoVooExcluir, nomeDestinoExcluir);
                    System.out.println("\nVoo removido com sucesso!");
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