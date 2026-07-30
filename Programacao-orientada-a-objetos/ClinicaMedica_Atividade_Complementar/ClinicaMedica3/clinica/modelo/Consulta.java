package clinica.modelo;

// Classe principal que representa uma consulta médica.
// Liga médico, paciente e prioridade, e depois pode gerar um RegistroConsulta
public class Consulta {
    private String dataConsulta; // Data no formato "dd/MM/yyyy"
    private String horario; // Horário "HH:mm"
    private Medico medico; // Médico responsável
    private Paciente paciente; // Paciente atendido
    private Prioridade prioridade; // Prioridade da consulta (ALTA, MEDIA, BAIXA)
    private RegistroConsulta registroConsulta; // Opcional: só é criado quando a consulta é realizada

    //construtor conforme o diagrama: recebe todos os dados
    public Consulta(String dataConsulta, String horario, Medico medico, Paciente paciente, Prioridade prioridade) {
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.prioridade = prioridade;
        //o registro de consulta será criado depois (quando a consulta for realizada)
    }

    // Método que "realiza" a consulta: cria um RegistroConsulta com a descrição fornecida
    public void realizarConsulta (String descricaoRegistro) {
        this.registroConsulta = new RegistroConsulta(this, descricaoRegistro);
        System.out.println("Consulta realizada. Registro criado.");
    }

    public String getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(String dataConsulta) { this.dataConsulta = dataConsulta; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Prioridade getPrioridade() { return prioridade; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
    public RegistroConsulta getRegistroConsulta() { return registroConsulta; }

    //método auxiliar para exibir informações da consulta
    public void exibirConsulta() {
        System.out.println("Consulta: " + dataConsulta + " às " + horario + " | Prioridade: " + prioridade);
        if(medico !=null && paciente != null) {
            System.out.println( " Médico: " + medico.getNome());
            System.out.println(" Paciente: " + paciente.getNome());
        }
        if (registroConsulta != null) {
            System.out.println(" Registro: " + registroConsulta.getDescricao());
        }
    }
}
