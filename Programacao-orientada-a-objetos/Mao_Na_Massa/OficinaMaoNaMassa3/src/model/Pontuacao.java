package model;

/*
* classe que gerencia os pontos de fidelidade do cliente
* cada cliente possui uma instância desta classe
* */
public class Pontuacao {
    private int quantidade; //saldo atual de pontos

    public Pontuacao() {
        this.quantidade = 0;
    }

    public Pontuacao(int quantidade) { this.quantidade = quantidade; }

    //adiciona pontos ao saldo
    public void adicionar(int qtd) { this.quantidade += qtd; }

    //subtrai pontos (resgata), mas não permite saldo negativo
    public void subtrair(int qtd) {
        if(qtd <= this.quantidade) {
            this.quantidade -= qtd;
        } else {
            System.out.println("Pontos insuficientes para resgate.");
        }
    }

    public int saldo() { return quantidade; }

    @Override
    public String toString() {
        return String.valueOf(quantidade);
    }
}

