package Oficina.Modelo;

//classe que representa o modelo do veículo(ex: corolla, civic)
//possui associação unidirecional com marca e composição com motor
public class Modelo {
    private int id;
    private String descricao; //nome/descrição do modelo
    private Marca marca; //associação unidirecional (modelo -> marca)
    private ECategoria categoria; //categoria do modelo (enum)
    private Motor motor; //COMPOSIÇÃO: modelo é o todo, motor é a parte

    //construtor padrão - já cria o motor (composição)
    public Modelo() {
        this.motor = new Motor(); //motor nasce junto com o modelo
    }

    //construtor com descrição e marca - também cria o motor
    public Modelo(String descricao, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
        this.motor = new Motor(); //composição garantida
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public ECategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ECategoria categoria) {
        this.categoria = categoria;
    }

    public Motor getMotor() {
        return motor;
    }

    //não há setMotor() para manter a composição - o motor só pode ser acessado/modificado, nunca substituído
}
