package br.com.fiap.checkpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.checkpoint.model.Cliente;
import br.com.fiap.checkpoint.model.Locacao;
import br.com.fiap.checkpoint.model.Veiculo;

public class Main {
    public static void main(String[] args) {
        Locacao l = new Locacao();

        // Chama o menu
        l.MostrarMenu();
    }
}
