package clinica.modelo;

public class Endereco {
    private String rua;
    private String complemento;
    private Cidade cidade; //endereco "tem uma" cidade

    //construtor
    public Endereco(String rua, String complemento, Cidade cidade) {
        this.rua = rua;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    //construtor simplificado (sem complemento)
    public Endereco(String rua, Cidade cidade) {
        this(rua, "", cidade); //chama o construtor de cima com complemento vazio
    }

    //getters e setters
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }

}
