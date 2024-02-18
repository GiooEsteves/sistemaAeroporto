package business.exceptions;

public class VooLotadoException extends Exception{
    public VooLotadoException(String mensagem){
        super("ERRO: Voo lotado!" + mensagem);
    }
}
