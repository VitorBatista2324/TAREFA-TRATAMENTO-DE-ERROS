package br.com.catolica.caixa.Controller;

import br.com.catolica.caixa.Model.Conta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Conta> contas = new ArrayList<>();

    public Conta criarConta(String nome, LocalDate criadoEm, String cpf, String senha) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                throw new IllegalArgumentException("Uma conta com esse CPF já existe.");
            }
        }
        Conta conta = new Conta(nome, criadoEm, cpf, senha);
        contas.add(conta);
        return conta;
    }

    public boolean autenticar(String cpf, String senha) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                return conta.entrar(cpf, senha);
            }
        }
        throw new IllegalArgumentException("Conta não encontrada.");
    }

    public void sair(String cpf) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                conta.sair();
                return;
            }
        }
        throw new IllegalArgumentException("Conta não encontrada.");
    }

    public void depositar(String cpf, double valor) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                conta.depositar(valor);
                return;
            }
        }
        throw new IllegalArgumentException("Conta não encontrada.");
    }

    public void sacar(String cpf, double valor) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                conta.sacar(valor);
                return;
            }
        }
        throw new IllegalArgumentException("Conta não encontrada.");
    }

    public double consultarSaldo(String cpf) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                return conta.consultarSaldo();
            }
        }
        throw new IllegalArgumentException("Conta não encontrada.");
    }

    public String obterDetalhes(String cpf) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                return conta.toString();
            }
        }
        throw new IllegalArgumentException("Conta não encontrada.");
    }
}
