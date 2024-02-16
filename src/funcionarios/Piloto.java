package src.funcionarios;

public class Piloto extends Funcionario{
    private String tipoPiloto;

    public void setTipoPiloto(String tipo){
        tipoPiloto = tipo;
    }

    public String getTipoPiloto(){
        return tipoPiloto;
    }
}