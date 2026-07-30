package exceptions;

//exceção personalizada para tratar erros relacionados á lavagem / ordem de serviço
//herda de Exception (checked) - isso obriga o chamador a tratar ou declarar throws
public class ExceptionLavacao extends Exception {

    //construtor padrão
    public ExceptionLavacao() {
        super(); //chama o construtor da superclasse Exception
    }

    //construtor que recebe uma mensagem personalizada
    public ExceptionLavacao(String msg) {
        super(msg); //passa a mensagem para o construtor da exception
    }
}
