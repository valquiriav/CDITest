package br.com.letscode.CDITest;

import br.com.letscode.CDITest.Exceptions.SaldoELimiteInsuficientesException;

import java.util.Scanner;

public class ContaEspecial extends Conta{

    public ContaEspecial() {
        this.setSaldo(400);
        this.setLimite(200);
    }

    public void realizarSaque() throws SaldoELimiteInsuficientesException {
        System.out.println("Que valor você gostaria de sacar?");
        Scanner scanner = new Scanner(System.in);
        double saque = scanner.nextDouble();

        if (this.getSaldo() >= saque){
            this.setSaldo(this.getSaldo() - saque);
            System.out.println("Saque realizado com sucesso. Saldo atual: " + this.getSaldo());
            System.out.println("Limite atual: " + this.getLimite());
        }
        if (this.getSaldo() + this.getLimite() >= saque){
            this.setSaldo(0);
            this.setLimite(this.getLimite() - saque);
            System.out.println("Saque realizado com sucesso. Saldo atual: " + this.getSaldo());
            System.out.println("Limite atual: " + this.getLimite());
        } else {
            throw new SaldoELimiteInsuficientesException();
        }
    }

    public void fazerDeposito(){
        System.out.println("Que valor você gostaria de depositar?");
        Scanner scanner = new Scanner(System.in);
        double deposito = scanner.nextDouble();

        if (this.getLimite() < 200 && deposito + this.getLimite() <= 200){
            this.setLimite(this.getLimite() + deposito);

        } else if (this.getLimite() < 200 && deposito + this.getLimite() > 200) {
            double faltaLimite = 200 - this.getLimite();
            this.setLimite(200);
            this.setSaldo(this.getSaldo() + faltaLimite);
        } else if (this.getLimite() >= 200){
            this.setSaldo(this.getSaldo() + deposito);
        }
        System.out.println("Depósito realizado com sucesso. Saldo atual: " + this.getSaldo());
        System.out.println("Limite atual: " + this.getLimite());
    }

}