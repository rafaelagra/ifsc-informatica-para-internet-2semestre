package report;

import model.ItemOS;
import model.OrdemServico;
import java.text.SimpleDateFormat;

/*
* classe responsável por exibir os detalhes de uma ordem de serviço
* depende de OrdemServico (parâmetro). não mantém estado
* */
public class ImpressaoOS {

    /*
    * gera uma string com o cupom da ordem de serviço
    * @param os OrdemServico a ser impressa
    * @return String formatada com todos os detalhes
    * */
    public static String imprimirOS(OrdemServico os) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ORDEM DE SERVIÇO Nº ").append(os.getNumero()).append(" ===\n");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        sb.append("Data agenda: ").append(sdf.format(os.getAgenda())).append("\n");
        sb.append("Status: ").append(os.getStatus()).append("\n");
        sb.append("Desconto: ").append(os.getDesconto()).append("%\n");
        sb.append("Itens:\n");
        if(os.getItens().isEmpty()) {
            sb.append("Nenhum item.\n");
        } else {
            double subtotal = 0;
            for(ItemOS item : os.getItens()) {
                      sb.append(" - ").append(item.getServico().getDescricao())
                        .append(": R$ ").append(String.format("%.2f", item.getValorServico()))
                        .append(" (obs: ").append(item.getObservacoes()).append(")\n");
                subtotal += item.getValorServico();
            }
            sb.append("Subtotal: R$ ").append(String.format("%.2f", subtotal)).append("\n");
            double valorDesconto = subtotal * (os.getDesconto() / 100);
            sb.append("Desconto: R$ ").append(String.format("%.2f", valorDesconto)).append("\n");
            sb.append("Total a pagar: R$ ").append(String.format("%.2f", os.getTotal())).append("\n");
        }
        sb.append("=============================================================");
        return sb.toString();
    }
}
