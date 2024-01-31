package ui;

import java.util.Scanner;
import java.util.ArrayList;
import business.*;
import data.*;

public class App{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList <Aviao> avioesDisponiveis = new ArrayList<Aviao>();                   // Quando o BD estiver funcionando, eliminar
        ArrayList <Voo> voos = new ArrayList<Voo>();

        boolean loop = true;
        while (loop){
            System.out.println(" \n-- Aeroporto --");
            System.out.println("1. Cadastro de funcionário");
            System.out.println("2. Cadastro de aviões");
            System.out.println("3. Cadastro de voo"); 
            System.out.println("4. Lista de funcionários");         
            System.out.println("5. Lista de aviões");
            System.out.println("6. Lista de voos");
            System.out.println("7. Lista de passageiros");
            System.out.println("8. Compra de passagem"); 
            System.out.println("9. Eliminar dados");  
            System.out.println("10. Sair"); 
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
                    String n = scanner.nextLine();
                    System.out.print("Digite o CPF do funcionário: ");
                    String c = scanner.nextLine();
                    System.out.print("Digite o salário do funcionário: ");
                    Double s = scanner.nextDouble();

                    if(func == 1){
                        Piloto piloto = new Piloto(n,c,s);
                        System.out.print("Qual o tipo do piloto? ");
                        String tipo = scanner.next();
                        piloto.setTipoPiloto(tipo);
                        BancoDeDados.dadosEmArquivos("Funcionarios.txt", piloto.getDadosFuncionarios());
                    }else if(func == 2){
                        AgenteDeBordo ag = new AgenteDeBordo(n,c,s);
                        BancoDeDados.dadosEmArquivos("Funcionarios.txt", ag.getDadosFuncionarios());
                    }else if(func == 3){
                        Vendedor vendedor = new Vendedor(n,c,s);
                        BancoDeDados.dadosEmArquivos("Funcionarios.txt", vendedor.getDadosFuncionarios());
                    }
                    System.out.println("\nFuncionário cadastrado!");
                    break;
                case 2:
                    System.out.println("\n-- Cadastro de aviões --"); 
                    System.out.print("Nome: ");
                    String no = scanner.next();
                    System.out.print("Capacidade: ");
                    int cap = scanner.nextInt();
                    System.out.print("Tipo de avião: ");
                    String ti = scanner.next();

                    Aviao aviao = new Aviao(no, cap, ti);
                    BancoDeDados.dadosEmArquivos("Aviões.txt", aviao.getDadosAviao());

                    avioesDisponiveis.add(aviao);
                    BancoDeDados.dadosEmArquivos("Aviões disponíveis.txt", aviao.getDadosAviao());
                    System.out.println("\nAvião cadastrado!");
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

                    for(Aviao a : avioesDisponiveis){               // ALTERAR PARA O BD
                        if(a.getNome().equals(aviaoNome)){
                            Voo voo = new Voo(a, h, dtaPartida, cidOrigem, cidDestino, valorU);      
                            voos.add(voo);
                            System.out.println("Voo criado ");
                            BancoDeDados.dadosEmArquivos("Registro de voos.txt", voo.getPlaneInfo());
                            BancoDeDados.eliminarDadosDeArquivo("Aviões disponíveis", a.getDadosAviao());   
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n-- Lista de Funcionários --");
                    BancoDeDados.lerDadosDeArquivo("Funcionarios.txt");
                break;
                case 5:
                    System.out.println("\n-- Lista de aviões --");
                    BancoDeDados.lerDadosDeArquivo("Aviões.txt");
                    break;
                case 6:
                    System.out.println("\n-- Lista de voos --");
                    BancoDeDados.lerDadosDeArquivo("Registro de voos.txt");
                    break;
                case 7:
                    System.out.println("");
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

                    for(Voo v : voos){          // ALTERAR PARA O BD
                        if(v.getData().equals(dta) && v.getDestino().equals(nDestino) && v._getCapacidade() >= (v.getABordo() + numPassageiro)){
                            System.out.println("\nVoo encontrado: ");
                            System.out.println(v.getPlaneInfo());
                            System.out.println("\nVoo selecionado!\n");
                            ComprarPassagem passagem = new ComprarPassagem(v);
                            passagem.getPagamento(numPassageiro);

                            //if(pagamento = "aprovado"){ 
                            System.out.println("Pagamento aprovado!\n"); 
                            for(int i = 0; i<numPassageiro; i++){
                                System.out.println("Dados do passageiro ");
                                System.out.print("Digite o nome: ");
                                String nomePassageiro = scanner.next();
                                System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
                                String nascPassageiro = scanner.next();
                                System.out.print("Digite o CPF: ");
                                String cpfPassageiro = scanner.next();
        
                                Passageiro passageiro = new Passageiro(nomePassageiro, nascPassageiro, cpfPassageiro);
                                passagem.setPassageiro(passageiro);
                                System.out.println("\n" + passagem.getPassagem() + "\n");
                                //passageirosDoVoo.add(passagem.getPassagem());
                                BancoDeDados.dadosEmArquivos("Passageiros do voo.txt", passageiro.getNome() +" - "+passagem.getPassagem());
                            }
                            v.setABordo(numPassageiro);
                            //}else{ 
                                //System.out.println("Pagamento recusado");
                                //break;
                            //} 
                        }else{
                            System.out.println("Voo lotado!");
                            System.out.println("Há apenas " + (v._getCapacidade() - v.getABordo()) + " assentos");
                        }
                    }      
                    break;
                case 9:
                    System.out.println("\n-- Eliminar dados --");
                    System.out.println("Arquivos\n");
                    System.out.println("Funcionarios");
                    System.out.println("Aviões");
                    System.out.println("Aviões disponíveis");
                    System.out.println("Registro de voos");
                    System.out.println("Passageiros");
                    System.out.print("Digite qual o arquivo: ");
                    String opArq = scanner.next();

                    System.out.print("Deseja apagar todos os dados? [sim/nao]: ");
                    String resp = scanner.next();
                    
                    if(resp == "sim"){
                        BancoDeDados.eliminarTodoConteudoDeArquivo(opArq+".txt");
                        System.out.println(opArq+".txt");
                    }else if(resp == "nao"){
                        
                    }
                    break;
                case 10:
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