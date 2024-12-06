import java.util.ArrayList;
import java.util.List;

public class Imovel {
    private String endereco;
    private double area;
    private double valorCadastral;
    private String numeroMatricula;

    public List<ProprietarioObserver> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<ProprietarioObserver> observadores) {
        this.observadores = observadores;
    }

    private String tipo; // Novo atributo: tipo do imóvel
    private String descricao; // Novo atributo: descrição do imóvel
    private List<ProprietarioObserver> observadores; // Lista de observadores

    // Construtor
    public Imovel(String endereco, double area, double valorCadastral, String numeroMatricula, String tipo, String descricao) {
        this.endereco = endereco;
        this.area = area;
        this.valorCadastral = valorCadastral;
        this.numeroMatricula = numeroMatricula;
        this.tipo = tipo;
        this.descricao = descricao;
        this.observadores = new ArrayList<>();
    }

    // Getters e Setters
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
        notificarObservadores("O endereço do imóvel foi alterado para: " + endereco);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
        notificarObservadores("A área do imóvel foi alterada para: " + area + " m²");
    }

    public double getValorCadastral() {
        return valorCadastral;
    }

    public void setValorCadastral(double valorCadastral) {
        this.valorCadastral = valorCadastral;
        notificarObservadores("O valor cadastral do imóvel foi alterado para: R$" + valorCadastral);
    }
    public String getNumeroMatricula() {
        return numeroMatricula;
    }
    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
        notificarObservadores("O número da matrícula do imóvel foi alterado para: " + numeroMatricula);
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        notificarObservadores("O tipo do imóvel foi alterado para: " + tipo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        notificarObservadores("A descrição do imóvel foi alterada para: " + descricao);
    }

    // Métodos de Observador
    public void registrarObservador(ProprietarioObserver observador) {
        observadores.add(observador);
    }

    public void removerObservador(ProprietarioObserver observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores(String mensagem) {
        for (ProprietarioObserver observador : observadores) {
            observador.notificar(mensagem);
        }
    }

    // Outros métodos
    public Imovel buscarImovelPorEndereco(String endereco) {
        if (this.endereco.equalsIgnoreCase(endereco)) {
            return this;
        }
        return null;
    }

    public void exibirDadosImovel() {
        System.out.println("Endereço: " + endereco);
        System.out.println("Área: " + area + " m²");
        System.out.println("Valor Cadastral: R$" + valorCadastral);
        System.out.println("Número da Matrícula: " + numeroMatricula);
        System.out.println("Tipo do Imóvel: " + tipo);
        System.out.println("Descrição: " + descricao);
    }
}
