import java.util.ArrayList;
import java.util.List;

public class ArquivoDigitalizado {
    private String arquivo;
    private String dataUpload;

    private static List<ArquivoDigitalizado> arquivos = new ArrayList<>();

    public ArquivoDigitalizado(String arquivo, String dataUpload) {
        this.arquivo = arquivo;
        this.dataUpload = dataUpload;
        arquivos.add(this);
    }

    public void exibirArquivoDigitalizado() {
        System.out.println("Exibindo arquivo: " + arquivo);
    }

    public List<ArquivoDigitalizado> buscarArquivosPorData(String dataUpload) {
        List<ArquivoDigitalizado> resultado = new ArrayList<>();
        for (ArquivoDigitalizado arquivo : arquivos) {
            if (arquivo.dataUpload.equals(dataUpload)) {
                resultado.add(arquivo);
            }
        }
        return resultado;
    }

    public String extrairTextoOCR() {
        return "Texto extraído do arquivo: " + arquivo;
    }
}
