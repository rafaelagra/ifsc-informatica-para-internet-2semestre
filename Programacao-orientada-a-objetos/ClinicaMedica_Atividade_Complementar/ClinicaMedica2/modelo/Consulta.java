package clinica.modelo;

public class Consulta {
    private String data;
    private String horario;
    private Prioridade prioridade;
    private Medico medico;
    private Paciente paciente;

    //construtor 1: sem prioridade(usar valor padrão? vou colocar MEDIA)
    public Consulta(String data, String horario) {
      this.data = data;
      this.horario = horario;
      this.prioridade = Prioridade.MEDIA; // padrão
    }

    //construtor 2: com prioridade (sobrecarga)
    public Consulta(String data, String horario, Prioridade prioridade) {
        this.data = data;
        this.horario = horario;
        this.prioridade = prioridade;
    }

    //getters e setters
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public Prioridade getPrioridade() { return prioridade; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    //método para exibir as informações da consulta
    public void exibirConsulta() {
        System.out.println("Consulta: " + data + " às " + horario + " | Prioridade: " + prioridade);
        if(medico != null && paciente != null) {
            System.out.println(" Médico: " + medico.getNome());
            System.out.println(" Paciente: " + paciente.getNome());
        }
    }
}
