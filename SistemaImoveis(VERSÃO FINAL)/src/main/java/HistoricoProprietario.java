import java.util.ArrayList;
import java.util.List;

public class HistoricoProprietario {
    private String dataInicio;
    private String dataFim;
    private Imovel imovel;
    public Proprietario proprietario;

    private static List<HistoricoProprietario> historicos = new ArrayList<>();

    public HistoricoProprietario(String dataInicio, String dataFim, Imovel imovel, Proprietario proprietario) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.imovel = imovel;
        this.proprietario = proprietario;
        historicos.add(this);
    }

    public List<HistoricoProprietario> listarHistoricoPorImovel(int imovelId) {
        return new ArrayList<>(historicos);
    }

    public List<HistoricoProprietario> listarHistoricoPorProprietario(int proprietarioId) {
        return new ArrayList<>(historicos);
    }
}
