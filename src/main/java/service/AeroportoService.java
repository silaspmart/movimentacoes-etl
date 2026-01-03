package service;

import model.Aeroporto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AeroportoService {

    public List<Aeroporto> gerarDimensao(Set<String> icaos) {

        List<Aeroporto> aeroportos = new ArrayList<>();
        int chave = 1;

        for (String icao : icaos) {
            aeroportos.add(new Aeroporto(chave++, icao));
        }

        return aeroportos;
    }
}