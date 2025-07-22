package SistemaLivraria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void inicializar() throws IOException {
        Autor autor1 = new Autor(1, "Machado de Assis", LocalDate.of(1939, 6, 21));
        Autor autor2 = new Autor(2, "Clarice Lispector", LocalDate.of(1920, 12, 10));
        autores.addAll(List.of(autor1, autor2));

        livros.add(new Livro(1, "Dom Casmurro", autor1));
        livros.add(new Livro(2, "A Hora da Estrela", autor2));
    }

    public void listarLivrosDisponiveis(){
        System.out.println("\n<---------Livros Disponíveis--------->");
        livros.stream().filter(Livro::getDisponivel).forEach(System.out::println);
    }

    public void emprestarLivro(int idLivro, String nomeUsuario) throws IOException {
        Optional<Livro> livroOptional = livros.stream().filter(l -> l.getId() == idLivro && l.getDisponivel()).findFirst();

        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            livro.setDisponivel(false);
            livro.setDataAtualizacao(LocalDate.now());
            Emprestimo emp = new Emprestimo(nomeUsuario, livro);
            emprestimos.add(emp);
            salvarEmprestimo(emp);
            System.out.println("\nLivro emprestado com sucesso para " + nomeUsuario + ".");
        } else {
            System.out.println("\nLivro não disponível ou não encontrado.");
        }
    }

    private void salvarEmprestimo(Emprestimo emp) throws IOException {
        String linha = emp.toString() + "\n";
        Path path = Paths.get("emprestimos.txt");
        Files.writeString(path, linha, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
