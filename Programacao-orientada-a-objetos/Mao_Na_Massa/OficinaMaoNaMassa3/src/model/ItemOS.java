package model;

/*
* classe associativa entre OrdemServico e Servico
* representa uma linha da ordem de serviço
* cada linha contém um serviço e o valor que será cobrado (que pode ser diferente do valor original do serviço)
* */
public class ItemOS {
    private Servico servico; //serviço referenciado
    private double valorServico; //valor efetivamente cobrado (pode ser diferente do valor original do serviço)
    private String observacoes; //observações sobre esse item

    //construtores
    public ItemOS() {
    }

    //construtor com parâmetros
    public ItemOS(Servico servico, double valorServico, String observacoes) {
        this.servico = servico;
        this.valorServico = valorServico;
        this.observacoes = observacoes;
    }

    //getters e setters
    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    public double getValorServico() { return valorServico; }
    public void setValorServico(double valorServico) { this.valorServico = valorServico; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }


   @Override
    public String toString() {
        //validação de segurança
        if(servico != null) {
            return "Serviço não informado - R$ " + String.format("%.2f", valorServico);
        }
        return servico.getDescricao() + " - R$ " + String.format("%.2f", valorServico);
   }
}
