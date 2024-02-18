package business.exceptions;

public class ObjetoNaoCadastradoException extends Exception{
    public ObjetoNaoCadastradoException(){
        super("ERRO: Não há NADA cadastrado.");
    }
}
