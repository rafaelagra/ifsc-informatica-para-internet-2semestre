import clinica.modelo.*; //importa todas as classes que criei

/**
 * Classe MainApp - ponto de entrada do programa
 *
 * Essa classe contém o método main que executa o exemplo prático
 * mostra como todos os conceitos de POO funcionam juntos:
 * - encapsulamento
 * - Associações (unidirecional e bidirecional)
 * - composição
 * - enums
 * - getters e setters
 * - métodos específicos
 * **/

//classe principal - ponto de entrada do programa
public class Main {
    public static void main(String[] args) {

        System.out.println("=".repeat(60));
        System.out.println("=== SISTEMA DA CLÍNICA MÉDICA ===\n");
        System.out.println("=".repeat(60));
        System.out.println();

        //==============================================
        //passo 1: criar cidades (objetos independentes)
        //==============================================
        System.out.println("[1] CRIANDO CIDADES");
        System.out.println("-".repeat(40));

        //conceito: CONSTRUTOR e OBJETO
        Cidade Florianopolis = new Cidade("Florianópolis", "SC");
        Cidade saoPaulo = new Cidade("São Paulo", "SP");

        System.out.println("Cidade: " + Florianopolis.getNome() + "/" + Florianopolis.getUf());
        System.out.println("Cidade: " + saoPaulo.getNome() + "/" + saoPaulo.getUf());
        System.out.println();

        //==================================================
        //passo 2: criar pacientes (COMPOSIÇÃO com endereço)
        //==================================================
        System.out.println("[2] CRIANDO PACIENTES (COMPOSIÇÃO)");
        System.out.println("-".repeat(40));

        //CONCEITO DE COMPOSIÇÃO:
        //O endereço é criado dentro de paciente, não vem de fora
        //se o paciente for deletado, o endereço também é deletado
        Paciente paciente1 = new Paciente("João Silva", "123.456.789-00", "Av. Beira-mar Norte,1000", "Apto 101", Florianopolis);
        Paciente paciente2 = new Paciente("Ana Maria Souza", "987.654.321-00", "Av. Paulista, 200", saoPaulo);

        System.out.println("Paciente: " + paciente1.getNome() + " - CPF: " + paciente1.getCpf());
        System.out.println(" Endereço: " + paciente1.getEndereco().getRua());
        System.out.println(" Cidade: " + paciente1.getEndereco().getCidade().getNome());
        System.out.println();

        System.out.println("Paciente: " + paciente2.getNome() + " - CPF: " + paciente2.getCpf());
        System.out.println(" Endereço: " + paciente2.getEndereco().getRua());
        System.out.println(" Cidade: " + paciente2.getEndereco().getCidade().getNome());
        System.out.println();

        //========================
        //passo 3: criar médicos
        //========================
        System.out.println("[3] CRIANDO MÉDICOS");
        System.out.println("-".repeat(40));

        Medico medico1 = new Medico("Dra Bruna Santos", "111.222.333-44", "Cardiologia", "CRM-12345");
        Medico medico2 = new Medico("Dr. Carlos Pereira", "555.666.777-88", "Dermatologia", "CRM-67890");

        System.out.println("Médico: " + medico1.getNome());
        System.out.println(" Especialidade: " + medico1.getEspecialidade());
        System.out.println(" CRM: " + medico1.getCrm());
        System.out.println();

        System.out.println("Médico: " + medico2.getNome());
        System.out.println(" Especialidade: " + medico2.getEspecialidade());
        System.out.println(" CRM: " + medico2.getCrm());
        System.out.println();

        //========================================================
        //passo 4: criar consultas (com prioridade - Enum)
        //=========================================================
        System.out.println("[4] CRIANDO CONSULTAS (COM ENUM PRIORIDADE)");
        System.out.println("-".repeat(40));

        //CONCEITO DE ENUM: Prioridade só aceita ALTA, MEDIA ou BAIXA
        Consulta consulta1 = new Consulta("09/04/2025", "09:00", medico1, paciente1, Prioridade.ALTA);
        Consulta consulta2 = new Consulta("10/04/2025", "14:30", medico1, paciente2, Prioridade.MEDIA);
        Consulta consulta3 = new Consulta("11/04/2025", "11:00", medico2, paciente1, Prioridade.BAIXA);

        System.out.println("Consulta 1: " + consulta1.getDataConsulta() + " às " + consulta1.getHorario());
        System.out.println(" Médico: " + consulta1.getMedico().getNome());
        System.out.println(" Paciente: " + consulta1.getPaciente().getNome());
        System.out.println(" Prioridade: " + consulta1.getPrioridade());
        System.out.println(" Status: " + consulta1.getStatus());
        System.out.println();

        System.out.println("Consulta 2: " + consulta2.getDataConsulta() + " às " + consulta2.getHorario());
        System.out.println(" Prioridade: " + consulta2.getPrioridade());
        System.out.println();

        System.out.println("Consulta 3: " + consulta3.getDataConsulta() + " às " + consulta3.getHorario());
        System.out.println(" Prioridade: " + consulta3.getPrioridade());
        System.out.println();

        //===========================================================
        //passo 5: ASSOCIAÇÃO BIDIRECIONAL
        //===========================================================
        System.out.println("[5] ASSOCIAÇÃO BIDIRECIONAL (Médico <-> Consulta)");
        System.out.println("-".repeat(40));

        //CONCEITO DE ASSOCIAÇÃO BIDIRECIONAL:
        //-Médico adiciona consulta na sua lista
        //-internamente, a consulta também passa a conhecer o médico
        medico1.adicionarConsulta(consulta1);
        medico1.adicionarConsulta(consulta2);
        medico2.adicionarConsulta(consulta3);

        System.out.println("Consultas adicionadas aos médicos");
        System.out.println();

        System.out.println("Médico " + medico1.getNome() + " tem " + medico1.getConsultas().size() + " consultas(s):");
        for (Consulta c : medico1.getConsultas()) {
            System.out.println(" -> " + c.getDataConsulta() + " - " + c.getPaciente().getNome() + " - Prioridade: " + c.getPrioridade());
        }
        System.out.println();

        //============================================================
        //passo 6: ALTERNANDO STATUS DA CONSULTA (métodos específicos)
        //=============================================================
        System.out.println("[6] ALTERANDO STATUS DA CONSULTA (MÉTODOS ESPECÍFICOS)");
        System.out.println("-".repeat(40));

        //CONCEITO: Métodos específicos de negócio
        System.out.println("Status inicial da consulta 1: " + consulta1.getStatus());

        //realiza a consulta
        consulta1.realizarConsulta();
        System.out.println("Após realizarConsulta(): " + consulta1.getStatus());

        //Cancela a consulta 2
        System.out.println("Status inicial da consulta 2: " + consulta2.getStatus());
        consulta2.cancelarConsulta();
        System.out.println("Após cancelarConsulta(): " + consulta2.getStatus());
        System.out.println();

        //======================================================
        //passo 7: USANDO GETTERS E SETTERS (ENCAPSULAMENTO)
        //======================================================
        System.out.println("[7] ENCAPSULAMENTO (Getters e Setters)");
        System.out.println("-".repeat(40));

        //CONCEITO: acesso a atributos privados através de métodos públicos
        System.out.println("Antes da alteração:");
        System.out.println(" Data da consulta 1: " + consulta1.getDataConsulta());
        System.out.println(" Horário da consulta 1: " + consulta1.getHorario());

        //usando setters para modificar
        consulta1.setDataConsulta("20/04/2025");
        consulta1.setHorario("10:30");

        System.out.println("Depois da alteração:");
        System.out.println(" Data da consulta 1: " + consulta1.getDataConsulta());
        System.out.println(" Horário da consulta 1: " + consulta1.getHorario());
        System.out.println();

        //============================================================
        //passo 8: ASSOCIAÇÃO UNIDIRECIONAL (Paciente -> Endereco)
        //=============================================================
        System.out.println("[8] ASSOCIAÇÃO UNIDIRECIONAL (Paciente -> Endereco)");
        System.out.println("-".repeat(40));

        //CONCEITO: paciente sabe seu endereço, mas endereço não sabe  seu paciente
        System.out.println("Paciente: " + paciente1.getNome());
        System.out.println(" ↓ (associação unidirecional)");
        System.out.println("Endereço: " + paciente1.getEndereco().getRua());
        System.out.println(" ↓");
        System.out.println("Cidade: " + paciente1.getEndereco().getCidade().getNome());
        System.out.println();

        System.out.println("O endereço não sabe qual paciente mora nele (unidirecional)");
        System.out.println();

        //========================
        //      RESUMO FINAL
        //========================
        System.out.println("=".repeat(60));
        System.out.println("                           RESUMO FINAL");
        System.out.println("=".repeat(60));
        System.out.println();

        System.out.println("CONCEITOS DE POO UTILIZADOS:");
        System.out.println("1. Encapsulamento  -> atributos private, acesso via getters/setters");
        System.out.println("2. Associação unidirecional -> paciente -> endereco");
        System.out.println("3. Associação bidirecional  -> Medico <-> consulta");
        System.out.println("4. Composição        -> paciente cria endereco internamente");
        System.out.println("5. Enum              -> prioridade (ALTA/MEDIA/BAIXA)");
        System.out.println("6. Enum              -> StatusConsulta (AGENDADA/REALIZADA/CANCELADA)");
        System.out.println("7. Métodos específicos -> adicionarConsulta(), realizarConsulta()");
        System.out.println();

        System.out.println("ESTATÍSTICA DO SISTEMA:");
        System.out.println("- total de pacientes: 2");
        System.out.println("- total de médicos: 2");
        System.out.println("- total de consultas: 3");
        System.out.println("- consultas REALIZADAS: 1");
        System.out.println("- consultas CANCELADAS: 1");
        System.out.println("- consultas AGENDADAS: 1");
        System.out.println();

        System.out.println("SISTEMA EXECUTADO COM SUCESSO!");
    }
}