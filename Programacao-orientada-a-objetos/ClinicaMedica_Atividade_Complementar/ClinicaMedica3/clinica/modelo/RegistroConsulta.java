package clinica.modelo;

import java.util.ArrayList;
import java.util.List;

// Representa um registro de uma consulta já realizada.
// Contém uma descrição do atendimento e a lista de medicamentos prescritos
public class RegistroConsulta {
    private String descricao; //descrição do atendimento
    private Consulta consulta; //referência á consulta
    private List<HistoricoMedicacao> medicacoesIndicadas; //lista de medicamentos prescritos

    // Construtor: recebe a consulta e a descrição. Inicializa a lista de medicamentos vazia
    public RegistroConsulta(Consulta consulta, String descricao) {
        this.consulta = consulta;
        this.descricao = descricao;
        this.medicacoesIndicadas = new ArrayList<>();
    }

    // Método principal para adicionar um medicamento ao registro.
    // Lançei uma exceção personalizada se o medicamento for nulo
    public void adicionarMedicamento(Medicamento medicamento) throws MedicamentoIndicadoException {
        if (medicamento == null) {
            throw new MedicamentoIndicadoException("Medicamento não pode ser nulo.");
        }
        // Cria um objeto HistoricoMedicacao que guarda a relação entre este registro, o medicamento
        // e uma descrição automática ("Prescrição: nomeDoMedicamento")
        HistoricoMedicacao historico = new HistoricoMedicacao(this, medicamento, "Prescrição: " + medicamento.getNome());
        medicacoesIndicadas.add(historico);
        // Também adiciono este histórico diretamente ao paciente, para manter seu prontuário
        consulta.getPaciente().adicionarHistoricoMedicacao(historico);
    }

    //getters e setters
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Consulta getConsulta() { return consulta; }
    public List<HistoricoMedicacao> getMedicacoesIndicadas() { return medicacoesIndicadas; }
}
