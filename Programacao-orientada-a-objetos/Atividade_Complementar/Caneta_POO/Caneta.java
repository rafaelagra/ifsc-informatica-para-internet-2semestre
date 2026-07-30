//declaração da classe caneta
class Caneta {

    //atributo que guarda a cor da caneta (tipo texto)
    private String cor;

    //atributo que guarda o tamanho da ponta (ex: 0.7 , 1.0)
    private float ponta;

    //atributo que indica se a caneta esta tampada (true ou false)
    private boolean tampada;

    //atributo que representa a carga de tinta (começa com 100)
    private int carga = 100;

    //construtor da classe (serve para criar a caneta já com valores definidos)
    public Caneta(String cor, float ponta, boolean tampada) {

        //"this.cor" se refere ao atributo da classe
        //"cor" (sem this) é o valor que vem quando criamos o objeto
        this.cor = cor;

        //mesma lógica para ponta
        this.ponta = ponta;

        //mesma lógica para o estado tampada
        this.tampada = tampada;
    }
    //método para escrever um texto com a caneta
    public void escrever(String texto) {

        //verifica se a caneta está tampada
        if (tampada) {

            //se estiver tampada não pode escrever
            System.out.println("Caneta tampada. Não da para escrever");
        } else {
            //se estiver destampada, escreva o texto
            System.out.println("Escrevendo: " + texto);

            //diminui a carga da caneta em 10 unidades
            carga -= 10;
        }
    }

    //método para tampar a caneta
    public void tampar() {
        //define o estado como verdadeiro (tampada)
        tampada = true;
    }

    //método para destampar a caneta
    public void destampar() {

        //define o estado como falso (destampada)
        tampada = false;
    }

    //método getter para pegar a cor da caneta
    public String getCor() {

        //retorna o valor da cor
        return cor;
    }

    //método getter para pegar a carga atual
    public int getCarga() {

        //retorna o valor da carga
        return carga;
    }

}