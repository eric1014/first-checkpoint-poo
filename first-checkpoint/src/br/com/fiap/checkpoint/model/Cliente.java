package br.com.fiap.checkpoint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private Veiculo veiculoAlugado;
    static List<Cliente> listaClientes = new ArrayList();

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void cadastroCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        // Laço para validar se o cpf possui 11 digitos e apenas numeros
        String cpf;
        do {
            System.out.println("Digite o CPF do cliente: ");
            cpf = scanner.nextLine();

            if (!validarCPF(cpf)) {
                System.out.println("CPF inválido! Digite novamente.");
            }
        } while (!validarCPF(cpf));

        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf, endereco, telefone);
        listaClientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private boolean validarCPF(String cpf) {
        // Verifica se o CPF possui exatamente 11 dígitos numéricos
        if (cpf.matches("\\d{11}")) {
            return true;
        } else {
            return false;
        }
    }

    public static Cliente buscarClientePorCPF(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente; // Retorna o cliente encontrado
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    public static void listarClientesCadastrados() {
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : listaClientes) {
            System.out.println("----------------------------------");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("----------------------------------");
        }
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

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Veiculo getVeiculoAlugado() {
        return veiculoAlugado;
    }

    public void setVeiculoAlugado(Veiculo veiculoAlugado) {
        this.veiculoAlugado = veiculoAlugado;
    }
    // Outros métodos conforme necessário
}
