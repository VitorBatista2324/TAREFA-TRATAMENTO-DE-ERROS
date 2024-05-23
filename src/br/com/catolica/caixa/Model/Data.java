package br.com.catolica.caixa.Model;

public class Data {
    public int dia;
    public int mes;
    public int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        String data = String.format("<Data: %d/%d/%d>", dia, mes, ano);
        return data;
    }

}

