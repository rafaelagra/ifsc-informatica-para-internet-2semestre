package clinica.modelo;

import java.util.ArrayList;
import java.util.List;

// Classe Medico: herda de Pessoa (ganha nome e CPF) e também implementa a interface Agendavel
// Isso significa que um médico pode ser tratado como Pessoa e também como Agendavel
public class Medico extends Pessoa implements Agendavel {
    private String especialidade; // Área de atuação: Cardiologia, Dermatologia, etc
    private String crm; // Número do registro no Conselho Regional de Medicina
    private List<Consulta> consultas; // Lista que armazena todas as consultas deste médico

    // Construtor: chamo o construtor da superclasse (Pessoa) passando nome e CPF,
    // depois inicializo os atributos específicos do médico e a lista de consultas (vazia no início)
    public Medico(String nome, String cpf, String especialidade, String crm) {
        super(nome, cpf); // Chama Pessoa(nome, cpf)
        this.especialidade = especialidade;
        this.crm = crm;
        this.consultas = new ArrayList<>();
    }

    // Método público para adicionar uma consulta à lista do médico
    // Também faz a ligação bidirecional: chama consulta.setMedico(this) para que a consulta conheça este médico
    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
        consulta.setMedico(this); // Mantém a consistência do relacionamento
    }

    // Implementação obrigatória do método da interface Agendavel
    // Ao agendar, eu simplesmente delego para o método adicionarConsulta e mostro uma mensagem
    @Override
    public void agendarConsulta(Consulta consulta) {
        adicionarConsulta(consulta);
        System.out.println("Médico " + getNome() + " agendou a consulta.");
    }

    // Implementação do método abstrato de Pessoa
    // Aqui eu defino como as informações do médico devem ser exibidas
    @Override
    public void exibirInformacoes() {
        System.out.println("Médico: " + getNome() + " | CPF: " + getCpf());
        System.out.println("  Especialidade: " + especialidade);
        System.out.println("  CRM: " + crm);
    }

    // Método auxiliar para listar todas as consultas do médico
    public void listarConsultas() {
        System.out.println("Consultas do Dr(a). " + getNome() + ":");
        for (Consulta c : consultas) {
            System.out.println("  - " + c.getDataConsulta() + " às " + c.getHorario());
        }
    }

    // Getters e setters
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {   // ← parâmetro adicionado
        this.crm = crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}