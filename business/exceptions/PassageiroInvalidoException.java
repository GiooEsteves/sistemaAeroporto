package business.exceptions;

public class PassageiroInvalidoException extends Exception{
    public PassageiroInvalidoException(){
        super("\nERRO: Passageiro inválido, ou inexistente.");
    }
}
