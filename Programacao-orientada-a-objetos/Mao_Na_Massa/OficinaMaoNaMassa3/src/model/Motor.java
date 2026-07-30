package model;

import enums.ETipoCombustivel; //importando o enum do pacote enums

//classe que representqa o motor do veículo
//possui potência (em CV) e tipo de combustível
public class Motor {
    private int potencia;
    private ETipoCombustivel tipoCombustivel;

    //construtor padrão - define valores padrão
    public Motor() {
        this.potencia = 0;
        this.tipoCombustivel = ETipoCombustivel.FLEX;
    }

    //construtor com parâmetros
    public Motor(int potencia, ETipoCombustivel tipoCombustivel) {
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getPotencia() { return potencia; }

    public void setPotencia(int potencia) { this.potencia = potencia;}

    public ETipoCombustivel getTipoCombustivel() { return tipoCombustivel; }

    public void setTipoCombustivel(ETipoCombustivel tipoCombustivel) { this.tipoCombustivel = tipoCombustivel; }
}
