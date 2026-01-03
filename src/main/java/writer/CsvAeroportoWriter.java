package writer;

import model.Aeroporto;

import java.io.FileWriter;
import java.util.List;

public class CsvAeroportoWriter {

    public void escrever(String caminhoSaida, List<Aeroporto> aeroportos) {

        try (FileWriter writer = new FileWriter(caminhoSaida)) {

            writer.write("AeroportoKey;ICAO\n");

            for (Aeroporto a : aeroportos) {
                writer.write(a.getAeroportoKey() + ";" + a.getIcao() + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
