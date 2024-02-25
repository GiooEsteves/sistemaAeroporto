package business.exceptions;

public class AviaoInvalidoException extends Exception{
    public AviaoInvalidoException(){
        super("\nERRO: Avião inválido, ou inexistente.");
    }
}
