package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PessoaFisica extends Cliente {
    private String cpf;
    private LocalDate dataNascimento;

    public PessoaFisica() { super(); }

    public PessoaFisica(String nome, String celular, String email, String cpf, LocalDate dataNascimento) {
        super(nome, celular, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getDados() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dadosBasicos = super.getDados();
        String dadosEspecificos = String.format("\nCPF.....: %s\nData de nascimento.: %s",
                cpf, dataNascimento.format(fmt));
        return dadosBasicos + dadosEspecificos;
    }

    //getters e setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}
