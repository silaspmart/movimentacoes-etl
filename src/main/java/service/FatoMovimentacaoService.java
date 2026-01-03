package service;

import model.FatoMovimentacao;
import reader.CsvMovimentacoesReader;
import repository.DimAeroportoRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FatoMovimentacaoService {

    // Índices das colunas no CSV (já saneado com replace de aspas)
    private static final int COL_AEROPORTO_REFERENCIA = 2;
    private static final int COL_TIPO_MOVIMENTO = 3;
    private static final int COL_OUTRO_AEROPORTO = 7;
    private static final int COL_DT_TOQUE = 15;
    private static final int COL_HH_TOQUE = 16;
    private static final int COL_QT_PAX_LOCAL = 20;
    private static final int COL_QT_PAX_CONEXAO_DOM = 21;
    private static final int COL_QT_PAX_CONEXAO_INT = 22;
    private static final int COL_QT_CORREIO = 23;
    private static final int COL_QT_CARGA = 24;

    public List<FatoMovimentacao> gerarFato(
            String caminhoCsv,
            DimAeroportoRepository aeroportoRepository) {

        List<FatoMovimentacao> fatos = new ArrayList<>();
        int movimentacaoKey = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoCsv))) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {

                if (primeiraLinha || linha.startsWith("\"ANO\"")) {
                    primeiraLinha = false;
                    continue;
                }

                String[] colunas = linha.replace("\"", "").split(";");

                if (colunas.length <= COL_QT_CARGA) {
                    continue;
                }

                String icaoOrigem = colunas[COL_AEROPORTO_REFERENCIA].trim();
                String icaoDestino = colunas[COL_OUTRO_AEROPORTO].trim();

                Integer origemKey = aeroportoRepository.getKey(icaoOrigem);
                Integer destinoKey = aeroportoRepository.getKey(icaoDestino);

                // Só gera FATO se ambos existirem na DIM
                if (origemKey == null || destinoKey == null) {
                    continue;
                }

                String tipoMovimento = colunas[COL_TIPO_MOVIMENTO];
                String dataOperacao = colunas[COL_DT_TOQUE];
                String horaOperacao = colunas[COL_HH_TOQUE];

                int paxLocal = parseInt(colunas[COL_QT_PAX_LOCAL]);
                int paxDom = parseInt(colunas[COL_QT_PAX_CONEXAO_DOM]);
                int paxInt = parseInt(colunas[COL_QT_PAX_CONEXAO_INT]);

                int qtdPaxTotal = paxLocal + paxDom + paxInt;
                int qtdCorreio = parseInt(colunas[COL_QT_CORREIO]);
                int qtdCarga = parseInt(colunas[COL_QT_CARGA]);

                FatoMovimentacao fato = new FatoMovimentacao(
                        movimentacaoKey++,
                        origemKey,
                        destinoKey,
                        dataOperacao,
                        horaOperacao,
                        tipoMovimento,
                        qtdPaxTotal,
                        qtdCarga,
                        qtdCorreio
                );

                fatos.add(fato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fatos;
    }

    private int parseInt(String valor) {
        try {
            return Integer.parseInt(valor.trim());
        } catch (Exception e) {
            return 0;
        }
    }
}
