/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author laboratorio
 */
public class ContaService {

    public void cadastrarConta(List<Conta> contas) {
        Scanner leitor = new Scanner(System.in);
        Conta conta = new Conta();
            System.out.println("Digite seu nome: ");
            String nome = leitor.next();
            conta.setNome(nome);
            System.out.println("Digite um valor para depósito: R$");
            depositar(conta);
            contas.add(conta);
            System.out.println("Conta " + conta.getNumero() + " cadastrada com sucesso.");
        
    }
    
    private void depositar(Conta conta){
        Scanner leitor = new Scanner(System.in);
        double valordeposito = leitor.nextDouble();
        double valorTotal = Double.sum(valordeposito, conta.getSaldo());
        conta.setValorDeposito(valorTotal);
        conta.setSaldo(conta.getValorDeposito());
    }

    public boolean permiteSaque(Conta conta, double valor) {
        if (valor < conta.getSaldo()) {
            return true;
        }
        return false;
    }

    private void sacar(Conta conta, double valor) {
        if (valor < conta.getSaldo() && conta.getLimiteSaque() <= 0) {
            conta.setSaldo(conta.getSaldo() - valor);
            
        }
    }

    private boolean isExisteNumeroConta(int numeroConta, List<Conta> listaContas) {
        for (Conta contas : listaContas) {
            if (contas.getNumero() == numeroConta) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    private void atualizarConta(Conta conta) {
        conta.setNome(conta.getNome());
        conta.setValorDeposito(conta.getSaldo());
        conta.setSaldo(conta.getSaldo());
        conta.setLimiteSaque(conta.getLimiteSaque());
    }
    
    public void efetuarSaque(List<Conta> lista, Conta conta){
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o número da conta: ");
        int numeroConta = leitor.nextInt();
        System.out.println("Digite o valor de saque: ");
        double valorSaque = leitor.nextDouble();
        if(isExisteNumeroConta(numeroConta, lista) && permiteSaque(conta,valorSaque)) {
            conta.setLimiteSaque(conta.getLimiteSaque() - valorSaque);
            sacar(conta, valorSaque);
            atualizarConta(conta);
        } else {
            System.out.println("Saldo insuficiente ou conta não cadastrada.");
        }
        
    }

    
}
