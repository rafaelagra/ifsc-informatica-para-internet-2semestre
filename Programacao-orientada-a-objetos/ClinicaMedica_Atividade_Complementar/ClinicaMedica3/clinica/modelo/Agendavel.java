package clinica.modelo;

// Interface que define um contrato: toda classe que implementar Agendavel deve ter o método 'agendarConsulta' que recebe uma Consulta
// Isso garante polimorfismo: tanto Médico quanto Paciente sabem agendar consultas, cada um do seu jeito
public interface Agendavel {
    void agendarConsulta(Consulta consulta);
}
