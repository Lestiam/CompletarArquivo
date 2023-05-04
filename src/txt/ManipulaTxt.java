package txt;

import entidades.Cliente;
import entidades.Conta;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipulaTxt {
    public static List<Conta> leitor(String path) throws IOException {
        List<Conta> contas = new ArrayList<>();
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha  = buffRead.readLine();


        while (linha != null) {
            String[] campos = linha.split(","); //corta na posição da vírcula
            String agencia = campos[0].replace("Agencia:", "").trim();//substitui o nome por vazio e corta na posição
            String numero = campos[1].replace("Conta:", "").trim();
            String saldo = campos[2].replace("Saldo:", "").trim();
            contas.add(new Conta(agencia, numero, saldo));
            linha = buffRead.readLine();
        }

        buffRead.close();
        return contas;
    }

    public static void escrever(String path, String conteudo) throws IOException{
        BufferedWriter buffWri = new BufferedWriter(new FileWriter(path));
        buffWri.write(conteudo);
        buffWri.close();
    }

    public static void imprimeContas (String path) throws IOException{
        Cliente cliente = new Cliente();
        BufferedReader buffRead0 = new BufferedReader(new FileReader(path));
        String linha  = buffRead0.readLine();
        while (true) {
            if (linha != null) {
                JOptionPane.showMessageDialog(null, linha, "Lista de contas", JOptionPane.PLAIN_MESSAGE);
            } else
                break;
            linha = buffRead0.readLine();
        }
    }

}
