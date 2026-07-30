package clinica.modelo;

// Classe que representa um item do histórico de medicação de um paciente.
// Relaciona um registro de consulta, um medicamento e uma descrição (motivo/detalhe)
public class HistoricoMedicacao {
    private String descricao;
    private RegistroConsulta registroConsulta;
    private Medicamento medicamento;

    //construtor conforme o diagrama
    public HistoricoMedicacao(RegistroConsulta registroConsulta, Medicamento medicamento, String descricao) {
        this.registroConsulta = registroConsulta;
        this.medicamento = medicamento;
        this.descricao = descricao;
    }

    //getters e setters
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public RegistroConsulta getRegistroConsulta() { return registroConsulta; }
    public Medicamento getMedicamento() { return medicamento; }
}
