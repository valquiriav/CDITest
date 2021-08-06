package br.com.letscode.CDITest.Exception;

public class SaldoELimiteInsuficientesException extends Throwable {
    private String message;

    public  SaldoELimiteInsuficientesException(){
        this.message = "Saldo e/ou limite insuficientes.";
    }
}
