package model;

import enums.ECategoria;

//classe que representa um tipo de serviço que a oficina oferece
//EX: lavagem simples, troca de óleo, polimento

public class Servico {
    private int id;
    private String descricao;
    private double valor; //valor base
    private int pontos; //quantidade de pontos que o cliente ganha ao contratar este serviço
    private ECategoria categoria;

    //construtores
    public Servico() {
    }

    public Servico(int id, String descricao, double valor, int pontos, ECategoria categoria) {
        this.id = id; // guarda id
        this.descricao = descricao; // guarda descricao
        this.valor = valor; // guarda valor
        this.pontos = pontos; // guarda pontos
        this.categoria = categoria;

        //validação no construtor
        if(valor < 0) {
            System.out.println("Aviso: Valor não pode ser negativo. Ajustado para 0");
            this.valor = 0;
        } else {
            this.valor = valor;
        }
        //validação de pontos (não podem ser negativos)
        if(pontos < 0) {
            System.out.println("Aviso: Pontos não podem ser negativos. ajustando para 0.");
            this.pontos = 0;
        } else {
            this.pontos = pontos;
        }
    }

    //getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) {
        //validação de valor
        if(valor < 0) {
            System.out.println("Aviso: valor não pode ser negativo. Ajustando para 0");
            this.valor = 0;
        } else {
            this.valor = valor;
        }
    }

    public int getPontos() { return pontos; }
    public void setPontos(int pontos) { this.pontos = pontos; }

    public ECategoria getCategoria() { return categoria; }
    public void setCategoria(ECategoria categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return descricao + " (R$ " + String.format("%.2f", valor) + ")";
    }
}

