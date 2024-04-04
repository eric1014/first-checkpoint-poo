package br.com.fiap.checkpoint.model;

import java.time.LocalDate;

public class Locacao {
    private Veiculo veiculoAlugado;
    private Cliente cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Locacao(Veiculo veiculoAlugado, Cliente cliente, LocalDate dataInicio, LocalDate dataFim) {
        this.veiculoAlugado = veiculoAlugado;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Métodos para iniciar e finalizar locação
}
