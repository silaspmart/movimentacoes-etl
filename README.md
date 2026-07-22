# Movimentações ETL - Java

Pipeline ETL desenvolvido em **Java 21 LTS** para transformar dados operacionais de movimentações aeroportuárias em uma estrutura analítica composta por **tabela dimensão** e **tabela fato**, preparada para consumo no **Power BI**.

O projeto simula um processo de Engenharia de Dados utilizado em ambientes corporativos, realizando a leitura, transformação, padronização e modelagem dos dados para geração de indicadores de Business Intelligence.

---

## Objetivo

Desenvolver uma aplicação Java capaz de transformar um conjunto de dados operacionais em um modelo dimensional simplificado, demonstrando conceitos de:

- Engenharia de Dados
- Processos ETL (Extract, Transform and Load)
- Programação Orientada a Objetos
- Modelagem Dimensional
- Preparação de dados para Business Intelligence

---

# Valor para o negócio

Em ambientes corporativos, dados operacionais normalmente não estão estruturados para análises gerenciais.

Este projeto demonstra como um processo ETL pode:

- transformar dados brutos em informações organizadas;
- padronizar registros antes da análise;
- reduzir retrabalho na preparação de dados;
- criar uma base consistente para dashboards e indicadores;
- separar dados transacionais em tabelas dimensionais e fatos, seguindo boas práticas de Data Warehouse.

---

## Fluxo do processo

| Etapa | Descrição |
|-------|-----------|
| 📥 Entrada | Dados operacionais da ANAC |
| 📖 Leitura | Importação do arquivo CSV |
| 🧹 Tratamento | Padronização e limpeza dos dados |
| ✈️ Dimensão | Identificação dos aeroportos únicos e geração da `Dim_Aeroporto` |
| 🔗 Relacionamento | Associação das chaves de origem e destino |
| 📊 Fato | Geração da tabela `Fato_Movimentacoes` |
| 📈 Visualização | Consumo dos arquivos no Power BI |

---

## Estrutura do projeto

movimentacoes-etl/
│
├── data/
│   ├── Dim_Aeroporto.csv
│   ├── Fato_Movimentacoes.csv
│   └── Movimentacoes.pdf
│
├── src/
│   └── main/
│       └── java/
│           ├── model/
│           ├── reader/
│           ├── repository/
│           ├── service/
│           ├── writer/
│           └── Main.java
│
└── README.md
```

---

# Tecnologias utilizadas

- Java 21 LTS
- Programação Orientada a Objetos (POO)
- Java IO
- Collections Framework
- Manipulação de arquivos CSV
- ETL
- Modelagem Dimensional
- Power BI

---

# Processo ETL

## Extração

Leitura do arquivo de movimentações aeroportuárias contendo registros operacionais.

Responsável por:

- abertura do arquivo;
- leitura linha a linha;
- identificação dos aeroportos presentes no conjunto de dados.

---

## Transformação

Durante esta etapa são realizadas diversas transformações:

- normalização dos códigos ICAO;
- eliminação de registros inválidos;
- identificação de aeroportos únicos;
- geração de chaves substitutas (Surrogate Keys);
- cálculo da quantidade total de passageiros;
- relacionamento entre aeroportos de origem e destino.

---

## Carga

Após o processamento são gerados dois arquivos analíticos.

### Dim_Aeroporto.csv

Tabela dimensão contendo:

- AeroportoKey
- Código ICAO

---

### Fato_Movimentacoes.csv

Tabela fato contendo:

- MovimentacaoKey
- AeroportoOrigemKey
- AeroportoDestinoKey
- Data da operação
- Hora da operação
- Tipo de movimentação
- Quantidade de passageiros
- Quantidade de carga
- Quantidade de correio

---

# Organização do código

O projeto foi dividido em responsabilidades independentes.

| Camada | Responsabilidade |
|---------|------------------|
| model | Modelos de domínio |
| reader | Leitura dos arquivos de origem |
| service | Regras de negócio e transformações |
| repository | Consulta das dimensões geradas |
| writer | Escrita dos arquivos finais |

Essa organização facilita manutenção, reutilização e evolução da aplicação.

---

# Resultados

Ao final da execução são produzidos:

- Dim_Aeroporto.csv
- Fato_Movimentacoes.csv

Esses arquivos servem como base para construção de dashboards e análises em ferramentas de Business Intelligence.

---

## 📊 Dashboard Power BI

Os arquivos gerados pelo processo ETL foram utilizados para construir um dashboard analítico no Power BI, permitindo explorar indicadores de movimentação aeroportuária de forma visual.

<table align="center">
  <tr>
    <td align="center">
      <img src="https://github.com/user-attachments/assets/130e9fd1-0ff4-4d37-b71e-161873366ba7" width="420"><br>
      <b>Visão Geral</b>
    </td>
    <td align="center">
      <img src="https://github.com/user-attachments/assets/5cf6a48d-efc3-42c2-a796-28dac74da7d8" width="420"><br>
      <b>Análise Temporal</b>
    </td>
  </tr>
</table>

<p align="center">
  <img src="https://github.com/user-attachments/assets/3ecc107e-fb60-49c5-b43e-e05259301b20" width="600"><br>
  <b>Detalhamento das Movimentações</b>
</p>

# Aprendizados

Durante o desenvolvimento deste projeto foram praticados conceitos como:

- Programação Orientada a Objetos
- Separação de responsabilidades
- Leitura e escrita de arquivos
- Estruturas de dados
- Manipulação de CSV
- Engenharia de Dados
- ETL
- Modelagem Dimensional
- Preparação de dados para BI

---

# Melhorias futuras

- Utilização de banco de dados relacional em substituição aos arquivos CSV.
- Implementação de testes automatizados.
- Inclusão de logs estruturados.
- Processamento de múltiplos arquivos de entrada.
- Parametrização dos caminhos dos arquivos.
- Exportação para outros formatos além de CSV.

---

# Versionamento

| Versão | Descrição |
|---------|-----------|
| **1.0** | Pipeline ETL em Java para geração de tabela dimensão e tabela fato a partir de dados de movimentações aeroportuárias. |
| **1.1** *(planejada)* | Melhorias na documentação, processamento incremental e evolução do pipeline. |

---

# Autor

**Silas Pereira Martins**

Engenheiro de Produção em transição para a área de Dados, com foco em Engenharia de Dados, Business Intelligence e Desenvolvimento Back-end.

- GitHub: https://github.com/silaspmart
- LinkedIn: https://www.linkedin.com/in/silas-martins-97b69194/

---
