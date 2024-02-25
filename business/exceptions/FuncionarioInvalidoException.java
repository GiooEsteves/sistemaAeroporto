package business.exceptions;

public class FuncionarioInvalidoException extends Exception{
    public FuncionarioInvalidoException(){
        super("\nERRO: Funcionário inválido, ou inexistente.");
    }
}
