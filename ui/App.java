package ui;

import java.util.Scanner;
import business.atualiza.*;
import business.cadastro.*;
import business.compra.CompraPassagem;
import business.exclui.*;
import business.lista.*;
import aviao.RepositorioAviao;
import funcionario.RepositorioFuncionario;
import passageiro.*;
import passagem.*;
import voo.*;

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
                    CadastroDeFuncionario.cadastroDeFuncionario(repFuncionario, tipoDeFuncCadastro, nomeFunc, cpfFunc, salarioFunc);
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
                    CadastroDeAviao.cadastroDeAviao(repAviao, nomeAviao, capacAviao, tipoAviao);
                    System.out.println("\nAvião cadastrado!");
                    break;
                case 3:
                    System.out.println("\n-- Cadastro de voo --");
                    System.out.print("Nome do voo: ");
                    String nomeVoo = scanner.next();
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
                    
                    CadastroDeVoo.cadastroDeVoo(repAviao, repVoo, aviaoNome, nomeVoo, horaVoo, dtaPartida, cidOrigem, cidDestino, valorAssento);
                    System.out.println("\nVoo criado!"); 
                    break;
                case 4:
                    System.out.println("\n-- Lista de Funcionários --");
                    ListarFuncionario.listarFuncionario(repFuncionario);
                    break;
                case 5:
                    System.out.println("\n-- Lista de aviões --");
                    ListarAviao.listarAviao(repAviao);
                    break;
                case 6:
                    System.out.println("\n-- Lista de voos --");
                    ListarVoo.listarVoo(repVoo);
                    break;
                case 7:
                    System.out.println("\n-- Lista de passageiros --");
                    ListarPassageiro.listarPassageiro(repPassagem);
                    break;
                case 8:
                    System.out.println("\n-- Compra de passagem --");
                    System.out.println("Escolha o voo ");
                    System.out.print("Digite a data que deseja viajar: ");
                    String dtaPassagemCompra = scanner.next();
                    System.out.print("Digite o nome da cidade de destino: ");
                    String nomeDestinoCompra = scanner.next();
                                           
                    Voo v = CompraPassagem.escolherVoo(repVoo, dtaPassagemCompra, nomeDestinoCompra);
                    System.out.print("\n" + v.getPlaneInfo());
                    System.out.println("\nVoo selecionado!");
                
                    System.out.println("\nDados do passageiro ");
                    System.out.print("Digite o nome: ");
                    String nomePassageiro = scanner.next();
                    System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
                    String nascPassageiro = scanner.next();
                    System.out.print("Digite o CPF: ");
                    String cpfPassageiro = scanner.next();

                    Passagem passagemComprada = CompraPassagem.compraDePassagem(repPassageiro, repPassagem, nomePassageiro, nascPassageiro, cpfPassageiro, v); 
                    System.out.println("\nPassagem comprada com sucesso!");  
                    System.out.println("\n" + passagem.getPassagem(passagemComprada));
                    break;
                case 9:
                    System.out.println("\n--  Atualizar funcionário --");
                    String novoNomeFuncionario = "";
                    double novoSalarioFuncionario = 0.0;
                    System.out.print("Qual o CPF do funcionário que se deseja atualizar? ");
                    String cpfFuncionarioAtualizar = scanner.next();
                    System.out.println("1. Nome\n2. Salário");
                    System.out.print("\nO que deseja atualizar? ");
                    int escAtualizarFuncionario = scanner.nextInt(); 

                    if(escAtualizarFuncionario == 1){
                        System.out.print("Digite o novo nome: ");
                        novoNomeFuncionario = scanner.next();
                    }else if(escAtualizarFuncionario == 2){
                        System.out.print("Digite o novo salário: ");
                        novoSalarioFuncionario = scanner.nextDouble();
                    } 

                    AtualizarFuncionario.atualizarFuncionario(repFuncionario, escAtualizarFuncionario, cpfFuncionarioAtualizar, novoNomeFuncionario, novoSalarioFuncionario);
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
                    String novoNomeVoo = "";
                    String novoHorarioVoo = "";
                    String novaDataVoo = "";
                    double novoValorVoo = 0.0; 

                    if(escAtualizarVoo == 1){
                        System.out.print("Digite o nome do novo avião: ");
                        novoNomeVoo = scanner.next();
                    }else if(escAtualizarVoo == 2){
                        System.out.print("Digite o novo horário: ");
                       novoHorarioVoo = scanner.next();
                    }else if(escAtualizarVoo == 3){
                        System.out.print("Digite a nova data: ");
                        novaDataVoo = scanner.next();
                    }else if(escAtualizarVoo == 4){
                        System.out.print("Digite o novo valor da passagem: ");
                        novoValorVoo = scanner.nextDouble();
                    }

                    AtualizarVoo.atualizarVoo(repVoo, repAviao, escAtualizarVoo, dataVooAtualizar, nomeDestinoVooAtualizar, novoNomeVoo, novoHorarioVoo, novaDataVoo, novoValorVoo);
                    System.out.println("\nVoo atualizado com sucesso!");
                    break;
                case 11:
                    System.out.println("\n-- Atualizar passageiro --");
                    System.out.print("Qual o CPF do passageiro que se deseja atualizar? ");
                    String cpfPassageiroAtualizar = scanner.next();   
                    System.out.print("\nDigite o novo nome: ");
                    String novoNomePassageiro = scanner.next();
                    System.out.print("Digite o novo cpf: ");
                    String novoCPFPassageiro = scanner.next();
                    System.out.print("Digite a nova data de nascimento: ");
                    String novaDtaNascPassageiro = scanner.next();

                    AtualizarPassageiro.atualizarPassageiro(repPassageiro, cpfPassageiroAtualizar, novoNomePassageiro, novaDtaNascPassageiro, novoCPFPassageiro);
                    System.out.println("\nPassageiro atualizado com sucesso!");
                    break;
                case 12:
                    System.out.println("\n-- Excluir funcionário --");
                    System.out.print("Qual o CPF do funcionário que se deseja excluir? ");
                    String cpfExcluir = scanner.next();

                    ExcluirFuncionario.excluirFuncionario(repFuncionario, cpfExcluir);
                    System.out.println("\nFuncionário removido com sucesso!");
                    break;
                case 13: 
                    System.out.println("\n-- Excluir voo --");
                    System.out.print("Digite a data do voo: ");
                    String dataDoVooExcluir = scanner.next();
                    System.out.print("Digite o nome do destino do voo: ");
                    String nomeDestinoExcluir = scanner.next();
                    ExcluirVoo.excluirVoo(repVoo, dataDoVooExcluir, nomeDestinoExcluir);
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