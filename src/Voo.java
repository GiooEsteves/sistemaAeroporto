package src;

import java.util.ArrayList;
import java.util.Scanner;

import business.exceptions.DadosVaziosException;
import business.exceptions.ObjetoNaoCadastradoException;
import business.exceptions.VooInvalidoException;
import business.exceptions.VooLotadoException;

public class Voo {
    Aviao aviao;
    String horario;
    String data;
    String origem;
    String destino;
    public double valorUnitario;
    int aBordo;

    ArrayList <Voo> voos = new ArrayList<Voo>();
    Scanner scanner = new Scanner(System.in); 

    public void setVoo(Aviao a, String h, String da, String o, String dest, double vUnit) throws DadosVaziosException{
        if(a == null || h == "" || da == "" || o == "" || dest == "" || vUnit == 0){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados VAZIOS.");
        }else if(a == null || h == null || da == null || o == null || dest == null || vUnit == 0){
            throw new DadosVaziosException("\nERRO: Está sendo passado dados NULOS.");
        }else{
            aviao = a;
            horario = h;
            data = da;
            origem = o;
            destino = dest;
            valorUnitario = vUnit;
        }
    }

    public void setAviao(Voo vooParaAtualizar, String novoNome){
        Aviao aviao = new Aviao();
        try{
            Aviao a = aviao.matchAviao(novoNome);
            vooParaAtualizar.aviao = a;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void setHorario(Voo vooParaAtualizar, String h){
        vooParaAtualizar.horario = h;
    }

    public void setData(Voo vooParaAtualizar, String d){
        vooParaAtualizar.data = d;
    }

    public void setValor(Voo vooParaAtualizar, double v){
        vooParaAtualizar.valorUnitario = v;
    }

    public void setABordo(int qtd){
        aBordo = aBordo + qtd;
    }

    public int getABordo(){
        return aBordo;
    }

    public String getData(){
        return data;
    }

    public String getDestino(){
        return destino;
    }

    public int getCapacidade(){
        return aviao.getCapacidade();
    }

    public String getPlaneInfo(){
        return "Aeroporto Guararapes" + "\nAvião: "+ aviao.getNome() +"\nData: " + data + "\nHorário: " + horario 
                + "\nOrigem: " +origem+ "   Destino: " +destino+"\n";
    }

    public void inserirVoo(Aviao a, String h, String da, String o, String dest, double vUnit){
        try{
            Voo voo = new Voo();
            voo.setVoo(a, h, da, o, dest, vUnit); 
            voos.add(voo);
            System.out.println("\nVoo criado");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarVoos() throws ObjetoNaoCadastradoException{
        if(voos.isEmpty()){
            throw new ObjetoNaoCadastradoException();
        }
        for(Voo v : voos){
            System.out.println(v.getPlaneInfo());    
        }
    }

    public Voo escolherVoo(String dta, String nDestino, int numPassageiro) throws VooInvalidoException, VooLotadoException{
        for(Voo v : voos){
            if(v.getData().equals(dta) && v.getDestino().equals(nDestino) && v.getCapacidade() >= (v.getABordo() + numPassageiro)){
                System.out.print("\nVoo encontrado: ");
                System.out.print(v.getPlaneInfo());
                System.out.println("\nVoo selecionado!\n"); 
                return v;
            }else if(v.getData().equals(dta) && v.getDestino().equals(nDestino) && v.getCapacidade() < (v.getABordo() + numPassageiro)){
                throw new VooLotadoException("Há apenas " + (v.getCapacidade() - v.getABordo()) + " assento(s)");
            }
        }
        throw new VooInvalidoException();
    }

    public Voo matchVoo(String dta, String nDestino) throws VooInvalidoException{
        for(Voo v : voos){
            if(v.getData().equals(dta) && v.getDestino().equals(nDestino)){
                System.out.print("\nVoo encontrado: ");
                System.out.print(v.getPlaneInfo());
                System.out.println("\nVoo selecionado!"); 
                return v;
            }
        }
        throw new VooInvalidoException();
    }

    public void atualizarVoo(int esc, String dta, String nDestino){
        try{
            Voo vooParaAtualizar = matchVoo(dta, nDestino);
            if(esc == 1){
                System.out.print("Digite o nome do novo avião: ");
                String novoNome = scanner.next(); 
                setAviao(vooParaAtualizar, novoNome);
            }else if(esc == 2){
                System.out.print("Digite o novo horário: ");
                String novoHorario = scanner.next();
                setHorario(vooParaAtualizar, novoHorario);
            }else if(esc == 3){
                System.out.print("Digite a nova data: ");
                String novaData = scanner.next();
                setData(vooParaAtualizar, novaData);
            }else if(esc == 4){
                System.out.print("Digite o novo valor da passagem: ");
                double novoValor = scanner.nextDouble();
                setValor(vooParaAtualizar, novoValor);
            }
            System.out.println("\nVoo atualizado com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirVoo(String data, String destino){
        try{
            Voo vooParaExcluir = matchVoo(data, destino);
            voos.remove(vooParaExcluir);
            System.out.println("\nVoo removido com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}