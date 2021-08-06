package br.com.letscode.CDITest.Exceptions;

public class PossuiContaException extends Throwable {
    private String message;

    public  PossuiContaException(){
        this.message = "Você já possui este tipo de conta.";
    }

}
