package br.com.letscode.CDITest.Domains;

import br.com.letscode.CDITest.Exceptions.SaldoELimiteInsuficientesException;
import br.com.letscode.CDITest.Exceptions.SaldoInsuficienteException;

import java.util.Scanner;

public class Conta {

    private double saldo;
    private double limite;

    public Conta() {
        this.saldo = 0;
    }

    public void escolherAcao(int tipoConta){

        System.out.println("Escolha aquilo que deseja fazer:");
        System.out.println("1 - Visualizar saldo");
        System.out.println("2 - Realizar saque");
        System.out.println("3 - Fazer depósito");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();
    }

    public void fazerDeposito(){
        System.out.println("Que valor você gostaria de depositar?");
        Scanner scanner = new Scanner(System.in);
        double deposito = scanner.nextDouble();

        this.setSaldo(this.getSaldo() + deposito);
        System.out.println("Depósito realizado com sucesso. Saldo atual: " + this.getSaldo());
    }

    public void visualizarSaldo() {
        System.out.println("O seu saldo atual é de " + this.getSaldo());
    }

    public void realizarSaque() throws SaldoInsuficienteException, SaldoELimiteInsuficientesException {
        System.out.println("Que valor você gostaria de sacar?");
        Scanner scanner = new Scanner(System.in);
        double saque = scanner.nextDouble();

        if (this.getSaldo() >= saque){
            this.setSaldo(this.getSaldo() - saque);
            System.out.println("Saque realizado com sucesso. Saldo atual: " + this.getSaldo());
        } else {
            System.err.println("Saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

}