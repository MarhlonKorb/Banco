/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author laboratorio
 */
public class Main {

    public static void main(String[] args) {
        ContaService contaService = new ContaService();
        Conta conta = new Conta();
        int opcao = 0;
        Scanner leitor = new Scanner(System.in);
        List<Conta> listaConta = new ArrayList<>();

        do {
            Menu.opcoes();
            opcao = leitor.nextInt();
            if (opcao == 1) {
                System.out.println("### Cadastro de nova conta ###");
                contaService.cadastrarConta(listaConta);
            }
            if (opcao == 2 && listaConta.size() > 0) {
                contaService.efetuarSaque(listaConta, conta);
            }  else if(opcao == 2 && listaConta.size() <= 0){
                System.out.println("Nenhuma conta cadastrada.");
            }
            if (opcao == 3){
                for (Conta contas: listaConta) {
                    System.out.println(contas.toString());
                }
            }
            
        } while (opcao != 4);
        System.out.println("Programa finalizado.");
    }

}
