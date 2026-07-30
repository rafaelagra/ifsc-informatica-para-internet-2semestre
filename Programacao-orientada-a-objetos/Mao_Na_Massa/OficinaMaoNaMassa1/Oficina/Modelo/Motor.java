package Oficina.Modelo;

//classe que representa o motor do veículo
//possui potência e tipo de combustível (enum)
public class Motor {
    private int potencia; //potência em CV
    private ETipoCombustivel tipoCombustivel; //tipo de combustível (enum)

    //construtor padrão - valores padrão: 0 CV e FLEX
    public Motor() {
        this.potencia = potencia;
        this.tipoCombustivel = ETipoCombustivel.FLEX;
    }

    //construtor completo
    public Motor(int potencia, ETipoCombustivel tipoCombustivel) {
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
    }

    //getters e setters
        public int getPotencia() {
        return potencia;
        }

        public void setPotencia(int potencia) {
        this.potencia = potencia;
        }

        public ETipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
        }

        public void setTipoCombustivel(ETipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
        }
}
