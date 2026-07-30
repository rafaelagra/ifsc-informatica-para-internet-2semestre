package clinica.modelo;

import java.util.ArrayList;
import java.util.List;
public class Medico extends Pessoa implements Agendavel {
    //atributos exclusivos do médico
    private String especialidade;
    private String crm;
    private List<Consulta> consultas; //lista de consultas do médico

    //Construtor
    public Medico(String nome, String cpf, String especialidade, String crm) {
        super(nome, cpf); //chama o construtor da classe mãe (pessoa)
        this.especialidade = especialidade;
        this.crm = crm;
        this.consultas = new ArrayList<>();
    }

    //implementação obrigatória do método abstrato da classe Pessoa
    @Override
    public void exibirInformacoes() {
        System.out.println("Médico: " + getNome() + " | CPF: " + getCpf());
        System.out.println(" Especialidade: " + especialidade);
        System.out.println(" CRM: " + crm);
    }

    //implementação obrigatória do método da interface agendavel
    @Override
    public void agendarConsulta(Consulta consulta) {
        //adiciona a consulta na lista do médico
        this.consultas.add(consulta);
        //faz a ligação de volta (bidirecional)
        consulta.setMedico(this);
        System.out.println("Consulta agendada para o médico " + getNome());
    }

    //método para listar as consultas (opcional, útil para teste)
    public void listarConsultas() {
        System.out.println("Consultas do Dr(a). " + getNome() + ":");
        for (Consulta c : consultas) {
            System.out.println(" - " + c.getData() + " às " + c.getHorario());
        }
    }

    //getters e setters
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }
    public List<Consulta> getConsultas() { return consultas; }
}
