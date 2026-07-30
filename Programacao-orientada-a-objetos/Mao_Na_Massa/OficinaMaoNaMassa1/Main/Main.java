package Main;

import Oficina.Modelo.*;

//classe principal que contém o ponto de entrada (main)
public class Main {
    public static void print(Veiculo veiculo) {
        if (veiculo == null) {
            System.out.println("Veículo inválido (nulo)");
            return;
        }

        //1. nome do cliente
        String nomeCliente = (veiculo.getCliente() != null)
                ? veiculo.getCliente().getNome()
                : "não informado";

        //2. placa
        String placa = (veiculo.getPlaca() != null)
                ? veiculo.getPlaca()
                : "não informada";

        //variáveis para os demais campos (valores padrão)
        String nomeMarca = "não informada";
        String descricaoModelo = "não informada";
        String categoria = "não informada";
        int potencia = 0;
        String tipoCombustivel = "não informado";

        //se o veículo tiver um modelo, extraímos as informações
        if (veiculo.getModelo() != null) {
            Modelo modelo = veiculo.getModelo();

            //3. nome da marca
            if (modelo.getMarca() != null) {
                nomeMarca = modelo.getMarca().getNome();
            }

            //4. descrição do modelo
            if (modelo.getDescricao() != null) {
                descricaoModelo = modelo.getDescricao();
            }

            //5. categoria do modelo
            if (modelo.getCategoria() != null) {
                categoria = modelo.getCategoria().name(); //name() retorna a string do enum
            }

            //6. e 7. potência e tipo de combustível (via motor)
            if (modelo.getMotor() != null) {
                potencia = modelo.getMotor().getPotencia();
                if (modelo.getMotor().getTipoCombustivel() != null) {
                    tipoCombustivel = modelo.getMotor().getTipoCombustivel().name();
                }
            }
        }

        //impressão formatada
        System.out.println("=== DETALHES DO VEÍCULO ===");
        System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Placa: " + placa);
        System.out.println("Nome da marca: " + nomeMarca);
        System.out.println("Descrição do modelo: " + descricaoModelo);
        System.out.println("Categoria do modelo: " + categoria);
        System.out.println("Potência do motor: " + potencia + " CV");
        System.out.println("Tipo de combustível do motor: " + tipoCombustivel);
        System.out.println("===================================");
    }

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE VEÍCULOS ===");

        //1. criar marcas
        Marca toyota = new Marca("Toyota");
        toyota.setId(1);
        Marca honda = new Marca("Honda");
        honda.setId(2);

        //2. criar cores
        Cor vermelho = new Cor("Vermelho");
        vermelho.setId(1);
        Cor preto = new Cor("Preto");
        preto.setId(2);
        Cor azul = new Cor("Azul");
        azul.setId(3);

        //3. criar modelos (composição: cada modelo já tem um motor)
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

        Modelo biz = new Modelo("biz", honda);
        biz.setId(3);
        biz.setCategoria(ECategoria.MOTO);
        biz.getMotor().setPotencia(10);
        biz.getMotor().setTipoCombustivel(ETipoCombustivel.GNV); //usando GNV

        //4. criar clientes
        Cliente joao = new Cliente("João Silva", "(48)99999-1111", "joao@email.com");
        joao.setId(1);
        Cliente maria = new Cliente("Maria Santos", "(48)99999-2222", "maria@email.com");
        maria.setId(2);

        //5. criar veículos usando os três construtores diferentes
        //usando construtor veiculo(String placa, Modelo modelo)
        Veiculo v1 = new Veiculo("ABC-1234", corolla);
        v1.setId(1);
        v1.setCor(preto);
        joao.add(v1); //associação bidirecional

        //usando construtor veiculo(string placa)
        Veiculo v2 = new Veiculo("XYZ-9876");
        v2.setId(2);
        v2.setModelo(civic);
        v2.setCor(vermelho);
        maria.add(v2);

        //usando construtor veiculo() (padrão)
        Veiculo v3 = new Veiculo();
        v3.setId(3);
        v3.setPlaca("MND-4567");
        v3.setModelo(biz);
        v3.setCor(azul);
        maria.add(v3);

        //6. demonstrar o método print para cada veículo
        System.out.println("----- Detalhes do Veículo 1 (João) -----");
        print(v1);
        System.out.println();

        System.out.println("----- Detalhes do Veículo 2 (maria) -----");
        print(v2);
        System.out.println();

        System.out.println("----- Detalhes do veículo 3 (maria) -----");
        print(v3);
        System.out.println();

        //7. verificar a bidirecionalidade e os métodos add/remove
        System.out.println("--- Verificação da bidirecionalidade ---");
        System.out.println("João possui " + joao.getVeiculos().size() + " veículo(s).");
        System.out.println("Maria possui " + maria.getVeiculos().size() + " veículo(s).");

        System.out.println("\n--- testando o método remove() ---");
        maria.remove(v2);
        System.out.println("Após remover o Civic, Maria possui " + maria.getVeiculos().size() + " veículo(s).");
        System.out.println("O veículo removido agora pertence a: " + (v2.getCliente() == null ? "nenhum cliente" : v2.getCliente().getNome()));

        System.out.println("\n--- testando o método add() novamente ---");
        maria.add(v2);
        System.out.println("Após readicionar, maria possui " + maria.getVeiculos().size() + " veículo(s)");

        System.out.println("\n Programa finalizado com sucesso");

    }
}
