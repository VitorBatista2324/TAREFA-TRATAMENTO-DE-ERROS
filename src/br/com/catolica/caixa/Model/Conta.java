package br.com.catolica.caixa.Model;

import java.time.LocalDate;

public class Conta {
    private String nome;
    private LocalDate criadoEm;
    private String cpf;
    private String senha;
    private double saldo = 0;
    private boolean autenticado = false;

    public Conta(String nome, LocalDate data, String cpf, String senha) {
        if (nome == null || nome.isEmpty() || cpf == null || cpf.isEmpty() || senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Nome, CPF e senha não podem ser nulos ou vazios.");
        }
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.nome = nome;
        this.criadoEm = data;
        this.cpf = cpf;
        this.senha = senha;
    }

    public boolean entrar(String cpf, String senha){
        if (this.cpf.equals(cpf) && this.senha.equals(senha)){
            this.autenticado = true;
        } else {
            throw new IllegalArgumentException("CPF ou senha incorretos.");
        }
        return this.autenticado;
    }

    public boolean sair(){
        this.autenticado = false;
        return true;
    }

    public void depositar(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }
        this.saldo += valor;
    }


    public boolean sacar(double valor){
        if (!this.autenticado) {
            throw new IllegalStateException("Usuário não autenticado.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo.");
        }
        if (this.saldo >= valor){
            this.saldo -= valor;
            return true;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
    }

    public double consultarSaldo(){
        if (!this.autenticado){
            throw new IllegalStateException("Usuário não autenticado.");
        }
        return this.saldo;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    @Override
    public String toString() {
        return String.format("<Conta: nome=%s, criadoEm=%s>", this.nome, this.criadoEm);
    }
}
