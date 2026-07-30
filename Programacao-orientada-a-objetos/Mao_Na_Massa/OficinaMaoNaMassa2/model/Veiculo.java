package model;

/*
* representa um veículo específico (com placa, cor, modelo e dono)
* associações:
* -unidirecional com modelo e cor
* -bidirecional com cliente (muitos-para-um)
*
* implementa a interface IDados (desafio) para permitir polimorfismo
* */
public class Veiculo implements IDados {
    private int id;
    private String placa;
    private String observacoes;
    private Modelo modelo; //unidirecional
    private Cor cor;//unidirecional
    private Cliente cliente;//bidirecional (lado do "muitos")

    //construtores sobrecarregados (3 variações exigidas)
    public Veiculo() {}
    public Veiculo(String placa) { this.placa = placa; }
    public Veiculo(String placa, Modelo modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    //getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public Modelo getModelo() { return modelo; }
    public void setModelo(Modelo modelo) { this.modelo = modelo; }
    public Cor getCor() { return cor;}
    public void setCor(Cor cor) { this.cor = cor;}
    public Cliente getCliente() { return cliente; }

    /**
     * Setter especial para manter a consistência da associação bidirecional.
     * Quando um veículo é associado a um cliente, ele também é adicionado à lista do cliente.
     * E quando é removido, também é removido da lista anterior.
     */
    public void setCliente(Cliente cliente) {
        //remove do cliente antigo (se existir)
        if(this.cliente != null) {
            this.cliente.getVeiculos().remove(this);
        }
        this.cliente = cliente;
        //adiciona ao novo cliente(se não estiver já presente)
        if(cliente != null && !cliente.getVeiculos().contains(this)) {
            cliente.getVeiculos().add(this);
        }
    }

    // ==== IMPLEMENTAÇÃO DOS MÉTODOS DA INTERFACE IDados ====
    //retorna uma string com os dados principais do veículo
    @Override
    public String getDados() {
        StringBuilder sb = new StringBuilder();
        sb.append("Placa: ").append(placa != null ? placa : "N/A").append("\n");

        if(modelo != null) {
            sb.append("Modelo: ").append(modelo.getDescricao()).append("\n");
            if(modelo.getMarca() != null) {
                sb.append("Marca ").append(modelo.getMarca().getNome()).append("\n");
            }
            if(modelo.getCategoria() != null) {
                sb.append("Categoria: ").append(modelo.getCategoria().name()).append("\n");
            }
            if(modelo.getMotor() != null) {
                sb.append("Potência do motor: ").append(modelo.getMotor().getPotencia()).append(" CV \n");
            }
        } else {
            sb.append("Modelo: não informado\n");
        }
        return sb.toString();
    }

    //método sobrecarregado: inclui uma observação extra
    @Override
    public String getDados(String observacao) {
        return getDados() + "Observação: " + observacao;
    }
}