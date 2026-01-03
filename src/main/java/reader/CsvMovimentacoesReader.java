package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class CsvMovimentacoesReader {

    private static final int COL_AEROPORTO_REFERENCIA = 2;
    private static final int COL_OUTRO_AEROPORTO = 7;

    public Set<String> lerAeroportos(String caminhoArquivo) {

        Set<String> aeroportos = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {

                if (primeiraLinha || linha.startsWith("\"ANO\"")) {
                    primeiraLinha = false;
                    continue;
                }

                String[] colunas = linha.replace("\"", "").split(";");

                if (colunas.length <= COL_OUTRO_AEROPORTO) {
                    continue;
                }

                String aeroportoRef = normalizar(colunas[COL_AEROPORTO_REFERENCIA]);
                String outroAeroporto = normalizar(colunas[COL_OUTRO_AEROPORTO]);

                if (isIcaoAnalitico(aeroportoRef)) {
                    aeroportos.add(aeroportoRef);
                }

                if (isIcaoAnalitico(outroAeroporto)) {
                    aeroportos.add(outroAeroporto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return aeroportos;
    }

    private String normalizar(String valor) {
        return valor == null ? "" : valor.trim().toUpperCase();
    }

    // ICAO válido para análise de BI: 4 letras, Apenas A–Z, Aeroportos civis brasileiros relevantes

    private boolean isIcaoAnalitico(String codigo) {

        if (!codigo.matches("^[A-Z]{4}$")) {
            return false;
        }

        return codigo.startsWith("SB")
            || codigo.startsWith("SD")
            || codigo.startsWith("SJ")
            || codigo.startsWith("SP");
    }
}
