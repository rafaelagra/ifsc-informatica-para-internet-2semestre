package model;

/*
* classe que representa a pontuação de fidelidadedo cliente
* cada cliente tem uma pontuação (associação1:1)
* permite adicionar, resgatar e consultar pontos
* */
public class Pontuacao {
    private int pontos;

    //construtor padrão: começa com zero pontos
    public Pontuacao() {
        this.pontos = 0;
    }

    //construtor com pontos iniciais
    public Pontuacao(int pontos) {
        this.pontos = pontos;
    }

    public int getPontos() { return pontos; }
    public void setPontos(int pontos) { this.pontos = pontos; }

    public void adicionarPontos(int valor) { this.pontos += valor; }

    public void resgatarPontos(int valor) {
        if(valor <= pontos) pontos -= valor;
    }

    @Override
    public String toString() {
        return String.valueOf(pontos);
    }
}