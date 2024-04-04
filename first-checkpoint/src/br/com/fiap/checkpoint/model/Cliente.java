package br.com.fiap.checkpoint.model;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private Veiculo veiculoAlugado;

    public Cliente(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void alugarVeiculo(Veiculo veiculo) {
        if (veiculo.verificarDisponibilidade()) {
            veiculo.definirDisponibilidade(false);
            this.veiculoAlugado = veiculo;
        } else {
            System.out.println("Veículo não disponível para locação.");
        }
    }

    public void devolverVeiculo() {
        this.veiculoAlugado.definirDisponibilidade(true);
        this.veiculoAlugado = null;
    }

    // Outros métodos conforme necessário
}

