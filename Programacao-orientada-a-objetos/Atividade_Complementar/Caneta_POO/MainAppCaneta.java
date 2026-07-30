//classe principal (onde o programa começa)
public class MainAppCaneta {

    //método principal (java começa a executar por aqui)
    public static void main(String[] args) {

        //criando um objeto do tipo caneta
        //passando : cor = azul, ponta = 0.7, tampada = true
        Caneta c1 = new Caneta("Azul", 0.7f, true);

        //criando outro objeto caneta com valores diferentes
        Caneta c2 = new Caneta("Preta", 1.0f, false);

        //mostrando a cor da primeira caneta
        System.out.println("Cor da caneta 1: " + c1.getCor());

        //mostrando a carga da primeira caneta
        System.out.println("Carga da caneta 1: " + c1.getCarga());

        //destampando a caneta (mudando o estado)
        c1.destampar();

        //tentando escrever com a caneta
        c1.escrever("Aprendendo java na prática");

        //mostrando a carga depois de escrever
        System.out.println("Carga depois: " + c1.getCarga());

        //separador visual no console
        System.out.println("-----------------------------------------");

        //usando a segunda caneta (já está destampada)
        c2.escrever("Outra caneta em ação");
    }
}