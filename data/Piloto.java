package data;

public class Piloto extends Funcionario{
    private String tipoPiloto;

    public Piloto(String nome, String CPF, Double salario){
        super(nome, CPF, salario);
    }

    public void setTipoPiloto(String tipo){
        tipoPiloto = tipo;
    }

    public String getTipoPiloto(){
        return tipoPiloto;
    }
}