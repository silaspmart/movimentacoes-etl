package repository;

import java.io.*;
import java.util.*;

public class DimAeroportoRepository {

    private final Map<String, Integer> aeroportoKeyPorIcao = new HashMap<>();

    public DimAeroportoRepository(String caminhoDimAeroporto) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDimAeroporto))) {
            br.readLine(); // header

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                int key = Integer.parseInt(campos[0]);
                String icao = campos[1];

                aeroportoKeyPorIcao.put(icao, key);
            }
        }
    }

    public Integer getKey(String icao) {
        return aeroportoKeyPorIcao.get(icao);
    }
}
