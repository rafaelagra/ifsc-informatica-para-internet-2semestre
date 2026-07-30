package model;

import model.Livro;

public class Main {
    public static void main(String[] args) {

        //criei um objeto da classe livro
        Livro livro = new Livro();

        //defini os valores usando os setters
        livro.setId(1);
        livro.setTitulo("POO CTII IFSC 2026");
        livro.setIsbn("123456789");
        livro.setAutor("Rafael Agra");
        livro.setEditora("Tech Books");

        //defini o preço de custo
        livro.setPrecoCusto(100);

        //defini a margem de lucro de 50 % (0.5)
        livro.setMargemLucro(0.5f);

        //exibindo informações do livro
        System.out.println("ID: " + livro.getId());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Editora: " + livro.getEditora());

        //o preço de venda aqui é calculado automaticamente
        System.out.println("Preço de venda: " + livro.getPrecoVenda());
    }
}
