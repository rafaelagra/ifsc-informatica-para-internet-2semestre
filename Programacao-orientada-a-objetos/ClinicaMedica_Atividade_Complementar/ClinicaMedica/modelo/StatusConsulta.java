package clinica.modelo;

//ENUM: lista de valores fixos para o status da consulta
//toda consulta começa como AGENDADA
public enum StatusConsulta {
    AGENDADA, //consulta marcada, ainda não aconteceu
    REALIZADA, // consulta já foi realizada
    CANCELADA //consulta foi cancelada
}
