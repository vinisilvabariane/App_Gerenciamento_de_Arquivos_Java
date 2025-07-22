package SistemaLivraria;

import java.time.LocalDate;

public class Emprestimo {
    private String nomeDeUsuario;
    private String livro;
    private LocalDate dataDeEmprestimo;

    public Emprestimo(String nomeDeUsuario, String livro){
        this.nomeDeUsuario = nomeDeUsuario;
        this.livro = livro;
        this.dataDeEmprestimo = LocalDate.now();
    }

    @Override
    public String toString(){
        return String.format("O usuário %s pegou o livro $s no dia %s", nomeDeUsuario, livro.toString(), dataDeEmprestimo);
    }
}
