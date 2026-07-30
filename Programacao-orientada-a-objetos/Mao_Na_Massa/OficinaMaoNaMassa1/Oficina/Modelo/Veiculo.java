package Oficina.Modelo;

/**
 * classe que representa um veículo específico (com placa, cor, modelo e dono)
 * possui associações:
 * - unidirecional com modelo
 * -unidirecional com cor
 * -bidirecional com cliente(muitos-para-um)
 * */
public class Veiculo {
    private int id;
    private String placa;
    private String observacoes;
    private Modelo modelo; //unidirecional
    private Cor cor; //unidirecional
    private Cliente cliente; //bidirecional (lado "muitos" da relação muitos-para-um

    //construtores
    public Veiculo() {
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo(String placa, Modelo modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    //setter especial para manter a consistência da associação bidirecional
    //quando eu associo um veículo a um cliente, automaticamente adiciono este veículo á lista de cliente
    public void setCliente(Cliente cliente) {
        //remove do cliente antigo, se tiver
        if(this.cliente != null) {
            this.cliente.getVeiculos().remove(this);
        }
        this.cliente = cliente;
        //adiciona ao novo cliente, se não estiver já presente
        if(cliente != null && !cliente.getVeiculos().contains(this)) {
            cliente.getVeiculos().add(this);
        }
    }
}
