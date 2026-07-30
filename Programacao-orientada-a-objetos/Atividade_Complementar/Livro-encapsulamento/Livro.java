package model;

//classe que representa um livro
public class Livro {
    //atributos privados (encapsulamento)
    private int id;
    private String titulo;
    private String isbn;
    private String autor;
    private String editora;
    private float precoCusto;
    private float precoVenda;
    private float margemLucro;

    // ===== GETTERS e SETTERS =====

    //método para pegar o id
    public int getId() {
        return id;
    }

    //método para definir o id
    public void setId(int id) {
        this.id = id;
    }

    //método para pegar o título
    public String getTitulo() {
        return titulo;
    }

    //método para definir o titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //método para pegar o ISBN
    public String getIsbn() {
        return isbn;
    }

    //método para definir o ISBN
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //método para pegar o autor
    public String getAutor() {
        return autor;
    }

    //método para definir o autor
    public void setAutor(String autor) {
        this.autor = autor;
    }

    //método para pegar a editora
    public String getEditora() {
        return editora;
    }

    //método para definir a editora
    public void setEditora(String editora) {
        this.editora = editora;
    }

    //método para pegar o preço de custo
    public float getPrecoCusto() {
        return precoCusto;
    }

    //método para definir o preço de custo
    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    //método para pegar a margem de lucro
    public float getMargemLucro() {
        return margemLucro;
    }

    //método para definir margem de lucro
    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    // ===== REGRA DE NEGÓCIO =====

    //método que calcula o preço da venda
    public float calcularPrecoVenda() {
        return precoCusto + (precoCusto * margemLucro);
    }

    // ===== GET DO PREÇO DE VENDA =====

    //não existe setPrecoVenda()
    public float getPrecoVenda() {
        //retorna o valor calculado, não armazenado
        return calcularPrecoVenda();

    }
}
