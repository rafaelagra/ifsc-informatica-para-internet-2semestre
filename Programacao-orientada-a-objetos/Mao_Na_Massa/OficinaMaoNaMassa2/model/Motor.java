package model;

/*
* classe que representa o motor do veículo
* possui potência (em CV) e tipo de combustível (enum)
* será usada em composição com modelo
* */
public class Motor {
    private int potencia;
    private ETipoCombustivel tipoCombustivel;

    // Construtor padrão (sem argumentos) – adicione este!
    public Motor() {
        this.potencia = 0;
        this.tipoCombustivel = ETipoCombustivel.FLEX; // valor padrão
    }

    // Construtor completo
    public Motor(int potencia, ETipoCombustivel tipoCombustivel) {
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
    }

    // Getters e Setters
    public int getPotencia() { return potencia; }
    public void setPotencia(int potencia) { this.potencia = potencia; }
    public ETipoCombustivel getTipoCombustivel() { return tipoCombustivel; }
    public void setTipoCombustivel(ETipoCombustivel tipoCombustivel) { this.tipoCombustivel = tipoCombustivel; }
}