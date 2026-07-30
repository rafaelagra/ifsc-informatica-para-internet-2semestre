package model;

/*
* representa um veículo específico (com placa, cor, modelo e dono)
* possui associação unidirecional com modelo e cor, e bidirecional com cliente
* */
public class Veiculo {
    private int id;
    private String placa;
    private String observacoes;
    private Modelo modelo; //associação unidirecional com modelo
    private Cor cor; //associação unidirecional com cor
    private Cliente cliente; //referencia para o dono (bidirecional)

    //construtores (3 sobrecargas, conforme diagrama)
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
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public Modelo getModelo() { return modelo; }
    public void setModelo(Modelo modelo) { this.modelo = modelo; }

    public Cor getCor() { return cor; }
    public void setCor(Cor cor) { this.cor = cor; }

    public Cliente getCliente() { return cliente; }

    /*
    * setter especial para manter a associação bidirecional
    * quando associo este veículo a um cliente, também me adiciono á lista de veículos do cliente
    * e se já tiver um cliente antigo, removo deste
    * */
    public void setCliente(Cliente cliente) {
        //primeiro, se eu já tinha um cliente, removo este veículo da lista dele
        if(this.cliente != null) {
            this.cliente.getVeiculos().remove(this);
        }
        //atualizo a referência para o novo cliente
        this.cliente = cliente;
        //agora, se o novo cliente não for nulo e ainda não tiver este veículo na lista dele, adiciono
        if(cliente != null && !cliente.getVeiculos().contains(this)) {
            cliente.getVeiculos().add(this);
        }
    }
}
