package model;

public class FatoMovimentacao {

    private final int movimentacaoKey;

    private final int aeroportoOrigemKey;
    private final int aeroportoDestinoKey;

    private final String dataOperacao;   // YYYY-MM-DD
    private final String horaOperacao;   // HH:MM:SS

    private final String tipoMovimento;  // P ou D

    private final int qtdPaxTotal;
    private final int qtdCarga;
    private final int qtdCorreio;

    public FatoMovimentacao(
            int movimentacaoKey,
            int aeroportoOrigemKey,
            int aeroportoDestinoKey,
            String dataOperacao,
            String horaOperacao,
            String tipoMovimento,
            int qtdPaxTotal,
            int qtdCarga,
            int qtdCorreio) {

        this.movimentacaoKey = movimentacaoKey;
        this.aeroportoOrigemKey = aeroportoOrigemKey;
        this.aeroportoDestinoKey = aeroportoDestinoKey;
        this.dataOperacao = dataOperacao;
        this.horaOperacao = horaOperacao;
        this.tipoMovimento = tipoMovimento;
        this.qtdPaxTotal = qtdPaxTotal;
        this.qtdCarga = qtdCarga;
        this.qtdCorreio = qtdCorreio;
    }

    public String toCsv() {
        return movimentacaoKey + ";" +
               aeroportoOrigemKey + ";" +
               aeroportoDestinoKey + ";" +
               dataOperacao + ";" +
               horaOperacao + ";" +
               tipoMovimento + ";" +
               qtdPaxTotal + ";" +
               qtdCarga + ";" +
               qtdCorreio;
    }
}