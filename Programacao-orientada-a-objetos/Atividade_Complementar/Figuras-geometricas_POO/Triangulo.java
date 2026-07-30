//declaração da classe triangulo
public class Triangulo {

    //atributos da classe
    private double base; //base do triangulo
    private double altura; //altura do triangulo

    //construtor que recebe base e altura
    public Triangulo(double base, double altura) {
        //atribuindo os valores recebidos aos atributos da classe
        this.base = base;
        this.altura = altura;
    }

    //método que simula desenhar o triangulo
    public void desenhar() {
        System.out.println("Desenhando um triângulo");
    }

    //método para calcular a área do triangulo
    public double calcularArea() {
        //fórmula :
        return (base * altura) / 2;
    }
}
