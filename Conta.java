/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.util.Random;

/**
 *
 * @author Marhlon Korb
 */
public class Conta {

    private String nome;
    private int numeroConta;
    private double saldo;
    private double valorDeposito;

    private double limiteSaque;
    Conta() { this.setNumero(); this.setLimiteSaque(1000);}
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numeroConta != 0 ? numeroConta : 0;
    }

    private void setNumero() {
        int conta = new Random().nextInt(1000, 10000);
        this.numeroConta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getValorDeposito() {
        return valorDeposito;
    }

    public void setValorDeposito(double valorDeposito) {
        this.valorDeposito = valorDeposito;
    }
    
    public double getLimiteSaque () {
        return 1000;
    }
    
    public void setLimiteSaque (double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
  
    
    @Override
    public String toString () {
        return "Extrato bancário - Conta\n" +
                "\nnome:" + nome  +
                "\nnumero da conta:" + numeroConta +
                "\nsaldo: R$" + saldo +
                "\nvalor de deposito: R$" + valorDeposito +
                "\nlimite de saque: R$" + limiteSaque;
    }
}
