package SistemaLivraria;

import java.time.LocalDate;

public class Autor {
    private int id;
    private String nome;
    private LocalDate dataDeNascimento;

    public Autor(int id, String nome, LocalDate dataDeNascimento){
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome(){
        return nome;
    }
}
