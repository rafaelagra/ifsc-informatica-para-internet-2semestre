package model;

/*
* classe que representa a cor do veículo
* o id é do tipo long conforme diagrama
* */
public class Cor {
    private long id; //identificador (long suporta muitos registros)
    private String nome; //nome da cor (ex: vermelho)

    public Cor() {}
    public Cor(String nome) { this.nome = nome; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}