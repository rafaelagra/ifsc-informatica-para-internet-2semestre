package main;

import model.*;
import enums.*;
import exceptions.ExceptionLavacao;
import report.Relatorio;
import report.ImpressaoOS;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE OFICINA - ORDEM DE SERVIÇO ===\n\n");

        //1. criei marcas e cores
        Marca toyota = new Marca("Toyota");
        toyota.setId(1);
        Marca honda = new Marca("Honda");
        honda.setId(2);

        Cor preto = new Cor("Preto");
        preto.setId(1);
        Cor vermelho = new Cor("Vermelho");
        vermelho.setId(2);

        //2. criei modelos com motor
        Modelo corolla = new Modelo("Corolla", toyota);
        corolla.setId(1);
        corolla.setCategoria(ECategoria.MEDIO);
        corolla.getMotor().setPotencia(140);
        corolla.getMotor().setTipoCombustivel(ETipoCombustivel.FLEX);

        Modelo civic = new Modelo("Civic", honda);
        civic.setId(2);
        civic.setCategoria(ECategoria.MEDIO);
        civic.getMotor().setPotencia(150);
        civic.getMotor().setTipoCombustivel(ETipoCombustivel.GASOLINA);

        Modelo biz = new Modelo("Biz", honda);
        biz.setId(3);
        biz.setCategoria(ECategoria.MOTO);
        biz.getMotor().setPotencia(10);
        biz.getMotor().setTipoCombustivel(ETipoCombustivel.GNV);

        //3. criei cliente (PessoaFisica)
        PessoaFisica joao = new PessoaFisica(
          "João Silva", "(48)99999-1111", "joao@email.com", "123.456.789-99",
          LocalDate.of(1990, Month.MAY, 15)
        );
        joao.setId(1);
        joao.getPontuacao().adicionar(100); //joão já tem 100 pontos

        //4. criei veículo e associar a joão
        Veiculo v1 = new Veiculo("ABC-1234", corolla);
        v1.setId(1);
        v1.setCor(preto);
        joao.add(v1);

        //5. criei serviços disponíveis
        Servico lavagem = new Servico(1, "Lavagem completa", 50.0, 20, ECategoria.MEDIO);
        Servico polimento = new Servico(2, "Polimento", 120.0, 50, ECategoria.MEDIO);
        Servico trocaOleo = new Servico(3, "Troca de óleo", 80.0, 30, ECategoria.MEDIO);

        //6. criei uma ordem de serviço para o veículo de joão
        OrdemServico os = new OrdemServico(1001L, new Date(), 10.0); //10% de desconto


        //7. criei itens (ItemOS) - aqui apliquei a lógica de valor por categoria
        //para o veículo de joão (categoria MEDIO), usarei os valores padrão,
        //mas poderia ajustar. vou usar o valor padrão do serviço
        ItemOS itemLavagem = new ItemOS(lavagem, lavagem.getValor(), "Cliente pediu lavagem completa");
        ItemOS itemPolimento = new ItemOS(polimento, polimento.getValor(), "Polimento com cera de alta qualidade");
        ItemOS itemOleo = new ItemOS(trocaOleo, trocaOleo.getValor(), "Óleo sintético 5W30");

        //8. adicionar itens à OS
        os.add(itemLavagem);
        os.add(itemPolimento);
        os.add(itemOleo);

        //9. calcular total da OS (pode lançar exceção se lista vazia)
        try {
            double total = os.calcularServico();
            System.out.println("Total calculado da OS: R$ " + String.format("%.2f", total));
            //depois de calcular, podemos fechar a OS (mudar status)
            os.setStatus(EStatus.FECHADA);

            //adicionar pontos ao cliente
            int pontosGanhos = 0;
            for(ItemOS item : os.getItens()) {
                if(item.getServico() != null) {
                    pontosGanhos += item.getServico().getPontos();
                }
            }
            joao.getPontuacao().adicionar(pontosGanhos);
            System.out.println("Pontos ganhos nessa OS: " + pontosGanhos);
            System.out.println("Total de pontos do cliente: " + joao.getPontuacao().saldo());

        } catch (ExceptionLavacao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        //10. gerar cupom da OS usando ImpressaoOS
        System.out.println("\n" + ImpressaoOS.imprimirOS(os));

        //11. gerar relatório do cliente
        System.out.println(Relatorio.imprimir(joao));

        //12. testar exceção com OS vazia
        System.out.println("\n--- Teste de exceção (OS sem itens) ---");
        OrdemServico osVazia = new OrdemServico(999L, new Date(), 0);
        try {
            osVazia.calcularServico();
        } catch (ExceptionLavacao e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }


    }
}
