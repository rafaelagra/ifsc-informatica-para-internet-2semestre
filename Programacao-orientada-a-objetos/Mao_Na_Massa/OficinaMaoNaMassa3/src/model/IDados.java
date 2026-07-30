package model;

//interface que define o contrato para obtenção de dados formatados
//será implementada por cliente e, se quiser, por outra classe (ex: veiculo)
public interface IDados {
    String getDados(); //retorna dados principais
    String getDados(String observacao); //retorna dados + observação extra
}
