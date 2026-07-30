package model;

/*
* essa classe representa a fabricante (marca) de um veículo
* EX: toyota, honda, fiat
* aqui estou definindo os atributos e métodos básicos
* */
public class Marca {
    //atributo privado para guardar o identificador único da marca
    private int id;
    //atributo privado para guardar o nome da marca
    private String nome;

    //construtor padrão (sem parâmetros) - permite criar uma marca vazia
    public Marca() {
        //não faço nada aqui, os atributos ficam com valores padrão (0 e null)
    }

    //construtor sobrecarregado: já recebe o nome da marca
    public Marca(String nome) {
        //uso 'this' para me referir ao atributo da classe, e 'nome' é o parâmetro
        this.nome = nome;
    }

    //getter para id - permite que outras classes leiam o id
    public int getId() { return id; }

    //setter para id - permite que outras classes definam o id
    public void setId(int id) { this.id = id; }

    //getter para nome
    public String getNome() { return nome; }

    //setter para nome
    public void setNome(String nome) { this.nome = nome; }
}
