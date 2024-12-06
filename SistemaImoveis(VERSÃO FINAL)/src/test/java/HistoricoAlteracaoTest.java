import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class HistoricoAlteracaoTest {

    @Test
    void testListarAlteracoesPorData() {
        Usuario usuario = new Usuario("John Doe", "john@example.com", "senha123");

        // Adicionando algumas alterações
        HistoricoAlteracao alteracao1 = new HistoricoAlteracao("2024-12-05", usuario, "Alteração na matrícula");
        HistoricoAlteracao alteracao2 = new HistoricoAlteracao("2024-12-06", usuario, "Alteração na matrícula");

        // Testando a listagem por data
        List<HistoricoAlteracao> alteracoesData1 = alteracao1.listarAlteracoesPorData("2024-12-05");
        List<HistoricoAlteracao> alteracoesData2 = alteracao2.listarAlteracoesPorData("2024-12-07");

        // Espera-se 1 alteração para a data '2024-12-05' e 0 para a data '2024-12-07'
        assertEquals(1, alteracoesData1.size());  // Espera-se 1 item para a data '2024-12-05'
        assertEquals(0, alteracoesData2.size());  // Espera-se 0 para a data '2024-12-07'
    }
}
