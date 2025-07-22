package SistemaLivraria;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.inicializar();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nDeseja ver os livros disponíveis? (sim/nao)");
            String resposta = scanner.nextLine().toLowerCase();

            switch (resposta) {
                case "sim" -> {
                    biblioteca.listarLivrosDisponiveis();
                    System.out.println("\nDigite o ID do livro que deseja emprestar:");
                    int idLivro = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite seu nome:");
                    String nomeUsuario = scanner.nextLine();
                    biblioteca.emprestarLivro(idLivro, nomeUsuario);
                }
                case "nao" -> {
                    continuar = false;
                    System.out.println("Aplicação finalizada. Volte sempre!");
                }
                default -> System.out.println("Resposta inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
