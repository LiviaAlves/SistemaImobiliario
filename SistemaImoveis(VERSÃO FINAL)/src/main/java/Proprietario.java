import java.util.ArrayList;
import java.util.List;

public class Proprietario implements ProprietarioObserver{
    public String nome;
    private String cpf;
    private List<Imovel> imoveis = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public Proprietario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public List<Imovel> listarImoveisPorProprietario() {
        return imoveis;
    }

    public List<HistoricoProprietario> historicoPropriedade() {
        return new ArrayList<>();
    }

    public Proprietario buscarProprietarioPorNome(String nome) {
        if (this.nome.equalsIgnoreCase(nome)) {
            return this;
        }
        return null;
    }
    @Override
    public void notificar(String mensagem) {
        System.out.println("Proprietário " + nome + " foi notificado: " + mensagem);
    }
}
