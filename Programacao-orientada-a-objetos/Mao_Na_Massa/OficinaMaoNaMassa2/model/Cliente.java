package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
* classe abstrata que representa um cliente genérico
* não pode ser instanciada diretamente (deve ser estendida por PF ou PJ)
* Possui atributos protected para acesso pelas subclasses
* implementa a interface IDados
* */
public abstract class Cliente implements IDados {
    //atributos protegidos (visíveis para subclasses e mesmo pacote)
    protected int id;
    protected String nome;
    protected String celular;
    protected String email;
    protected LocalDate dataCadastro;
    protected List<Veiculo> veiculos; //associação bidirecional (1 cliente tem N veículos)
    protected Pontuacao pontuacao; //cada cliente tem uma pontuação

    //construtor padrão - inicializa a lista, data atual e pontuação zero
    public Cliente() {
        this.veiculos = new ArrayList<>();
        this.dataCadastro = LocalDate.now();
        this.pontuacao = new Pontuacao();
    }

    //construtor com dados básicos - reaproveita o padrão via this()
    public Cliente(String nome, String celular, String email) {
        this();
        this.nome = nome;
        this.celular = celular;
        this.email = email;
    }

    //métodos de associação (add / remove) - mantêm a bidirecionalidade
    public void add(Veiculo veiculo) {
        if(veiculo != null && !veiculos.contains(veiculo)) {
            veiculos.add(veiculo);
            if(veiculo.getCliente() != this) {
                veiculo.setCliente(this);
            }
        }
    }

    public void remove(Veiculo veiculo) {
        if(veiculo != null && veiculos.contains(veiculo)) {
            veiculos.remove(veiculo);
            if(veiculo.getCliente() == this) {
                veiculo.setCliente(null);
            }
        }
    }

    // ==== IMPLEMENTAÇÃO DOS MÉTODOS DA INTERFACE ====
    //retorna os dados básicos do cliente(nome, celular, email, dataCadastro)
    @Override
    public String getDados() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Nome.....: %s\nCelular.....: %s\nE-mail.....: %s\nData de cadastro.....: %s",
                nome, celular, email, dataCadastro.format(fmt));
    }

    //sobrecarga : adiciona uma observação ao final
    @Override
    public String getDados(String observacao) {
        return getDados() + "\n" + observacao;
    }

    //getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
    public List<Veiculo> getVeiculos() { return veiculos; }
    public Pontuacao getPontuacao() { return pontuacao; }
    public void setPontuacao(Pontuacao pontuacao) { this.pontuacao = pontuacao; }
}