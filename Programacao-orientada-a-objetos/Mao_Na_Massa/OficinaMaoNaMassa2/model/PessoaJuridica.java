package model;

/*
* subclasse de cliente para pessoa jurídica
* adiciona CNPJ e inscrição estadual.
* sobrescreve getDados() para incluir esses dados
* */
public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String inscricaoEstadual;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String nome, String celular, String email, String cnpj, String inscricaoEstadual) {
        super(nome, celular, email);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getDados() {
        String dadosBasicos = super.getDados();
        String dadosEspecificos = String.format("\nCNPJ.....: %s\nInscrição Estadual.: %s", cnpj, inscricaoEstadual);
        return dadosBasicos + dadosEspecificos;
    }

    //getters e setters
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getInscricaoEstadual() { return inscricaoEstadual; }
    public void setInscricaoEstadual(String inscricaoEstadual) { this.inscricaoEstadual = inscricaoEstadual; }
}
