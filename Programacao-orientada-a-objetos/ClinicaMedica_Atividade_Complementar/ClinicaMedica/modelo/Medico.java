package clinica.modelo;

import java.util.ArrayList; //importei a classe Arraylist (lista que cresce)
import java.util.List; //importei a interface List

//classe que representa um médico
//ASSOCIAÇÃO BIDIRECIONAL com consulta (médico tem lista de consultas)
public class Medico {

    //atributos privados (encapsulamento)
    private String nome; //nome do médico
    private String cpf; //CPF do médico
    private String especialidade; //especialidade: cardiologia, etc.
    private String crm; //número do crm (registro médico)
    private List<Consulta> consultas; //lista de consultas do médico (ASSOCIAÇÃO BIDIRECIONAL)

    //construtor
    public Medico(String nome, String cpf, String especialidade, String crm) {
            this.nome = nome;
            this.cpf = cpf;
            this.especialidade = especialidade;
            this.crm = crm;
            this.consultas = new ArrayList<>(); //inicia a lista vazia
    }

    //método especifico: adiciona uma consulta ao médico
    //esse método mantém a BIDIRECIONALIDADE
    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta); //adiciona á lista do médico
        consulta.setMedico(this); //faz a consulta apontar para este médico
    }

    //getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
