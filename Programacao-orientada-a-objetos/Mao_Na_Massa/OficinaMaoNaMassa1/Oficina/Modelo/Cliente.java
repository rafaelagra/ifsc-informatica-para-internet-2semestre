package Oficina.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//classe que representa o cliente/proprietário do veículo
//possui associação bidirecional com veículo (um cliente tem muitos veículos)
public class Cliente {
    private int id;
    private String nome;
    private String celular;
    private String email;
    private LocalDate dataCadastro;
    private List<Veiculo> veiculos; //bidirecional (lado "um" da relação muitos-para-um)

    //construtor padrão - inicializa a lista e a data de cadastro com a data atual
    public Cliente() {
        this.veiculos = new ArrayList<>();
        this.dataCadastro = LocalDate.now();
    }

    //construtor com dados básicos (reaproveita o padrão via this())
    public Cliente(String nome, String celular, String email) {
        this(); //chama o construtor padrão para criar a lista e a data
        this.nome = nome;
        this.celular = celular;
        this.email = email;
    }

    //método ADD (adiciona o veículo)
    public void add(Veiculo veiculo) {
        if(veiculo != null && !veiculos.contains(veiculo)) {
            veiculos.add(veiculo); //adiciona á lista
            if(veiculo.getCliente() != this) {
                veiculo.setCliente(this); //mantém bidirecionalidade
            }
        }
    }

    //método remove
    public void remove(Veiculo veiculo) {
        if(veiculo != null && veiculos.contains(veiculo)) {
            veiculos.remove(veiculo); //remove da lista
            if (veiculo.getCliente() == this) {
                veiculo.setCliente(null); //remove a referência reversa
            }
        }
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}
