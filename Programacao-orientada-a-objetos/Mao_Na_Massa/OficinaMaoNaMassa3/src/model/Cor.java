package model;

/*
* classe que representa a cor de um veículo
* o id é do tipo long para suportar muitos registros
* */
public class Cor {
    private long id;
    private String nome;

    public Cor() {
    }

    public Cor(String nome) {
        this.nome = nome;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
}
