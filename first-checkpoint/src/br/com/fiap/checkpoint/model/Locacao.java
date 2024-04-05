package br.com.fiap.checkpoint.model;

import java.time.LocalDate;
import java.util.Scanner;

public class Locacao {
    private Veiculo veiculoAlugado;
    private Cliente cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    // Ctor vazio
    public Locacao() {
    }

    // Ctor para fazer a locação de um veículo(através da placa) a um cliente(através do CPF)
    public Locacao(String cpfCliente, String placaVeiculo) {

        // Faz as buscas do cliente e do veiculo informado
        Cliente cliente = Cliente.buscarClientePorCPF(cpfCliente);
        Veiculo veiculo = Veiculo.buscarVeiculoPorPlaca(placaVeiculo);

        // Se a busca retornar algum cliente e algum veiculo
        if (cliente != null && veiculo != null) {
            this.cliente = cliente;
            this.veiculoAlugado = veiculo;
            this.dataInicio = LocalDate.now();

            // Pede ao operador o período em que o veículo vai ser alugado
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o número de dias para a locação: ");
            int numDias = scanner.nextInt();

            this.dataFim = this.dataInicio.plusDays(numDias);

            iniciarLocacao();
        } else {
            System.out.println("Cliente ou veículo não encontrado!");
        }
    }

    // Método que faz a verificação da disponibilidade do veículo e se o cliente já possui  outra locação ativa
    // Caso esteja tudo certo, define a disponibilidade do veiculo para FALSE e cadastra no cliente um veículo alugado
    private void iniciarLocacao() {
        if (veiculoAlugado.verificarDisponibilidade() && cliente.getVeiculoAlugado() == null) {
            veiculoAlugado.setClienteAlugando(cliente);
            veiculoAlugado.definirDisponibilidade(false);
            cliente.setVeiculoAlugado(veiculoAlugado);

            // Imprime as informações da locação
            System.out.println("Veículo alugado com sucesso!");
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Veículo: " + veiculoAlugado.getModelo());
            System.out.println("Data de início: " + dataInicio);
            System.out.println("Data de término: " + dataFim);
        } else {
            System.out.println("Veículo não disponível para locação ou cliente já está alugando um veículo.");
        }
    }

    // Menu do programa
    public void MostrarMenu() {
        Cliente cliente = new Cliente();
        Veiculo veiculo = new Veiculo();
        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("##--Locadora FIAP--##\n");
            System.out.println("|-----------------------------|");
            System.out.println("| Opção 1 - Cadastro Cliente  |");
            System.out.println("| Opção 2 - Cadastro Veiculo  |");
            System.out.println("| Opção 3 - Listar Veiculos   |");
            System.out.println("| Opção 4 - Listar Clientes   |");
            System.out.println("| Opção 5 - Iniciar Locação   |");
            System.out.println("| Opção 0 - Sair              |");
            System.out.println("|-----------------------------|");
            System.out.print("Digite uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    limparConsole();
                    cliente.cadastroCliente();
                    break;
                case 2:
                    limparConsole();
                    veiculo.cadastroVeiculo();
                    break;
                case 3:
                    limparConsole();
                    veiculo.exibirVeiculosCadastrados();
                    break;
                case 4:
                    limparConsole();
                    cliente.listarClientesCadastrados();
                    break;
                case 5:
                    limparConsole();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    System.out.print("Digite a placa do veículo: ");
                    String placaVeiculo = scanner.nextLine();
                    new Locacao(cpfCliente, placaVeiculo);
                    break;
                case 0:
                    System.out.println("\nSaindo do sistema...");
                    break;
                default:
                    System.out.println("\nOpção Inválida! Por favor, tente novamente.\n");
                    break;
            }

            if (opcao != 0) {
                System.out.println("\nPressione Enter para voltar ao menu...");
                scanner.nextLine();
                limparConsole();
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void limparConsole() {
        System.out.print("\033[H\033[2J"); // Limpa o console
        System.out.flush();
    }
}
