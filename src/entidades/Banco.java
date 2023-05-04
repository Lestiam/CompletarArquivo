package entidades;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private  String nome;
    private List<Conta> contas;

    public Banco() {
    }

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addConta (Conta conta) {
        contas.add(conta);
    }
    public void removeConta (Conta conta) {
        contas.remove(conta);
    }

    public Double totalContas() {
        double saldoTotal = 0;
        for (Conta conta : contas) {
            String saldoStr = conta.getSaldo().replace("R$", "").replace(",", ".").trim();
            double saldo = Double.parseDouble(saldoStr);
            saldoTotal += saldo;
        }
        return saldoTotal;
    }
}
