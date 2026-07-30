//classe principal (onde o programa começa)
public class MainApp {

    //método principal (ponto de entrada do programa)
    public static void main(String[] args) {

        //criando um objeto Circulo com raio = 5
        Circulo circulo = new Circulo(5);

        //criando um objeto Triangulo com base = 3 e altura = 4
        Triangulo triangulo = new Triangulo(3, 4);

        //criando um objeto Quadrado com lado = 2
        Quadrado quadrado = new Quadrado(2);

        //chamando o método desenhar de cada objeto
        circulo.desenhar();
        triangulo.desenhar();
        quadrado.desenhar();

        //chamando o método calcularArea e imprimindo o resultado
        System.out.println("Área do circulo " + circulo.calcularArea());
        System.out.println("Área do triângulo " + triangulo.calcularArea());
        System.out.println("Área do quadrado " + quadrado.calcularArea());
    }
}