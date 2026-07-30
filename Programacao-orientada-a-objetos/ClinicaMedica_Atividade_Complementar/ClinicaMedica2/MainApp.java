package clinica;

import clinica.modelo.*;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DA CLÍNICA MÉDICA (COM HERANÇA E INTERFACE) ===\n");

        //1. criei uma cidade
        Cidade florianopolis = new Cidade("Florianópolis", "SC");

        //2. Criei um médico e um paciente (ambos são pessoas)
        Medico medico = new Medico("Dra. Ana", "111.222.333-44", "Cardiologia", "CRM-123");
        Paciente paciente = new Paciente("João Silva", "999.888.777-66", "(48)91234-5678","Rua das flores, 123", florianopolis);

        //3. criei consultas usando SOBRECARGA (overloading)
        Consulta consulta1 = new Consulta("10/06/2026", "09:00"); //sem prioridade
        Consulta consulta2 = new Consulta("12/06/2026", "14:30", Prioridade.ALTA); //com prioridade

        //4. demonstrar POLIMORFISMO: uma variável do tipo pessoa pode apontar para Medico e Paciente
        System.out.println("--- POLIMORFISMO: exibirInformacoes() ---");
        Pessoa p1 = medico; //upcasting (polimorfismo)
        Pessoa p2 = paciente; //mesmo tipo Pessoa, comportamentos diferentes
        p1.exibirInformacoes();
        System.out.println();
        p2.exibirInformacoes();
        System.out.println();

        //5. demonstrar INTERFACE: agendarConsulta funcionando de formas diferentes
        System.out.println("--- AGENDAMENTO VIA INTERFACE ---");
        medico.agendarConsulta(consulta1);
        paciente.agendarConsulta(consulta1); //mesmo método, mas comportamentos diferentes
        System.out.println();

        //6. agendar a segunda consulta (com prioridade)
        medico.agendarConsulta(consulta2);
        paciente.agendarConsulta(consulta2);
        System.out.println();

        //7. exibir detalhes das consultas
        System.out.println("--- DETALHES DAS CONSULTAS ---");
        consulta1.exibirConsulta();
        System.out.println();
        consulta2.exibirConsulta();

        //8. mostrar listas de consultas de médico e paciente
        System.out.println("\n--- CONSULTAS DO MÉDICO ---");
        medico.listarConsultas();

        System.out.println("\n--- CONSULTAS DO PACIENTE ---");
        for(Consulta c : paciente.getConsultas()) {
            System.out.println(" - " + c.getData() + " ás " + c.getHorario());
        }


    }
}
