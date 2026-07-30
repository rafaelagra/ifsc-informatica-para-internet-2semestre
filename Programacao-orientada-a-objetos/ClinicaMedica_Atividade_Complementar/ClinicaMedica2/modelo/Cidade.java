package clinica.modelo;

public class Cidade {
    //atributos privados = só podem ser acessados por métodos desta classe
    private String nome;
    private String uf;

    //construtor : o método que "cria" o objeto
    public Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    //getters (para ler os valores)
    public String getNome() { return nome; }
    public void setNome(String nome ) {this.nome = nome; }

    //setters (para modificar os valores)
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
}
