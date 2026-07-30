package enums;

/*
* aqui estou criando um enum chamado ECategoria
* enum é uma lista fixa de valores que não muda
* pode ser usado para classificar o tamanho/tipo de um veículo
* */
public enum ECategoria {
    PEQUENO, //para carros compactos (ex: fiat uno)
    MEDIO, // para carros de porte medio (ex: corolla)
    GRANDE, //para SUVs e caminhonetes (ex: hilux)
    MOTO, //para motocicletas
    PADRAO //valor genérico, caso nenhuma categoria específica se aplique
}
