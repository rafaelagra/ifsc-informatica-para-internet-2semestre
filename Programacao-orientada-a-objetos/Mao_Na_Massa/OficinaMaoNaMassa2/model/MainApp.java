package model;

import java.time.LocalDate;
import java.time.Month;

/*
 * classe principal que demonstra todos os conceitos:
 * - herança (PessoaFisica, PessoaJuridica herdam de cliente)
 * - classe abstrata (cliente não pode ser instanciada)
 * - interface (IDados)
 * - polimorfismo (método print(IDados) e print(Cliente) sobrecarregado)
 * - associações, composição, enum etc.
 */
public class MainApp {

    /**
     * Método polimórfico: aceita qualquer objeto que implemente IDados
     * (Cliente, PessoaFisica, PessoaJuridica, Veiculo) e imprime seus dados.
     *
     * @param obj objeto que implementa IDados
     */
    public static void print(IDados obj) {
        System.out.println(obj.getDados());
    }

    /**
     * Sobrecarga do método print específica para cliente.
     * Usa instanceof para identificar se é PF ou PJ e imprime dados adicionais
     * (CPF ou CNPJ), a lista de veículos e a pontuação.
     *
     * @param cliente cliente a ser exibido
     */
    public static void print(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente inválido");
            return;
        }

        // identifica o tipo usando instanceof
        if (cliente instanceof PessoaFisica) {
            PessoaFisica pf = (PessoaFisica) cliente;
            System.out.println("=== PESSOA FÍSICA ===");
            System.out.println("Nome: " + pf.getNome());
            System.out.println("CPF: " + pf.getCpf());
        } else if (cliente instanceof PessoaJuridica) {
            PessoaJuridica pj = (PessoaJuridica) cliente;
            System.out.println("=== PESSOA JURÍDICA ===");
            System.out.println("Nome: " + pj.getNome());
            System.out.println("CNPJ: " + pj.getCnpj());
        } else {
            System.out.println("Tipo de cliente desconhecido.");
        }

        // lista de veículos do cliente
        System.out.println("\n--- VEÍCULOS DO CLIENTE ---");
        if (cliente.getVeiculos().isEmpty()) {
            System.out.println("Nenhum veículo associado.");
        } else {
            for (Veiculo v : cliente.getVeiculos()) {
                String modeloDesc = (v.getModelo() != null) ? v.getModelo().getDescricao() : "N/A";
                System.out.println("Placa: " + v.getPlaca() + " | Modelo: " + modeloDesc);
            }
        }

        // pontuação
        System.out.println("\nPontos do cliente: " + cliente.getPontuacao().getPontos());
        System.out.println("--------------------------------------------------------------\n");
    }

    public static void main(String[] args) {
        System.out.println("\n=== SISTEMA COM HERANÇA, INTERFACE E POLIMORFISMO ===\n");

        // ===== 1. criar marcas =====
        Marca toyota = new Marca("Toyota");
        toyota.setId(1);
        Marca honda = new Marca("Honda");
        honda.setId(2);

        // ===== 2. criar cores =====
        Cor vermelho = new Cor("Vermelho");
        vermelho.setId(1);
        Cor preto = new Cor("Preto");
        preto.setId(2);
        Cor branco = new Cor("Branco");
        branco.setId(3);

        // ===== 3. criar modelos e configurar motores =====
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

        // ===== 4. criar clientes PF e PJ =====
        PessoaFisica joao = new PessoaFisica(
                "João Silva", "(48)99999-1111", "joao@email.com",
                "123.456.789-99", LocalDate.of(1990, Month.MAY, 15)
        );
        joao.setId(1);
        joao.getPontuacao().adicionarPontos(100);

        PessoaJuridica empresaXYZ = new PessoaJuridica(
                "XYZ Ltda", "(48)3333-4444", "contato@xyz.com",
                "12.345.678/0001-90", "123456789"
        );
        empresaXYZ.setId(2);
        empresaXYZ.getPontuacao().adicionarPontos(500);

        // ===== 5. criar veículos e associar aos clientes =====
        Veiculo v1 = new Veiculo("ABC-1234", corolla);
        v1.setId(1);
        v1.setCor(preto);
        joao.add(v1);

        Veiculo v2 = new Veiculo("XYZ-9876", civic);
        v2.setId(2);
        v2.setCor(vermelho);
        empresaXYZ.add(v2);

        Veiculo v3 = new Veiculo("MNO-4567", biz);
        v3.setId(3);
        v3.setCor(branco);
        empresaXYZ.add(v3);

        // ===== 6. teste do método print(IDados) - polimorfismo =====
        System.out.println("--- Chamando print(IDados) para João (PF) ---");
        print((IDados) joao);

        System.out.println("\n--- Chamando print(IDados) para empresa (PJ) ---");
        print((IDados) empresaXYZ);

        System.out.println("\n--- Chamando print(IDados) para veículo (desafio) ---");
        print(v1);

        // ===== 7. teste do método print(Cliente) - sobrecarga =====
        System.out.println("\n--- Chamando print(Cliente) para João ---");
        print(joao);

        System.out.println("\n--- Chamando print(Cliente) para empresa ---");
        print(empresaXYZ);

        // ===== 8. teste do método getDados(String) com observação =====
        System.out.println("--- Teste de getDados(String) para João ---");
        String obsCliente = "Hoje é seu aniversário, parabéns!!! Você terá um desconto de 20% na próxima lavagem.";
        System.out.println(joao.getDados(obsCliente));

        System.out.println("\n--- Teste de getDados(String) para veículo v1 ---");
        String obsVeiculo = "Veículo com revisão pendente.";
        System.out.println(v1.getDados(obsVeiculo));

        // ===== 9. EXTRA: lista polimórfica com IDados =====
        System.out.println("\n--- Lista polimórfica (clientes + veículos) ---");
        IDados[] objetos = { joao, empresaXYZ, v1, v2, v3 };
        for (IDados obj : objetos) {
            System.out.println(">>> " + obj.getClass().getSimpleName());
            System.out.println(obj.getDados());
            System.out.println("---------------------------------------");
        }

        System.out.println("\nPrograma finalizado com sucesso!");
    }
}
