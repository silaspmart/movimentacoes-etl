package model;

public class Aeroporto {

    private int aeroportoKey;
    private String icao;

    public Aeroporto(int aeroportoKey, String icao) {
        this.aeroportoKey = aeroportoKey;
        this.icao = icao;
    }

    public int getAeroportoKey() {
        return aeroportoKey;
    }

    public String getIcao() {
        return icao;
    }
}
