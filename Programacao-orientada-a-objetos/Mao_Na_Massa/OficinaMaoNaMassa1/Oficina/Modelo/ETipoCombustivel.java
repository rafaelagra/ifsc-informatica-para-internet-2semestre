package Oficina.Modelo;

//enum para os tipos de combustível aceitos pelo motor
public enum ETipoCombustivel {
    GASOLINA, //veículos movidos apenas a gasolina
    ETANOL, //veículos movidos apenas a etanol
    FLEX, //veículos que aceitam ambos
    DIESEL, //veículos a diesel (caminhões, alguns carros)
    GNV, //gás natural veicular
    OUTRO //para elétrico, hidrogênio, etc.
}
