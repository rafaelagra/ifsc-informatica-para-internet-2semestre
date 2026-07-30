package clinica.modelo;

import java.util.ArrayList;
import java.util.List;

// Paciente herda de Pessoa e implementa Agendavel
public class Paciente extends Pessoa implements Agendavel {
    private String contato; //telefone ou email
    private Endereco endereco; //composição
    private List<Consulta> consultas; //lista de consultas do paciente
    private List<HistoricoMedicacao> historicoMedicacoes; //histórico de medicamentos

    // Construtor principal, conforme o diagrama: recebe nome, CPF, rua (já como string) e cidade
    // Aqui eu mesmo crio o objeto Endereco dentro do paciente, caracterizando a composição
    public Paciente(String nome, String cpf, String rua, Cidade cidade) {
        super(nome, cpf);
        this.endereco = new Endereco(rua, cidade); //composição: cria endereço dentro do paciente
        this.consultas = new ArrayList<>();
        this.historicoMedicacoes = new ArrayList<>();
    }

    // Construtor adicional que também aceita um contato (telefone/e-mail)
    // Ele reaproveita o construtor principal com 'this' e depois seta o contato
    public Paciente(String nome, String cpf, String contato, String rua, Cidade cidade) {
        this(nome, cpf, rua, cidade);
        this.contato = contato;
    }

    // Implementação do método da interface Agendavel.
    // Aqui eu adiciono a consulta à lista do paciente e estabeleço a ligação de volta
    // (a consulta passa a conhecer este paciente via setPaciente)
    @Override
    public void agendarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
        consulta.setPaciente(this);
        System.out.println("Paciente " + getNome() + " agendou a consulta.");
    }

    // Implementação do método abstrato de Pessoa.
    // Exibe nome, CPF, contato (se existir) e o endereço completo (rua, cidade/UF)
    @Override
    public void exibirInformacoes() {
        System.out.println("Paciente: " + getNome() + " | CPF: " + getCpf());
        System.out.println( " Contato: " + (contato != null ? contato : " não informado"));
        System.out.println("  Endereço: " + endereco.getRua() + ", " + endereco.getCidade().getNome() + "/" + endereco.getCidade().getUf());
    }

    // Método público para adicionar um registro ao histórico de medicamentos do paciente.
    // Esse método é chamado por RegistroConsulta.adicionarMedicamento()
    public void adicionarHistoricoMedicacao(HistoricoMedicacao historico) {
        this.historicoMedicacoes.add(historico);
    }

    // Método auxiliar para exibir todo o histórico de medicamentos prescritos
    public void exibirHistoricoMedicamentos() {
        System.out.println("Histórico de medicamentos do paciente " + getNome() + ":");
        for (HistoricoMedicacao h : historicoMedicacoes) {
            System.out.println(" - " + h.getDescricao());
        }
    }

    //getters e setters
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
    public Endereco getEndereco() { return endereco; }
    public List<Consulta> getConsultas() { return consultas; }
    public List<HistoricoMedicacao> getHistoricoMedicacoes() { return historicoMedicacoes; }
}
