package br.com.catolica.caixa.Controller;

import br.com.catolica.caixa.Model.Conta;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Controller {



        private Map<String, Conta> contas = new HashMap<>();

        public Conta criarConta(String nome, LocalDate criadoEm, String cpf, String senha) {
            if (contas.containsKey(cpf)) {
                throw new IllegalArgumentException("Uma conta com esse CPF já existe.");
            }
            Conta conta = new Conta(nome, criadoEm, cpf, senha);
            contas.put(cpf, conta);
            return conta;
        }

        public boolean autenticar(String cpf, String senha) {
            Conta conta = contas.get(cpf);
            if (conta == null) {
                throw new IllegalArgumentException("Conta não encontrada.");
            }
            return conta.entrar(cpf, senha);
        }

        public void sair(String cpf) {
            Conta conta = contas.get(cpf);
            if (conta == null) {
                throw new IllegalArgumentException("Conta não encontrada.");
            }
            conta.sair();
        }

        public void depositar(String cpf, double valor) {
            Conta conta = contas.get(cpf);
            if (conta == null) {
                throw new IllegalArgumentException("Conta não encontrada.");
            }
            conta.depositar(valor);
        }

        public void sacar(String cpf, double valor) {
            Conta conta = contas.get(cpf);
            if (conta == null) {
                throw new IllegalArgumentException("Conta não encontrada.");
            }
            conta.sacar(valor);
        }

        public double consultarSaldo(String cpf) {
            Conta conta = contas.get(cpf);
            if (conta == null) {
                throw new IllegalArgumentException("Conta não encontrada.");
            }
            return conta.consultarSaldo();
        }

        public String obterDetalhes(String cpf) {
            Conta conta = contas.get(cpf);
            if (conta == null) {
                throw new IllegalArgumentException("Conta não encontrada.");
            }
            return conta.toString();
        }
    }


