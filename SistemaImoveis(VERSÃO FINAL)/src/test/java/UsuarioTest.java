import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioTest {

    @Test
    public void testAutenticarUsuario() {
        Usuario usuario = new Usuario("João", "joao@email.com", "1234");
        assertTrue(usuario.autenticarUsuario("joao@email.com", "1234"));
        assertFalse(usuario.autenticarUsuario("joao@email.com", "senhaerrada"));
    }

    @Test
    public void testListarPermissoes() {
        Usuario usuario = new Usuario("João", "joao@email.com", "1234");
        List<String> permissoes = usuario.listarPermissoes();
        assertTrue(permissoes.contains("Visualizar Imóveis"));
        assertTrue(permissoes.contains("Cadastrar Imóveis"));
        assertTrue(permissoes.contains("Editar Proprietários"));
    }

    @Test
    public void testBuscarUsuarioPorNome() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("João", "joao@email.com", "1234"));
        usuarios.add(new Usuario("Maria", "maria@email.com", "5678"));

        Usuario usuario = Usuario.buscarUsuarioPorNome("João", usuarios);
        assertNotNull(usuario);
        assertEquals("João", usuario.getNome());

        assertNull(Usuario.buscarUsuarioPorNome("Pedro", usuarios));
    }
}
