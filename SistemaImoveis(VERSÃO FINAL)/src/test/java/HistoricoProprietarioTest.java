import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HistoricoProprietarioTest {

    @Test
    void testListarHistoricoPorImovel() {
        // Criando os objetos necessários
        Imovel imovel = new Imovel("Rua X, 123", 100, 300000, "12345", "Casa", "Casa de 3 quartos");
        Proprietario proprietario1 = new Proprietario("José da Silva", "1329194845");  // Incluindo o CPF

        // Criando o objeto HistoricoProprietario
        HistoricoProprietario historico1 = new HistoricoProprietario("2020-01-01", "2023-01-01", imovel, proprietario1);

        // Aqui estamos passando o ID do imóvel (12345 como int)
        assertEquals(1, historico1.listarHistoricoPorImovel(12345).size());  // Passando ID do imóvel como int
    }

    @Test
    void testListarHistoricoPorProprietario() {
        // Criando os objetos necessários
        Imovel imovel = new Imovel("Rua X, 123", 100, 300000, "12345", "Casa", "Casa de 3 quartos");
        Proprietario proprietario3 = new Proprietario("José da Silva", "1329194845");  // Incluindo o CPF

        // Criando o objeto HistoricoProprietario
        HistoricoProprietario historico3 = new HistoricoProprietario("2020-01-01", "2023-01-01", imovel, proprietario3);

        // Vamos passar o CPF diretamente em vez do ID (não temos ID, só CPF no código).
        assertEquals(2, historico3.listarHistoricoPorProprietario(1329194845).size());  // Passando CPF como argumento
    }
}
