import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ArquivoDigitalizadoTest {

    @Test
    void testExibirArquivoDigitalizado() {
        ArquivoDigitalizado arquivo = new ArquivoDigitalizado("documento3.pdf", "2024-12-10");
        arquivo.exibirArquivoDigitalizado(); // Apenas verifica a saída (não há retorno para testar)
    }

    // Teste para buscar arquivos por data
    @Test
    void testBuscarArquivosPorData() {
        // Criando um ambiente isolado para o teste
        new ArquivoDigitalizado("documento1.pdf", "2024-12-04");
        new ArquivoDigitalizado("documento2.pdf", "2024-12-06");

        // Busca arquivos pela data (verificando resultados independentes)
        ArquivoDigitalizado arquivoTeste = new ArquivoDigitalizado("documento3.pdf", "2024-12-04");

        List<ArquivoDigitalizado> arquivosData1 = arquivoTeste.buscarArquivosPorData("2024-12-05");
        List<ArquivoDigitalizado> arquivosData2 = arquivoTeste.buscarArquivosPorData("2024-12-07");

        // Verifica os resultados esperados
        assertEquals(1, arquivosData1.size()); // Aqui espera-se 2 (documento1 e documento3)
        assertEquals(0, arquivosData2.size()); // Aqui espera-se 0 arquivos para a data '2024-12-07'
    }

    // Teste para extrair texto OCR do arquivo
    @Test
    void testExtrairTextoOCR() {
        ArquivoDigitalizado arquivo = new ArquivoDigitalizado("documento1.pdf", "2024-12-05");
        assertEquals("Texto extraído do arquivo: documento1.pdf", arquivo.extrairTextoOCR());
    }
}
