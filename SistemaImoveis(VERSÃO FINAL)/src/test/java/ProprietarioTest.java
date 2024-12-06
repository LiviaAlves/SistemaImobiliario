import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioTest {

    @Test
    public void testCriarProprietario() {
        Proprietario proprietario = new Proprietario("João Silva", "12345678900");
        assertEquals("João Silva", proprietario.getNome());
        assertEquals("12345678900", proprietario.getCpf());
    }

    @Test
    public void testListarImoveis() {
        Proprietario proprietario = new Proprietario("João Silva", "12345678900");
        assertEquals(0, proprietario.listarImoveisPorProprietario().size());
    }

    @Test
    public void testBuscarProprietarioPorNome() {
        Proprietario proprietario = new Proprietario("João Silva", "12345678900");
        assertNotNull(proprietario.buscarProprietarioPorNome("João Silva"));
        assertNull(proprietario.buscarProprietarioPorNome("Maria"));
    }
}
