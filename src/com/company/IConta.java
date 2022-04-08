package com.company;

public interface IConta {

    public void sacar(double valor);

    public void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    void imprimirExtrato();

}
