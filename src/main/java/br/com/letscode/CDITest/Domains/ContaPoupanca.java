package br.com.letscode.CDITest.Domains;

import br.com.letscode.CDITest.Domains.Conta;
import br.com.letscode.CDITest.Exceptions.SaldoInsuficienteException;

import java.util.Scanner;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
        this.setSaldo(100);
    }

    public void realizarSaque() throws SaldoInsuficienteException {
        System.out.println("Que valor você gostaria de sacar?");
        Scanner scanner = new Scanner(System.in);
        double saque = scanner.nextDouble();

        if (this.getSaldo() >= saque){
            this.setSaldo(this.getSaldo() - saque - this.getSaldo() * 0.0007);
            System.out.println("Saque realizado com sucesso. Saldo atual: " + this.getSaldo());
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    public void fazerDeposito(){
        System.out.println("Que valor você gostaria de depositar?");
        Scanner scanner = new Scanner(System.in);
        double deposito = scanner.nextDouble();

        this.setSaldo(this.getSaldo() + deposito - this.getSaldo() * 0.0007);
        System.out.println("Depósito realizado com sucesso. Saldo atual: " + this.getSaldo());
    }

}
