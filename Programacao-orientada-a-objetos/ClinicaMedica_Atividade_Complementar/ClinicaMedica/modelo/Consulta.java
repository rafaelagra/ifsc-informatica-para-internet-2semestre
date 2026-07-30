package clinica.modelo;

//classe que representa uma consulta médica
//essa classe tem ASSOCIAÇÕES BIDIRECIONAIS com médico e paciente
public class Consulta {

    //atributos privados (ENCAPSULAMENTO)
    private String dataConsulta; //data da consulta. EX: "08/04/2026"
    private String horario; // horário: "14:30"
    private Medico medico; // ASSOCIAÇÃO BIDIRECIONAL: qual médico vai atender
    private Paciente paciente; // ASSOCIAÇÃO: qual paciente vai ser atendido
    private Prioridade prioridade; //ENUM: ALTA, MEDIA, BAIXA
    private StatusConsulta status; // ENUM: AGENDADA, REALIZADA ou CANCELADA

    //construtor
    public Consulta(String dataConsulta, String horario, Medico medico, Paciente paciente, Prioridade prioridade) {
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.prioridade = prioridade; //define a prioridade da consulta
        this.status = StatusConsulta.AGENDADA; //toda nova consulta começa como AGENDADA
    }

    //métodos específicos para o status da consulta
    public void realizarConsulta() {
        this.status = StatusConsulta.REALIZADA; //muda para REALIZADA
    }

    public void cancelarConsulta() {
        this.status = StatusConsulta.CANCELADA; //muda para CANCELADA
    }

    //getters e setters
    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Medico getMedico() {
        return medico;
    }

    //método setMedico - usado para manter a BIDIRECIONALIDADE
    //é chamado por Medico.adicionarConsulta()
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}
