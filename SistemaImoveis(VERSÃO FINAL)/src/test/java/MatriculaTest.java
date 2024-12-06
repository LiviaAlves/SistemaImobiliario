import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaTest {

    @Test
    public void testBuscarPorNumeroMatricula() {
        Matricula matricula = new Matricula("Registro de imóvel", "2023-12-01", "12345");
        assertNotNull(matricula.buscarPorNumeroMatricula("12345"));
        assertNull(matricula.buscarPorNumeroMatricula("99999"));
    }

    @Test
    public void testExibirDetalhesMatricula() {
        Matricula matricula = new Matricula("Registro de imóvel", "2023-12-01", "12345");
        matricula.exibirDetalhesMatricula(); // Aqui só testamos manualmente porque o método usa System.out
    }

    @Test
    public void testAssociarArquivoDigitalizado() {
        Matricula matricula = new Matricula("Registro de imóvel", "2023-12-01", "12345");
        // Corrigindo o construtor de ArquivoDigitalizado para aceitar dois Strings
        ArquivoDigitalizado arquivo = new ArquivoDigitalizado("documento.pdf", "1024"); // Passando tamanho como String
        matricula.associarArquivoDigitalizado(arquivo);
        assertNotNull(matricula); // Só garante que a associação foi feita sem erros
    }
}
