package clinica.modelo;

//interface = contrato de métodos
public interface Agendavel {
    //método que todas as classes que implementarem esta interface deverão ter
    void agendarConsulta(Consulta consulta);
}
