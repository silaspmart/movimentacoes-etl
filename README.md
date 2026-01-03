# ✈️ Movimentações Aeroportuárias — ETL em Java & Power BI

Projeto de **ETL em Java** para tratamento de dados de movimentações aeroportuárias, com saída analítica em **modelo estrela** para consumo no **Power BI**.

---

## 🎯 Objetivo

Transformar dados brutos de movimentação aeroportuária em informações analíticas confiáveis, permitindo análises de:

- Movimentações (pousos e decolagens)
- Passageiros
- Carga e correio
- Distribuição temporal e operacional

---

## 🏗️ Arquitetura

CSV bruto (dados.gov.br)
        ↓
ETL em Java
        ↓
Modelo Dimensional (CSV)
        ↓
Power BI

## 📁 Estrutura do Projeto

```text
movimentacoes-etl/
├── data/
│   ├── Dim_Aeroporto.csv
│   └── Fato_Movimentacoes.csv
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
```
## 🧠 Modelagem

- Fato_Movimentacoes
- Origem / Destino
- Data e hora da operação
- Tipo de movimento (P/D)
- Passageiros, carga e correio
- Dim_Aeroporto
- Chave substituta
- Código ICAO
- Modelo estruturado em esquema estrela.

## 📊 Camada Analítica (Power BI)

- Modelo estrela
- Medidas DAX encapsuladas
- KPIs operacionais
- Rankings, Pareto e análises temporais

## 📅 Período Analisado

06/2025

## 🌐 Fonte dos Dados

#### Dados públicos do portal oficial do governo:

- https://dados.gov.br/dados/conjuntos-dados/operador-aeroportuario-dados-de-movimentacao-aeroportuaria

## 🛠️ Tecnologias

- Java
- Power BI
- DAX
- Git / GitHub
- Modelagem Dimensional
