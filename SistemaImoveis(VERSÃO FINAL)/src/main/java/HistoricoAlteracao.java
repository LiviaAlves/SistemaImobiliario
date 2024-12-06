import java.util.ArrayList;
import java.util.List;

public class HistoricoAlteracao {
    private String dataAlteracao;
    private Usuario usuario;
    public String descricao;

    private static List<HistoricoAlteracao> alteracoes = new ArrayList<>();

    public HistoricoAlteracao(String dataAlteracao, Usuario usuario, String descricao) {
        this.dataAlteracao = dataAlteracao;
        this.usuario = usuario;
        this.descricao = descricao;
        alteracoes.add(this);
    }

    public List<HistoricoAlteracao> listarAlteracoesPorMatricula(int matriculaId) {
        // Simulação de busca por matrícula
        List<HistoricoAlteracao> resultado = new ArrayList<>();
        for (HistoricoAlteracao alteracao : alteracoes) {
            if (alteracao.descricao.contains("Matrícula " + matriculaId)) {
                resultado.add(alteracao);
            }
        }
        return resultado;
    }

    public List<HistoricoAlteracao> buscarAlteracoesPorUsuario(int usuarioId) {
        // Simulação de busca por usuário
        return new ArrayList<>(alteracoes);
    }

    public List<HistoricoAlteracao> listarAlteracoesPorData(String dataAlteracao) {
        // Busca por data
        List<HistoricoAlteracao> resultado = new ArrayList<>();
        for (HistoricoAlteracao alteracao : alteracoes) {
            if (alteracao.dataAlteracao.equals(dataAlteracao)) {
                resultado.add(alteracao);
            }
        }
        return resultado;
    }
}
