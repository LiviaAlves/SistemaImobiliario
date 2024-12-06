import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private String descricao;
    private String dataRegistro;
    private String numeroMatricula;

    private List<Proprietario> proprietariosHistoricos = new ArrayList<>();
    private ArquivoDigitalizado arquivo;

    public Matricula(String descricao, String dataRegistro, String numeroMatricula) {
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
        this.numeroMatricula = numeroMatricula;
    }
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void exibirDetalhesMatricula() {
        System.out.println("Número da Matrícula: " + numeroMatricula);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de Registro: " + dataRegistro);
    }

    public Matricula buscarPorNumeroMatricula(String numeroMatricula) {
        if (this.numeroMatricula.equals(numeroMatricula)) {
            return this;
        }
        return null;
    }

    public List<Proprietario> listarProprietariosHistoricos() {
        return proprietariosHistoricos;
    }

    public void associarArquivoDigitalizado(ArquivoDigitalizado arquivo) {
        this.arquivo = arquivo;
        System.out.println("Arquivo associado com sucesso!");
    }
}

