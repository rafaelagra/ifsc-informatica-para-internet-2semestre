package model;

/*
* classe que representa a fabricante do veículo
* exemplo: toyota, honda, fiat
* atributos privados com encapsulamento (getters/ setters)
* */
public class Marca {
    private int id; //identificador único
    private String nome; //nome da marca

    //construtor padrão
    public Marca() {}

    //construtor sobrecarregado já com nome
    public Marca(String nome) {
        this.nome = nome;
    }

    //getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}