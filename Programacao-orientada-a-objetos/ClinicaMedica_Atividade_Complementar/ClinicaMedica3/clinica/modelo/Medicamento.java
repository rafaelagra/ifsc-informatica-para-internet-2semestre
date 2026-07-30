package clinica.modelo;

// Classe simples que representa um medicamento, com nome e fabricante
public class Medicamento {
    private String nome; // Nome comercial ou princípio ativo
    private String fabricante; // Nome da empresa que fabrica

    // Construtor: recebe ambos os dados obrigatoriamente
    public Medicamento(String nome, String fabricante) {
        this.nome = nome;
        this.fabricante = fabricante;
    }

    //getter s e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
}
