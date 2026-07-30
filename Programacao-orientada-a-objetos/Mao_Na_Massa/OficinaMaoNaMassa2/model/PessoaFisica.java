package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
* subclasse de cliente para pessoa física
* adiciona CPF e data de nascimento
* sobrescreve getDados() para incluir essas informações.
* */
public class PessoaFisica extends Cliente {
    private String cpf;
    private LocalDate dataNascimento;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, String celular, String email, String cpf, LocalDate dataNascimento) {
        super(nome, celular, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    /*
    * sobrescrita do método getDados()
    * chama o método da superClasse e concatena CPF e data de nascimento.
    * */
    @Override
    public String getDados() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dadosBasicos = super.getDados();
        String dadosEspecificos = String.format("\nCPF.....: %S\nData de nascimento.: %s", cpf, dataNascimento.format(fmt));
        return dadosBasicos + dadosEspecificos;
    }

    //getters e setters específicos
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}