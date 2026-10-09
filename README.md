# 💎 Projeto Java com Spring Boot — Marcas de Luxo

Projeto escolar de introdução ao desenvolvimento de APIs RESTful com Java e Spring Boot, abordando o padrão de arquitetura em camadas e as operações básicas de **CRUD** (Create, Read, Update, Delete) com o tema **Marcas de Luxo**.

---

## 🏛️ Tema do Projeto
O projeto gerencia o cadastro simples de **marcas de luxo** (ex: Chanel, Gucci, Rolex).
Os dados armazenados para cada marca são:
* `id`: Identificador único no banco de dados (gerado automaticamente)
* `nome`: Nome da marca (ex: Chanel)
* `paisOrigem`: País onde a grife nasceu (ex: França)
* `anoFundacao`: Ano em que foi fundada (ex: 1910)
* `categoria`: Segmento da marca (ex: Moda, Relojoaria, Alta Costura)

---

## 🛠️ Tecnologias Utilizadas
* **Java 17+**
* **Spring Boot 3**
* **Spring Web** (para criar os endpoints REST)
* **Spring Data JPA** (para integração com o banco de dados)
* **H2 Database** (banco de dados em memória para testes)
* **Maven** (gerenciador de dependências do projeto)

---

## 📁 Estrutura das Camadas

```
com.marcasluxo
├── MarcasLuxoApplication.java                 # Classe principal que inicia o Spring Boot
├── controller/
│   └── MarcaController.java                   # Camada Controller (recebe as requisições HTTP)
├── business/
│   └── MarcaService.java                      # Camada Service (regras de negócio)
└── infrastructure/
    ├── entitys/
    │   └── Marca.java                         # Camada Entity (espelho da tabela no banco)
    └── repository/
        └── MarcaRepository.java               # Camada Repository (faz o acesso ao banco com JPA)
```

---

## 📡 Endpoints da API (Rotas)

| Método HTTP | Rota (URL) | O que faz? |
|---|---|---|
| `POST` | `http://localhost:8080/marcas` | Cadastra uma nova marca (envia JSON) |
| `GET` | `http://localhost:8080/marcas` | Lista todas as marcas cadastradas |
| `GET` | `http://localhost:8080/marcas/{id}` | Busca uma marca específica pelo ID |
| `DELETE` | `http://localhost:8080/marcas/{id}` | Deleta uma marca pelo ID |

### Exemplo de JSON para cadastrar uma marca no POST:
```json
{
  "nome": "Chanel",
  "paisOrigem": "França",
  "anoFundacao": 1910,
  "categoria": "Alta Costura"
}
```

---

## 🗣️ Roteiro de Apresentação (O que falar para a Professora!)

Se a professora pedir para você explicar o código, use este resumo simples:

1. **Classe `Marca.java` (Entidade):**
   > *"Professora, aqui está a nossa Entidade. Eu usei a anotação `@Entity` e `@Table(name = "marcas")` para dizer ao Spring que essa classe vai virar uma tabela no banco H2. O `@Id` e `@GeneratedValue` cuidam do ID automático, e criei os atributos do meu tema, construtores, getters e setters."*

2. **Interface `MarcaRepository.java` (Repositório):**
   > *"Esta é a camada de dados. Eu criei uma interface que estende o `JpaRepository`. Graças ao Spring Data JPA, a gente não precisa escrever comandos SQL na mão; ele já traz métodos como `save()`, `findAll()` e `deleteById()` prontos."*

3. **Classe `MarcaService.java` (Serviço):**
   > *"Aqui fica a camada de negócio (`@Service`). É ela quem chama o repositório para salvar, listar e excluir. Separei essa camada para manter o código organizado e seguir as boas práticas de arquitetura."*

4. **Classe `MarcaController.java` (Controlador):**
   > *"Por fim, o Controller (`@RestController`) é quem expõe as rotas na web com o `@RequestMapping("/marcas")`. Nele eu criei os métodos `@PostMapping` para cadastrar, `@GetMapping` para listar e buscar por ID, e `@DeleteMapping` para excluir."*

---

## 🚀 Como Executar o Projeto

1. Abra a pasta do projeto no **IntelliJ IDEA**.
2. Abra o arquivo `MarcasLuxoApplication.java`.
3. Clique no botão de **Play verde ▶️**.
4. Acesse no navegador:
   * **Listar marcas:** `http://localhost:8080/marcas`
   * **Console do H2:** `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:marcasluxodb` | User: `sa` | Senha em branco)
