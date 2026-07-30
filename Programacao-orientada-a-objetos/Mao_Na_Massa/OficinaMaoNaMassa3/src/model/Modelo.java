package model;

import enums.ECategoria;

/*
* classe que representa o modelo do veículo (ex: corolla, civic, biz)
* possui associação unidirecional com marca e composição com motor
* composição significa: quando um modelo é criado, seu motor já é criado junto
* */
public class Modelo {
    private int id;
    private String descricao; //nome/descrição do modelo
    private Marca marca; //associação unidirecional (modelo -> Marca)
    private ECategoria categoria; //categoria do veículo (enum)
    private Motor motor; //COMPOSIÇÃO: modelo contém motor

    //construtor padrão - já instancia o motor (composição)
    public Modelo() {
        //aqui estou criando um novo motor para este modelo
        this.motor = new Motor(); //motor nasce junto com o modelo
    }

    //construtor com descrição e marca - também cria o motor
    public Modelo(String descricao, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
        this.motor = new Motor(); //composição garantida
    }

    //getters e setters (não há setMotor para manter a composição
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    public ECategoria getCategoria() { return categoria; }
    public void setCategoria(ECategoria categoria) { this.categoria = categoria; }

    public Motor getMotor() { return motor; }
}
