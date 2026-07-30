package clinica.modelo;

// Esta é uma classe abstrata. Eu a criei para servir como base (superclasse) para Medico e Paciente
// Não posso instanciar "Pessoa" diretamente, mas posso usar seus atributos e métodos nas subclasses
public abstract class Pessoa {
    private String nome; // Atributo comum a qualquer pessoa: nome
    private String cpf; // Atributo comum: CPF

    // Construtor da classe Pessoa. Toda subclasse deve chamar este construtor através de 'super()'
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    //getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    // Método abstrato: não tem corpo aqui
    // Quem herdar (Medico, Paciente) é OBRIGADO a implementar este método com suas próprias regras
    public abstract void exibirInformacoes();
}
