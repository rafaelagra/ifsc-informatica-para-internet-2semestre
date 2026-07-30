package clinica.modelo;

// Exceção personalizada do tipo checked (extends Exception).
// Eu a uso para indicar erros relacionados à indicação de medicamentos,
// por exemplo, quando tentam adicionar um medicamento nulo ao registro
public class MedicamentoIndicadoException extends Exception {
    // Construtor que recebe uma mensagem descritiva do erro
    public MedicamentoIndicadoException(String message) {
        super(message); // Passa a mensagem para a superclasse Exception
    }
}
