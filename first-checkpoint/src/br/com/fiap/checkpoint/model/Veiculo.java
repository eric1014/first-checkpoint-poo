package br.com.fiap.checkpoint.model;

public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private boolean disponibilidade;

    public Veiculo(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.disponibilidade = true;
    }

    public boolean verificarDisponibilidade() {
        return disponibilidade;
    }

    public void definirDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // Podemos adicionar outros metodos
}

