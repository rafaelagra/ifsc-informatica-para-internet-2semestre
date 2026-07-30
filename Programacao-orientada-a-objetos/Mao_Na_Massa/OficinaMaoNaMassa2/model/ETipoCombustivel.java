package model;

/*
* enum com os tipos de combustível permitidos para o motor.
* */
public enum ETipoCombustivel {
    GASOLINA, //apenas gasolina
    ETANOL, //apenas etanol
    FLEX, //ambos (mais comum no Brasil)
    DIESEL, //diesel
    GNV, //gás natural veicular
    OUTRO //elétrico, hidrogênio, etc.
}