package clinica.modelo;

//classe que representa um endereço
//tem ASSOCIAÇÃO com cidade
public class Endereco {

    //atributos privados (ENCAPSULAMENTO)
    private String rua; //nome da rua/avenida
    private String complemento; //apartamento, casa, bloco (opcional)
    private Cidade cidade; //associação: endereço tem uma cidade

    //construtor
    public Endereco(String rua, String complemento, Cidade cidade) {
        this.rua = rua;
        this.complemento = complemento;
        this.cidade = cidade; //guarda a referência da cidade
    }

    //getters
    public String getRua() {
        return rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    //setters
    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
