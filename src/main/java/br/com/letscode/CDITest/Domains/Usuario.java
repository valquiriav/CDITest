package br.com.letscode.CDITest.Domains;

import br.com.letscode.CDITest.Domains.Conta;
import br.com.letscode.CDITest.Domains.ContaEspecial;
import br.com.letscode.CDITest.Domains.ContaPoupanca;
import br.com.letscode.CDITest.Exceptions.OpcaoInvalidaException;
import br.com.letscode.CDITest.Exceptions.PossuiContaException;
import br.com.letscode.CDITest.Exceptions.SaldoELimiteInsuficientesException;
import br.com.letscode.CDITest.Exceptions.SaldoInsuficienteException;

import java.util.Scanner;

public class Usuario {

    private Long cpf;
    private String nome;
    private int codigo;

    private Conta contaPrincipal;
    private ContaEspecial contaEspecial;
    private ContaPoupanca contaPoupanca;

    public Usuario(Long cpf, String nome, int codigo) {
        this.cpf = cpf;
        this.nome = nome;
        this.codigo = codigo;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", senha='" + codigo + '\'' +
                '}';
    }

    public void escolherAcao() throws PossuiContaException, OpcaoInvalidaException, SaldoInsuficienteException, SaldoELimiteInsuficientesException {
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Movimentar Conta Existente");
        System.out.println("2 - Criar nova Conta");

        Scanner scanner = new Scanner(System.in);
        int acao = scanner.nextInt();

        switch (acao){
            case 1:
                this.movimentarConta();
                break;
            case 2:
                this.criarConta();
                break;
            default:
                throw new OpcaoInvalidaException();
        }
    }

    private void criarConta() throws PossuiContaException, OpcaoInvalidaException, SaldoInsuficienteException, SaldoELimiteInsuficientesException {

        System.out.println("Escolha a conta que você gostaria de criar: ");
        System.out.println("1 - Conta Principal");
        System.out.println("2 - Conta Especial");
        System.out.println("3 - Conta Poupança");

        Scanner scanner = new Scanner(System.in);
        int conta = scanner.nextInt();

        switch (conta) {
            case 1:
                Conta contaPrincipal = new Conta();
                break;
            case 2:
                Conta contaEspecial = new ContaEspecial();
                break;
            case 3:
                Conta contaPoupanca = new ContaPoupanca();
                break;
            default:throw new OpcaoInvalidaException();
        }
        this.escolherAcao();
    }

    public void movimentarConta() throws SaldoInsuficienteException, SaldoELimiteInsuficientesException, OpcaoInvalidaException {
        realizarOperacao(escolherContaAMovimentar(), escolherOperacaoAFazer());
    }

    public Conta escolherContaAMovimentar() throws SaldoInsuficienteException, SaldoELimiteInsuficientesException, OpcaoInvalidaException {
        System.out.println("Escolha a conta que você gostaria de movimentar: ");
        System.out.println("1 - Conta Principal");
        System.out.println("2 - Conta Especial");
        System.out.println("3 - Conta Poupança");

        Scanner scanner = new Scanner(System.in);
        int conta = scanner.nextInt();

        switch (conta) {
            case 1:
                return contaPrincipal;
            case 2:
                return contaEspecial;
            case 3:
                return contaPoupanca;
            default:
                throw new OpcaoInvalidaException();
        }
    }

    public int escolherOperacaoAFazer() {

        System.out.println("Escolha a operação que você gostaria de fazer: ");
        System.out.println("1 - Visualizar Saldo");
        System.out.println("2 - Realizar Saque");
        System.out.println("3 - Realizar Depósito");

        Scanner scanner = new Scanner(System.in);
        int operacao = scanner.nextInt();

        return operacao;
    }

    public void realizarOperacao(Conta conta, int operacao) throws SaldoInsuficienteException, SaldoELimiteInsuficientesException, OpcaoInvalidaException {

        switch (operacao) {
            case 1: conta.visualizarSaldo();
            case 2: conta.realizarSaque();
            case 3: conta.fazerDeposito();
            default: throw new OpcaoInvalidaException();
        }
    }
}