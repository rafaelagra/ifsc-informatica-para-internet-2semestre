//declaração da classe chamada circulo
public class Circulo {

    //atributo privado do tipo double
    //representa o raio do circulo
    private double raio;

    //construtor da classe (método especial que cria o objeto)
    public Circulo(double raio) {
        //"this.raio" se refere ao atributo da classe
        //recebe o valor passado  quando o objeto é criado
        this.raio = raio;
    }

    //método que não retorna nada (void)
    //serve para simular o desenho do circulo
    public void desenhar() {
        //imprime uma mensagem no console
        System.out.println("Desenhando um circulo");
    }

    //método que retorna um valor do tipo double (a área)
    public double calcularArea() {
        //fórmula da área do circulo :
        return Math.PI * raio * raio;
    }
}

