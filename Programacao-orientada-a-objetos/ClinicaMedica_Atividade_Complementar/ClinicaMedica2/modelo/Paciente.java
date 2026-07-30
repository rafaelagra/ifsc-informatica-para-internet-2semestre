package clinica.modelo;

import java.util.ArrayList;
import java.util.List;
public class Paciente extends Pessoa implements Agendavel {
    private String contato; //telefone ou email
    private Endereco endereco; //composição: paciente tem um endereço
    private List<Consulta> consultas; // lista de consultas do páciente (opcional)

    //construtor que já cria o endereço (composição)
    public Paciente(String nome, String cpf, String contato, String rua, Cidade cidade) {
        super(nome, cpf);
        this.contato = contato;
        //cria o endereço DENTRO do paciente - isso é composição
        this.endereco = new Endereco(rua, cidade);
        this.consultas = new ArrayList<>();
    }

    // Implementação do método abstrato de Pessoa
    @Override
    public void exibirInformacoes() {
        System.out.println("Paciente: " + getNome() + " | CPF: " + getCpf());
        System.out.println("  Contato: " + contato);
        System.out.println("  Endereço: " + endereco.getRua() +
                ", " + endereco.getCidade().getNome() + "/" + endereco.getCidade().getUf());
    }

    //implementação do método da interface agendavel
    @Override
    public void agendarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
        consulta.setPaciente(this); //ligação bidirecional
        System.out.println("Consulta agendada para o paciente " + getNome());
    }

    //getters e setters
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
    public Endereco getEndereco() { return endereco; }
    public List<Consulta> getConsultas() { return consultas; }
}
