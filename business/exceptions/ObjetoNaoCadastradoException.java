package business.exceptions;

public class ObjetoNaoCadastradoException extends Exception{
    public ObjetoNaoCadastradoException(){
        super("Não há NADA cadastrado.");
    }
}
