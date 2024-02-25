package business.exceptions;

public class VooInvalidoException extends Exception{
    public VooInvalidoException(){
        super("\nERRO: Nenhum voo encontrado com os critérios fornecidos.");
    }
}
