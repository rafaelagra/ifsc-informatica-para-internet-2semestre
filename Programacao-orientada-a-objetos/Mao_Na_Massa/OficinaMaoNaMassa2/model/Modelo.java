package model;

/**
 * Classe que representa o modelo do veículo (ex: Corolla, Civic, Biz)
 * Possui associação unidirecional com Marca e composição com Motor.
 * A composição significa: quando um Modelo é criado, seu Motor já é criado junto.
 */
public class Modelo {
    private int id;
    private String descricao;       // nome/descrição do modelo
    private Marca marca;            // associação unidirecional (Modelo → Marca)
    private ECategoria categoria;   // categoria do veículo (enum)
    private Motor motor;            // COMPOSIÇÃO: Modelo contém Motor

    // Construtor padrão – cria o Motor automaticamente (composição)
    public Modelo() {
        this.motor = new Motor();   // Motor nasce junto com o Modelo
    }

    // Construtor com descrição e marca – também cria o Motor
    public Modelo(String descricao, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
        this.motor = new Motor();   // composição garantida
    }

    // Getters e Setters (não há setMotor para manter a composição)
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