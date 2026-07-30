package report;

import model.Cliente;
import model.OrdemServico;

//classe responsável por gerar relatórios, neste caso, um relatório de cliente
//depende da classe cliente (usada como parâmetro)
public class Relatorio {

    /*
    * gera um relatório textual para um cliente
    * @param cliente objeto do tipo cliente (PessoaFisica ou PessoaJuridica)
    * @return String formatada com os dados do cliente e seus veículos
    * */
    public static String imprimir(Cliente cliente) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DO CLIENTE ===\n");
        sb.append(cliente.getDados()).append("\n");
        sb.append("Veículos cadastrados: \n");
        if(cliente.getVeiculos().isEmpty()) {
            sb.append("Nenhum veículo.\n");
        } else {
            for (var veiculo : cliente.getVeiculos()) {
                            sb.append("- placa: ").append(veiculo.getPlaca())
                              .append(" | Modelo: ").append(veiculo.getModelo().getDescricao())
                              .append("\n");
            }
        }
        sb.append("Pontos atuais: ").append(cliente.getPontuacao().saldo()).append("\n");
        sb.append("=====================================\n");
        return sb.toString();
    }
}
