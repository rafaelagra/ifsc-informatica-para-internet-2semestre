//declaração da classe quadrado
public class Quadrado {

    //atributo que representa o lado do quadrado
    private double lado;


    //construtor que recebe o valor do lado
    public Quadrado(double lado) {
        //atribui o valor ao atributo da classe
        this.lado = lado;
    }

    //método que simula desenhar o quadrado
    public void desenhar() {
        System.out.println("Desenhando um quadrado");
    }

    //método que calcula a área do quadrado
    public double calcularArea() {
        //fórmula :
        return lado * lado;
    }
}

