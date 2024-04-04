package br.com.fiap.checkpoint;

import br.com.fiap.checkpoint.model.Cliente;
import br.com.fiap.checkpoint.model.Veiculo;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Sandero", "Focus", 2020, "ABC1234");
        Cliente cliente = new Cliente("Theo", "123.456.789-00", "Rua A, 123", "9999-9999");

        cliente.alugarVeiculo(veiculo);
        // Realizar outras operações conforme necessário
    }
}
