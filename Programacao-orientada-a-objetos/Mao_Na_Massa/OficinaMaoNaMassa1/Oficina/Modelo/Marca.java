package Oficina.Modelo;

//representa marca/fabricante do veículo
//Ex: toyota, honda, ford
public class Marca {
    //atributos privados (encapsulamento)
    private int id; //identificador único
    private String nome; //nome da marca

    //construtor padrão (sem parâmetros)
    public Marca() {

    }

    //construtor sobrecarregado que ja recebe o nome
    public Marca(String nome) {
        this.nome = nome;
    }

    //getters e setters (acesso controlado)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
