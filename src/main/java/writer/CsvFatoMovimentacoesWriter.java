package writer;

import model.FatoMovimentacao;

import java.io.FileWriter;
import java.util.List;

public class CsvFatoMovimentacoesWriter {

    public void escrever(String caminhoSaida, List<FatoMovimentacao> fatos) {

        try (FileWriter writer = new FileWriter(caminhoSaida)) {

            // Cabeçalho da FATO
            writer.write(
                "MovimentacaoKey;" +
                "AeroportoOrigemKey;" +
                "AeroportoDestinoKey;" +
                "DataOperacao;" +
                "HoraOperacao;" +
                "TipoMovimento;" +
                "QtdPaxTotal;" +
                "QtdCarga;" +
                "QtdCorreio\n"
            );

            for (FatoMovimentacao fato : fatos) {
                writer.write(fato.toCsv());
                writer.write("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
