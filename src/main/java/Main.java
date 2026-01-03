import reader.CsvMovimentacoesReader;
import service.AeroportoService;
import service.FatoMovimentacaoService;
import writer.CsvAeroportoWriter;
import writer.CsvFatoMovimentacoesWriter;
import repository.DimAeroportoRepository;

public class Main {

    public static void main(String[] args) {

        String caminhoCsvEntrada = "data/Movimentacoes_Aeroportuarias_202506.csv";

        String caminhoDimAeroporto = "data/Dim_Aeroporto.csv";
        String caminhoFatoMovimentacoes = "data/Fato_Movimentacoes.csv";

        try {

            /* =========================
               1) GERAR DIM_AEROPORTO
               ========================= */
            CsvMovimentacoesReader reader = new CsvMovimentacoesReader();
            AeroportoService aeroportoService = new AeroportoService();
            CsvAeroportoWriter aeroportoWriter = new CsvAeroportoWriter();

            var icaos = reader.lerAeroportos(caminhoCsvEntrada);
            var dimAeroporto = aeroportoService.gerarDimensao(icaos);
            aeroportoWriter.escrever(caminhoDimAeroporto, dimAeroporto);

            System.out.println("DIM_AEROPORTO gerada com sucesso.");

            /* =========================
               2) CARREGAR DIM NO REPOSITORY
               ========================= */
            DimAeroportoRepository aeroportoRepository =
                    new DimAeroportoRepository(caminhoDimAeroporto);

            /* =========================
               3) GERAR FATO_MOVIMENTACOES
               ========================= */
            FatoMovimentacaoService fatoService =
                    new FatoMovimentacaoService();

            var fatos = fatoService.gerarFato(
                    caminhoCsvEntrada,
                    aeroportoRepository
            );

            /* =========================
               4) GRAVAR FATO_MOVIMENTACOES
               ========================= */
            CsvFatoMovimentacoesWriter fatoWriter =
                    new CsvFatoMovimentacoesWriter();

            fatoWriter.escrever(caminhoFatoMovimentacoes, fatos);

            System.out.println("FATO_MOVIMENTACOES gerada com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
