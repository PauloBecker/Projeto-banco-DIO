package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcao = -99;
        Scanner tc = new Scanner(System.in);

        Cliente cliente = new Cliente();
        //cliente.setNome("Paulo Becker");

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);

        System.out.print("Informe seu nome: ");
        String nomeCliente = tc.nextLine();
        cliente.setNome(nomeCliente);
        System.out.println("Olá " + cliente.getNome() + ", seja bem vindo ao seu banco virtual.");

        while (opcao != 0) {
            System.out.print("Escolha: opção - 1 (Depositar) | opção - 2 (Saque) | opção - 3 (Depósito conta poupança) | opcao - 4 (Consultar extrato) | opção - 0 (Encerrar sistema): ");
            opcao = tc.nextInt();


            switch (opcao) {

                case 0:
                    System.out.println("Até logo!!!");
                    break;
                case 1:
                    System.out.print("Informe o valor do deposito: ");
                    double valorDeposito = tc.nextDouble();
                    cc.depositar(valorDeposito);
                    cc.imprimirExtrato();
                    poupanca.imprimirExtrato();
                    break;

                case 2:
                    System.out.print("Informe o valor de saque: ");
                    double valorSaque = tc.nextDouble();
                    if (valorSaque <= cc.saldo) {
                        cc.sacar(valorSaque);
                        System.out.println("\n ==== Você sacou R$ " + valorSaque + " reais da sua conta corrente. ====");
                    } else {
                        System.out.println("\n ##### Saldo insuficiente #####\n");
                    }
                    cc.imprimirExtrato();
                    poupanca.imprimirExtrato();
                    break;
                case 3:
                    System.out.print("Informe o valor a ser transferido para conta poupança: ");
                    double valorDepositoPoupanca = tc.nextDouble();
                    if (valorDepositoPoupanca > cc.saldo) {
                        System.out.println("#### Saldo em conta corrente insuficiente ####");
                    } else {
                        cc.transferir(valorDepositoPoupanca, poupanca);
                    }
                    cc.imprimirExtrato();
                    poupanca.imprimirExtrato();
                    break;

                case 4:
                    cc.imprimirExtrato();
                    poupanca.imprimirExtrato();
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }

    }
}

