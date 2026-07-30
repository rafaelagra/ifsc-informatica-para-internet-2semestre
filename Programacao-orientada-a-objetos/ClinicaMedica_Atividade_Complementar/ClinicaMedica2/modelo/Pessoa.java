package clinica.modelo;

//abstract = esta classe não pode ser instanciada (não pode fazer new Pessoa())
public abstract class Pessoa {
    //atributos comuns a todas as pessoas
    private String nome;
    private String cpf;

    //construtor da classe abstrata (será chamado pelas classes filhas)
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    //método concreto (já implementado)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    //método abstrato: não tem corpo (sem { } )
    //quem herdar vai ser OBRIGADO a implementar este método
    public abstract void exibirInformacoes();
}
