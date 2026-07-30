package clinica.modelo;

// Classe que representa o endereço de uma pessoa, especialmente do paciente.
// Ela está associada a uma Cidade (composição fraca / agregação)
public class Endereco {
    private String rua; // Nome da rua, avenida, etc.
    private String complemento; // Informação adicional: apartamento, bloco, etc
    private Cidade cidade; // Referência para o objeto Cidade onde este endereço está localizado

    // Primeiro construtor: usado quando NÃO tem complemento
    //construtor conforme o diagrama: recebe rua e cidade (complemento fica vazio)
    public Endereco(String rua, Cidade cidade) {
        this.rua = rua;
        this.cidade = cidade;
        this.complemento = ""; //padrão vazio, pois o complemento é opcional
    }

    // Segundo construtor: usado quando tem um complemento
    //construtor adicional para quando tiver complemento
    public Endereco(String rua, String complemento, Cidade cidade) {
        this.rua = rua;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    //getters e setters
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public Cidade getCidade() { return cidade; }
    public void setCidade (Cidade cidade) { this.cidade = cidade; } // (permite trocar a cidade do endereço)
}
