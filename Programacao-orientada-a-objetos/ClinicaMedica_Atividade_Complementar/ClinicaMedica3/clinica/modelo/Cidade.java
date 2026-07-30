package clinica.modelo;

//eu defini a classe cidade para representar uma cidade onde um paciente pode morar
//ela é usada dentro da classe endereco
public class Cidade {
    //atributos privados (encapsulamento)
    private String nome; //armazena o nome da cidade (ex: "São Paulo").
    private String uf; //Unidade federativa (ex: SP, RJ)

    //construtor: recebe o nome e a UF da cidade
    //quando alguém cria um objeto cidade, será obrigado a fornecer esses dois dados
    public Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    //getters e setters

    // Getter para o nome: permite que outras classes leiam o nome da cidade
    public String getNome() { return nome; }

    // Setter para o nome: permite modificar o nome da cidade depois que o objeto foi criado
    public void setNome(String nome) { this.nome = nome; }

    // Getter para a UF: retorna a sigla do estado
    public String getUf() { return uf; }

    // Setter para a UF: altera a sigla do estado
    public void setUf(String uf) { this.uf = uf; }
}
