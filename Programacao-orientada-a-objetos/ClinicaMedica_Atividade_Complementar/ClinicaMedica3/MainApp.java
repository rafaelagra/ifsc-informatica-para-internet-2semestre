// Importo todas as classes do pacote modelo para poder usá-las
import clinica.modelo.*;

// Classe principal que contém o método main e demonstra todo o sistema em ação
public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE AGENDAMENTO E REGISTRO DE CONSULTAS ===\n");

        // Envolvo a execução em um try-catch para capturar a exceção personalizada
        // que pode ser lançada ao adicionar medicamento nulo
        try {
            //1.crio uma cidade (Florianópolis/SC)
            Cidade floripa = new Cidade("Florianópolis", "SC");

            //2. crio um médico com nome, CPF, especialidade e CRM
            Medico medico = new Medico("Dra. Ana", "111.222.333-44", "Cardiologia", "CRM-123");

            //3. // 3. Crio um paciente. Aqui usei o construtor que recebe nome, CPF, rua e cidade
            Paciente paciente = new Paciente("João Silva", "999.888.777-66", "Rua das Flores, 123", floripa);

            //4. Crio uma consulta com data, horário, médico, paciente e prioridade ALTA
            Consulta consulta = new Consulta("20/06/2026", "14:30", medico, paciente, Prioridade.ALTA);

            //5. Demonstração da interface Agendavel: tanto o médico quanto o paciente agendam a consulta
            System.out.println("---AGENDAMENTO---");
            medico.agendarConsulta(consulta);
            paciente.agendarConsulta(consulta);
            System.out.println();

            //6. Realizo a consulta, criando assim um registro com uma descrição
            System.out.println("--- REALIZAÇÃO DA CONSULTA ---");
            consulta.realizarConsulta("Paciente queixa de dor no peito. Exames solicitados.");
            System.out.println();

            //7. Prescrevo dois medicamentos para o paciente, via registro da consulta
            System.out.println("--- PRESCRIÇÃO DE MEDICAMENTOS ---");
            Medicamento med1 = new Medicamento("Losartana", "Novartis");
            Medicamento med2 = new Medicamento("AAS", "Bayer");

            RegistroConsulta registro = consulta.getRegistroConsulta();
            registro.adicionarMedicamento(med1);
            registro.adicionarMedicamento(med2);
            System.out.println();

            //8. Exibo os dados do paciente (incluindo endereço) e seu histórico de medicamentos
            System.out.println("--- DADOS DO PACIENTE ---");
            paciente.exibirInformacoes();
            System.out.println();

            System.out.println("--- HISTÓRICO DE MEDICAMENTOS ---");
            paciente.exibirHistoricoMedicamentos();
            System.out.println();

            //9. Exibo os detalhes completos da consulta (incluindo o registro)
            System.out.println("--- DETALHES DA CONSULTA ---");
            consulta.exibirConsulta();
            System.out.println();

            //10. Testo a exceção personalizada: tentei adicionar um medicamento nulo
            System.out.println("--- TESTE DE EXCESSÃO ---");
            try {
                registro.adicionarMedicamento(null);
            } catch (MedicamentoIndicadoException e) {
                System.out.println("Erro capturado: " + e.getMessage());
            }
        } catch (MedicamentoIndicadoException e) {
            // Este catch captura qualquer exceção não tratada no bloco interno (não deve ocorrer no fluxo normal)
            System.out.println("Exceção: " + e.getMessage());
        }
    }
}
