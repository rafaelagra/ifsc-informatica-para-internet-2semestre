package model;

import enums.EStatus;
import exceptions.ExceptionLavacao; //importando a excessão que ainda irei criar
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//classe que representa uma ordem de serviço (OS) da oficina
//possui número, data, desconto, status e uma lista de itens (ItemOS)
public class OrdemServico {
    private long numero; //número da OS
    private double total; //total calculado(depois do desconto)
    private Date agenda; //data agendada para o serviço
    private double desconto; //percentual de desconto(EX: 10 = 10%)
    private EStatus status; //status atual(ABERTA, FECHADA, CANCELADA)
    private List<ItemOS> itens; //lista de serviços dessa OS(composição/agregação)

    //construtor padrão (sem parâmetros)
    //este construtor é chamado quando fazemos : newOrdemServico()
    //ele não recebe nada e cria uma OS vazia pronta para ser preenchida
    public OrdemServico() {
        //criei uma lista vazia para os itens
        this.itens = new ArrayList<>();
        //defini o status inicial como ABERTA
        this.status = EStatus.ABERTA;
        //total começa com zero
        this.total = 0.0;
    }

    //construtor padrão com parâmetros básicos
    public OrdemServico(long numero, Date agenda, double desconto) {
        //primeiro, chamo o construtor padrão para criar a lista e definir o status
        this();
        //depois preencho os atributos específicos que recebi como parãmetro
        this.numero = numero;
        this.agenda = agenda;
        this.desconto = desconto;
    }

    //método para adicionar um item á OS
    public void add(ItemOS item) {
       //validação de status
       if(status == EStatus.FECHADA) {
           System.out.println("Erro: Não é possível adicionar itens a uma OS já FECHADA");
           return;
       }
       if(status == EStatus.CANCELADA) {
           System.out.println("Erro: não é possível adicionar itens a uma OS CANCELADA");
           return;
       }
       //adicionar o item normalmente
        if(item != null && !itens.contains(item)) {
            itens.add(item);
            System.out.println("Item adicionado com sucesso");
        } else {
            System.out.println("Item já está na lista ou é nulo");
        }
    }

    //método para remover um item da OS
    public void remove(ItemOS item) {
        //validação de status
        if(status == EStatus.FECHADA) {
            System.out.println("Erro: Não é possível remover itens de uma OS já fechada");
            return;
        }
        if(status == EStatus.CANCELADA) {
            System.out.println("Erro: Não é possível remover itens de uma OS CANCELADA");
            return;
        }

        //remove o item normalmente
        if(item != null) {
            itens.remove(item);
            System.out.println("Item removido com sucesso");
        }
    }

    /*
    * calcula o total da OS com base nos itens e aplica o desconto
    * percorre a lista de itens, soma os valores, aplica o percentual de desconto
    * se a lista estiver vazia, lança uma exceção personalizada (ExceptionLavacao)
    *
    * @return total calculado
    * @throws ExceptionLavacao se a lista de itens estiver vazia
    * */
    public double calcularServico() throws ExceptionLavacao {
        //verifica se a lista está vazia
        if(itens.isEmpty()) {
            //lança a exceção com uma mensagem
            throw new ExceptionLavacao("não há serviços na lista para serem calculados");
        }

        //validação do desconto
        double descontoAplicado = this.desconto;
        if(descontoAplicado < 0) {
            descontoAplicado = 0;
        }
        if(descontoAplicado > 100) {
            descontoAplicado = 100;
        }

        double soma = 0.0;
        for (ItemOS item : itens) {
            soma += item.getValorServico();
        }

        //aplica o desconto válidado
        double totalComDesconto = soma * (1 - descontoAplicado / 100);
        this.total = totalComDesconto;
        return this.total;
    }

    //getters e setters
    public long getNumero() { return numero; }
    public void setNumero(long numero) { this.numero = numero; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Date getAgenda() { return agenda; }
    public void setAgenda(Date agenda) { this.agenda = agenda; }

    public double getDesconto() { return desconto; }
    public void setDesconto(double desconto) {
        //validação: desconto não pode ser negativo
        if(desconto < 0) {
            this.desconto = 0;
            System.out.println("Desconto não pode ser negativo. ajustado para 0%");
        }
        //validação: desconto não pode ultrapassar 100%
        else if(desconto > 100) {
            this.desconto = 100;
            System.out.println("Desconto não pode ultrapassar 100%. ajustado para 100%");
        }
        else {
            this.desconto = desconto;
        }
    }

    public EStatus getStatus() { return status; }
    public void setStatus(EStatus status) { this.status = status; }

    public List<ItemOS> getItens() { return itens; }
    public void setItens(List<ItemOS> itens) { this.itens = itens; }

}
