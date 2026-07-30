package clinica.modelo;

//classe que representa um paciente
//COMPOSIÇÃO: paciente "tem um" endereço(o endereço é criado dentro do paciente)
public class Paciente {

    //atributos privados (ENCAPSULAMENTO)
    private String nome; //nome do paciente
    private String cpf; //CPF do paciente
    private Endereco endereco; //associação: paciente tem um endereço

    //construtor - COMPOSIÇÃO ACONTECE AQUI
    //o endereço não é recebido de fora, ele é criado dentro do paciente
    //se o paciente morrer, o endereço também morre
    public Paciente(String nome, String cpf, String ruaEndereco, Cidade cidade) {
        this.nome = nome;
        this.cpf = cpf;
        //COMPOSIÇÃO: criei o endereço aqui dentro
        //o complemento fica vazio ("") pois não foi passado
        this.endereco = new Endereco(ruaEndereco,"",cidade);
    }

    //construtor alternativo - para quando tiver complemento
    //permite criar paciente com complemento no endereço
    public Paciente(String nome, String cpf, String ruaEndereco, String complemento, Cidade cidade) {
        this.nome = nome;
        this.cpf = cpf;
        //COMPOSIÇÃO: cria-se o endereço aqui dentro com complemento
        this.endereco = new Endereco(ruaEndereco, complemento, cidade);
    }

    //getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
