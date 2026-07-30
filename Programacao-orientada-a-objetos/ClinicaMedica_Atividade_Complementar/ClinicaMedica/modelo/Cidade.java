package clinica.modelo;

//classe que representa uma cidade
//faz parte da composição com endereço
public class Cidade {

    //atributos privados (ENCAPSULAMENTO) (ninguém de fora acessa diretamente)
    private String nome; // Nome da cidade: "São Paulo", "Rio de Janeiro"
    private String uf; // Sigla do estado: "SP", "RJ", "SC"

    //construtor - método que cria o objeto
    public Cidade(String nome, String uf) {
        this.nome = nome;  //this.nome é o atributo, nome é o parâmetro
        this.uf = uf;
    }

    //getters - permitem VER os valores (leitura)
    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    //setters - permitem ALTERAR os valores (escrita)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
