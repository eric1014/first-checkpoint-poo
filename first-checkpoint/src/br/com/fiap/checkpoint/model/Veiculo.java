package br.com.fiap.checkpoint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private boolean disponibilidade;
    private Cliente clienteAlugando;
    static List<Veiculo> listaVeiculos = new ArrayList();

    public Veiculo() {
    }

    public Veiculo(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.disponibilidade = true;
        this.clienteAlugando = null;
    }

    public void cadastroVeiculo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a marca do veículo: ");
        marca = scanner.nextLine();

        System.out.println("Digite o modelo do veículo: ");
        modelo = scanner.nextLine();

        System.out.println("Digite o ano do veículo: ");
        ano = scanner.nextInt();
        scanner.nextLine();

        String placa;
        do {
            System.out.println("Digite a placa do veículo (formato XXX1234): ");
            placa = scanner.nextLine();

            if (placa.length() != 7) {
                System.out.println("Placa inválida! A placa deve conter exatamente 7 caracteres.");
            }
        } while (placa.length() != 7);

        Veiculo veiculo = new Veiculo(marca, modelo, ano, placa);
        listaVeiculos.add(veiculo);

        System.out.println("O veículo foi cadastrado com sucesso!");
    }

    public static List<Veiculo> buscarTodosOsVeiculos() {
        return listaVeiculos;
    }

    public static void exibirVeiculosCadastrados() {
        System.out.println("Veículos cadastrados:");
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println("----------------------------------");
            System.out.println("Marca: " + veiculo.getMarca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Ano: " + veiculo.getAno());
            System.out.println("Placa: " + veiculo.getPlaca());
            System.out.println("----------------------------------");
        }
    }

    public static Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa.toUpperCase())) {
                return veiculo;
            }
        }
        return null; // Retorna null se o veículo não for encontrado
    }

    public boolean verificarDisponibilidade() {
        return disponibilidade;
    }

    public void definirDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // Getters e Setters
    public Cliente getClienteAlugando() {
        return clienteAlugando;
    }

    public void setClienteAlugando(Cliente cliente) {
        this.clienteAlugando = cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Podemos adicionar outros metodos
}
