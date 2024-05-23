package br.com.catolica.caixa.Model;

public class AppBanco {

    private Conta conta;

    public AppBanco(Conta conta) {
        this.conta = conta;
    }

    public void entrar(String cpf, String senha){
        boolean status = this.conta.entrar(cpf, senha);

        if (status){
            System.out.println("Login realizado!");
        } else {
            System.out.println("Credenciais inválidas!");
        }

    }

    public void sair(){
        boolean status = this.conta.sair();
        if (status){
            System.out.println("Saiu da conta!");
        } else {
            System.out.println("Erro ao sair!");
        }
    }

    public void depositar(double valor){
        this.conta.depositar(valor);
        System.out.println("Deposito realizado!");
    }

    public void sacar(double valor){
        boolean status = this.conta.sacar(valor);

        if (status){
            System.out.println("O valor foi sacado!");
        } else {
            System.out.println("Sem permissão para sacar!");
        }
    }

    public void consultarSaldo(){
        double valor = this.conta.consultarSaldo();

        if (valor > -1){
            System.out.printf("\nSaldo atual: %.2f\n", valor);
        } else {
            System.out.println("Sem permissão para visualizar!");
        }
    }

    @Override
    public String toString() {
        return this.conta.toString();
    }
}
