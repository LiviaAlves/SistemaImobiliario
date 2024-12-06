import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImovelTest {

    private Imovel imovel;
    private ProprietarioObserver observer;

    // Classe fake para simular o comportamento do observador
    private class FakeProprietarioObserver implements ProprietarioObserver {
        String ultimaMensagem;

        @Override
        public void notificar(String mensagem) {
            this.ultimaMensagem = mensagem;
        }
    }

    @BeforeEach
    void setUp() {
        // Usando a implementação fake para o observador
        observer = new FakeProprietarioObserver();

        // Criando o imóvel
        imovel = new Imovel("Rua X, 123", 100, 300000, "12345", "Casa", "Casa de 3 quartos");
        imovel.registrarObservador(observer);  // Registrando o observador
    }

    @Test
    void testAlterarEnderecoNotificaObservador() {
        imovel.setEndereco("Rua Y, 456");

        // Verificando se o observador foi notificado com a mensagem correta
        assertEquals("O endereço do imóvel foi alterado para: Rua Y, 456", ((FakeProprietarioObserver) observer).ultimaMensagem);
    }

    @Test
    void testAlterarValorCadastralNotificaObservador() {
        imovel.setValorCadastral(350000);

        // Verificando se o observador foi notificado com a mensagem correta
        assertEquals("O valor cadastral do imóvel foi alterado para: R$350000.0", ((FakeProprietarioObserver) observer).ultimaMensagem);
    }

    @Test
    void testAlterarTipoNotificaObservador() {
        imovel.setTipo("Apartamento");

        // Verificando se o observador foi notificado com a mensagem correta
        assertEquals("O tipo do imóvel foi alterado para: Apartamento", ((FakeProprietarioObserver) observer).ultimaMensagem);
    }

    @Test
    void testAlterarDescricaoNotificaObservador() {
        imovel.setDescricao("Apartamento de 2 quartos");

        // Verificando se o observador foi notificado com a mensagem correta
        assertEquals("A descrição do imóvel foi alterada para: Apartamento de 2 quartos", ((FakeProprietarioObserver) observer).ultimaMensagem);
    }


    @Test
    void testBuscarImovelPorEndereco() {
        Imovel encontrado = imovel.buscarImovelPorEndereco("Rua X, 123");
        assertNotNull(encontrado, "Deve encontrar o imóvel pelo endereço.");

        Imovel naoEncontrado = imovel.buscarImovelPorEndereco("Rua Z, 789");
        assertNull(naoEncontrado, "Não deve encontrar o imóvel com o endereço errado.");
    }
}
