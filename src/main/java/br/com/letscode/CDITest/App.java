package br.com.letscode.CDITest;
import br.com.letscode.CDITest.Exceptions.OpcaoInvalidaException;
import br.com.letscode.CDITest.Exceptions.PossuiContaException;
import br.com.letscode.CDITest.Exceptions.SaldoELimiteInsuficientesException;
import br.com.letscode.CDITest.Exceptions.SaldoInsuficienteException;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main( String[] args ) throws PossuiContaException, OpcaoInvalidaException, SaldoInsuficienteException, SaldoELimiteInsuficientesException {
        executar();
    }

    public static void executar() throws PossuiContaException, OpcaoInvalidaException, SaldoInsuficienteException, SaldoELimiteInsuficientesException {
        System.out.println("Seja bem vindo! Escolha uma opção:");
        System.out.println("1 - Autenticar usuário");
        System.out.println("2 - Criar usuário");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                autenticarUsuario();
                break;
            case 2:
                criarUsuario();
                break;
            default:
                System.err.println("Opção inválida.");
        }
        executar();
    }

    public static void autenticarUsuario() throws PossuiContaException, OpcaoInvalidaException, SaldoInsuficienteException, SaldoELimiteInsuficientesException {
        System.out.println("Digite seu código de autenticação:");
        Scanner scanner = new Scanner(System.in);
        int codigo = scanner.nextInt();

        for (Usuario usuario : Cadastro.getUsuarios()){
            if (codigo == usuario.getCodigo()){

                System.out.println("Boas vindas, " + usuario.getNome() + "!");
                usuario.escolherAcao();
                break;
            }
        }
    }


    public static void criarUsuario() throws PossuiContaException, OpcaoInvalidaException, SaldoInsuficienteException, SaldoELimiteInsuficientesException {

        System.out.println("Digite o seu nome:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.next();

        System.out.println("Digite seu cpf:");
        Long cpf = scanner.nextLong();

        Random rand = new Random();
        int codigo = rand.nextInt(99999);

        Usuario usuario = new Usuario(cpf, nome, codigo);

        Cadastro.getUsuarios().add(usuario);

        System.out.println("Usuário criado com sucesso!");
        System.out.println("Seus dados são: ");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Código de autenticação: " + codigo + " (Não o perca! Ele será sua chave para acessar a conta.)");

        autenticarUsuario();

    }

}