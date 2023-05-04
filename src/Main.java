import entidades.Banco;
import entidades.Cliente;
import entidades.Conta;
import txt.ManipulaTxt;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String nome = JOptionPane.showInputDialog(null, "Informe o nome do(a) cliente: ", "Nome", JOptionPane.PLAIN_MESSAGE);
            Cliente cliente = new Cliente(nome);
            String pathContas = "D:\\fa\\linguagens de programação\\CompletarArquivo\\src\\txt\\Contas.txt";
            ManipulaTxt.imprimeContas(pathContas);
            List<Conta> contas = ManipulaTxt.leitor(pathContas);


            String nomeBanco = JOptionPane.showInputDialog(null, "Cliente "+ cliente.getNome() + " informe o nome do banco: ", "Banco", JOptionPane.PLAIN_MESSAGE);
            Banco banco = new Banco(nomeBanco);

            for (Conta conta : contas) {
                banco.addConta(conta);
            }


            double saldoTotal = banco.totalContas();
            String conteudoArquivo = "Banco " + banco.getNome() + " possui o saldo geral de contas de: R$" + String.format("%.2f", saldoTotal);
            String pathSoma = "D:\\fa\\linguagens de programação\\CompletarArquivo\\src\\txt\\SaldoTotal.txt";
            ManipulaTxt.escrever(pathSoma, conteudoArquivo);

            JOptionPane.showMessageDialog(null, "Arquivo Saldo Total.txt criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Endereço: " + pathSoma, "Endereço ",JOptionPane.INFORMATION_MESSAGE);
            sc.close();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}