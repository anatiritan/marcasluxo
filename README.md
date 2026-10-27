# 💎 Projeto Java com Spring Boot — Marcas de Luxo

Projeto escolar de desenvolvimento de APIs RESTful com **Java** e **Spring Boot**, estruturado rigorosamente no padrão de arquitetura em camadas e operações de **CRUD** com persistência de dados via **Spring Data JPA** e **PostgreSQL**, utilizando **Lombok** para redução de código boilerplate.

---

## 🏛️ Tema do Projeto
O projeto gerencia o catálogo e cadastro de **Marcas de Luxo** (ex: Chanel, Gucci, Rolex, Prada, Louis Vuitton).

### Atributos da Entidade `Marca`:
* `id` (`Integer`): Identificador único no banco de dados (`GenerationType.IDENTITY`).
* `nomeMarca` (`String`): Nome da marca de luxo (ex: `"Chanel"`). Mapeado para `nome_marca`, tamanho máx. 100, não nulo.
* `anoFundacao` (`Integer`): Ano em que a grife foi fundada (ex: `1910`). Mapeado para `ano_fundacao`.
* `paisOrigem` (`String`): País onde nasceu a grife (ex: `"França"`). Mapeado para `pais_origem`, tamanho máx. 100.
* `categoria` (`String`): Segmento principal (ex: `"Alta Costura"`, `"Alta Relojoaria"`). Mapeado para `categoria`, tamanho máx. 50.
* `fundador` (`String`): Nome do(a) fundador(a) histórico(a) (ex: `"Coco Chanel"`). Mapeado para `fundador`, tamanho máx. 100.

---

## 🛠️ Tecnologias Utilizadas
* **Java 25 (compatível com 17+)**
* **Spring Boot 3 (3.4.1)**
* **Spring Data JPA** (Hibernate ORM)
* **PostgreSQL Driver** (com suporte runtime também para **H2 Database**)
* **Lombok** (`@Getter`, `@Setter`, `@Builder`, `@AllArgsConstructor`, `@NoArgsConstructor`, `@RequiredArgsConstructor`)
* **Maven** (Gerenciador de build e dependências)

---

## 📁 Estrutura do Projeto (Camadas)

```
com.marcasluxo
├── MarcasLuxoApplication.java                 # Ponto de entrada (Spring Boot Application)
│
├── controller/
│   └── MarcaController.java                   # Camada REST Controller (@RestController, @RequestMapping("/marca"))
│
├── business/
│   └── MarcaService.java                      # Camada de Negócio (@Service)
│
└── infrastructure/
    ├── entitys/
    │   └── Marca.java                         # Camada de Entidade (@Entity, @Table(name = "marca"), Lombok)
    └── repository/
        └── MarcaRepository.java               # Camada de Repositório (JpaRepository<Marca, Integer>)
```

---

## 📡 Endpoints da API (Rotas)

A rota base é **`/marca`**:

| Método HTTP | Endpoint / URL | Parâmetro / Corpo | Descrição |
|---|---|---|---|
| `POST` | `http://localhost:8080/marca` | JSON no Body | Cadastra uma nova marca no banco |
| `GET` | `http://localhost:8080/marca?nome={nome}` | Query Param `nome` | Busca uma marca específica pelo nome |
| `DELETE` | `http://localhost:8080/marca?nome={nome}` | Query Param `nome` | Deleta uma marca pelo nome |
| `PUT` | `http://localhost:8080/marca?id={id}` | Query Param `id` + JSON no Body | Atualiza os dados de uma marca existente |

---

## 📋 Exemplos de Requisições

### 1. Cadastrar Marca (`POST /marca`)
**URL:** `http://localhost:8080/marca`  
**Headers:** `Content-Type: application/json`  
**Body (JSON):**
```json
{
  "nomeMarca": "Chanel",
  "anoFundacao": 1910,
  "paisOrigem": "França",
  "categoria": "Alta Costura",
  "fundador": "Coco Chanel"
}
```
**Resposta:** `200 OK`

---

### 2. Buscar Marca por Nome (`GET /marca?nome=Chanel`)
**URL:** `http://localhost:8080/marca?nome=Chanel`  
**Resposta (`200 OK`):**
```json
{
  "id": 1,
  "nomeMarca": "Chanel",
  "anoFundacao": 1910,
  "paisOrigem": "França",
  "categoria": "Alta Costura",
  "fundador": "Coco Chanel"
}
```

---

### 3. Atualizar Marca por ID (`PUT /marca?id=1`)
**URL:** `http://localhost:8080/marca?id=1`  
**Headers:** `Content-Type: application/json`  
**Body (JSON):**
```json
{
  "categoria": "Alta Costura e Perfumaria"
}
```
*(Os campos omitidos mantêm os valores anteriores)*  
**Resposta:** `200 OK`

---

### 4. Deletar Marca por Nome (`DELETE /marca?nome=Chanel`)
**URL:** `http://localhost:8080/marca?nome=Chanel`  
**Resposta:** `200 OK`

---

## ⚙️ Configuração do Banco de Dados (`application.properties`)

```properties
spring.application.name=cadastro-marca

# Configuração PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/cadastro_marca
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate JPA
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> **Dica:** Para rodar o PostgreSQL, certifique-se de que o banco de dados `cadastro_marca` existe no PostgreSQL local (porta 5432).
