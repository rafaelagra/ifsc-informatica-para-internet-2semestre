package model;

/*
* interface que define o contrato para obtenção de dados formatados
* será implementada por cliente (e suas subclassess) e também por veículo (desafio)
*
* a interface possui dois métodos sobrecarregados (overloading):
* - getDados(): retorna uma String com os principais dados do objeto
* - getDados(String observacao): retorna os dados + uma observação adicional
* */
public interface IDados {
    String getDados(); //método sem parâmetros
    String getDados(String observacao); //sobrecarga com parâmetro
}