package src;

import java.util.ArrayList;

import business.exceptions.VooInvalidoException;

public class Voo {
    Aviao aviao;
    String horario;
    String data;
    String origem;
    String destino;
    public double valorUnitario;
    int aBordo;

    ArrayList <Voo> voos = new ArrayList<Voo>();

    public void setVoo(Aviao a, String h, String da, String o, String dest, double vUnit){
        aviao = a;
        horario = h;
        data = da;
        origem = o;
        destino = dest;
        valorUnitario = vUnit;
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
        return "\nAeroporto Guararapes" + "\nData: " + data + "\nHorário: " + horario + "\nOrigem: " +origem+ "   Destino: " +destino+"\n\n";
    }

    public void inserirVoo(Aviao a, String h, String da, String o, String dest, double vUnit){
        Voo voo = new Voo();
        voo.setVoo(a, h, da, o, dest, vUnit); 
        voos.add(voo);
        System.out.println("Voo criado ");
    }

    public void listarVoos(){
        for(Voo v : voos){
            System.out.println(v.getPlaneInfo());
        }
    }

    public Voo matchVoo(String dta, String nDestino, int numPassageiro) throws VooInvalidoException{
        try{
            for(Voo v : voos){
                if(v.getData().equals(dta) && v.getDestino().equals(nDestino) && v.getCapacidade() >= (v.getABordo() + numPassageiro)){
                    System.out.println("\nVoo encontrado: ");
                    System.out.println(v.getPlaneInfo());
                    System.out.println("\nVoo selecionado!\n"); 
                    return v;
                }else if(v.getData().equals(dta) && v.getDestino().equals(nDestino) && v.getCapacidade() < (v.getABordo() + numPassageiro)){
                    System.out.println("Voo lotado!");
                    System.out.println("Há apenas " + (v.getCapacidade() - v.getABordo()) + " assentos");
                }
            }
            throw new VooInvalidoException("Nenhum voo encontrado com os critérios fornecidos.");
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new VooInvalidoException("ERRO ao procurar voo: " + e.getMessage());
        }
    }
}