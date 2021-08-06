package br.com.letscode.CDITest.Exceptions;

public class SaldoInsuficienteException extends Throwable {
    private String message;

    public  SaldoInsuficienteException(){
        this.message = "Saldo insuficiente.";
    }
}
