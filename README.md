# 💎 Marcas de Luxo — API RESTful com Spring Boot

Projeto desenvolvido para a disciplina escolar de Programação / Desenvolvimento Java, implementando um sistema completo de **CRUD (Create, Read, Update, Delete)** para o catálogo e gerenciamento de **Marcas de Luxo mundiais**.

O projeto foi construído seguindo fielmente a arquitetura ensinada no tutorial de referência da instrutora Angélica Weiler (**Javanauta - CRUD Java com Spring Boot 2025**).

---

## 🏛️ Tema do Projeto
Gerenciamento de grifes e marcas de alto padrão (alta costura, alta relojoaria, joalheria, superesportivos e perfumaria). O sistema permite cadastrar novas marcas, consultar informações detalhadas, filtrar por categorias e países, atualizar dados cadastrais e remover registros.

---

## 🛠️ Tecnologias Utilizadas
* **Java 17+ (JDK 17, 21 ou 23)**
* **Spring Boot 3.4.x**
* **Spring Data JPA** (Hibernate ORM)
* **H2 Database** (Banco de dados em memória para testes rápidos sem necessidade de instalar SGBD)
* **Lombok** (Para simplificação de código com `@Getter`, `@Setter`, `@Builder`, etc.)
* **Maven** (Gerenciador de dependências e build)
* **HTML5 / CSS3 / JavaScript Moderno** (Dashboard visual responsivo incluso em `src/main/resources/static/index.html`)

---

## 📁 Arquitetura do Projeto (Camadas)

A organização das classes segue rigorosamente o padrão em camadas ensinado na aula:

```
src/main/java/com/marcasluxo/
│
├── MarcasLuxoApplication.java                 # Classe de inicialização (Spring Boot)
│
├── config/
│   └── DataLoader.java                        # Pré-popula o banco H2 com marcas famosas ao iniciar
│
├── controller/
│   └── MarcaController.java                   # Camada de controle REST (Endpoints HTTP)
│
├── business/
│   └── MarcaService.java                      # Camada de regras de negócio e validações
│
└── infrastructure/
    ├── entitys/
    │   └── Marca.java                         # Entidade relacional mapeada com JPA/Hibernate
    └── repository/
        └── MarcaRepository.java               # Interface de acesso a dados (Spring Data JPA)
```

---

## 🚀 Como Executar o Projeto

### Opção 1: Pela sua IDE (IntelliJ IDEA, Eclipse ou VS Code)
1. Abra a pasta `marcasluxo` na sua IDE.
2. Aguarde o Maven baixar as dependências automaticamente.
3. Localize o arquivo principal:
   `src/main/java/com/marcasluxo/MarcasLuxoApplication.java`
4. Clique com o botão direito e selecione **Run 'MarcasLuxoApplication'**.
5. A aplicação subirá na porta `8080`.

### Opção 2: Pelo Terminal
Na pasta do projeto, execute:
```bash
mvn spring-boot:run
```
*(ou se preferir com o wrapper: `./mvnw spring-boot:run`)*

---

## 🖥️ Acessando a Aplicação

Depois de rodar o projeto, abra seu navegador:

1. **Dashboard Visual Completo:**
   👉 `http://localhost:8080`
   *(Uma interface espetacular estilo "Dark & Gold" onde você pode testar todo o CRUD visualmente: cadastrar marcas, ver os cards, buscar em tempo real, editar e excluir!)*

2. **Console do Banco H2:**
   👉 `http://localhost:8080/h2-console`
   * **JDBC URL:** `jdbc:h2:mem:marcasluxodb`
   * **User Name:** `sa`
   * **Password:** *(deixar em branco)*
   * Clique em **Connect** para visualizar a tabela `MARCAS` e executar SQL diretamente!

---

## 📡 Endpoints da API REST

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/marcas` | Retorna todas as marcas de luxo cadastradas |
| `GET` | `/marcas/{id}` | Busca uma marca específica pelo ID |
| `GET` | `/marcas/busca?nome=Chanel` | Busca uma marca pelo nome |
| `GET` | `/marcas/categoria/{categoria}` | Filtra marcas por segmento (ex: Alta Relojoaria) |
| `GET` | `/marcas/pais/{pais}` | Filtra marcas pelo país de origem (ex: França, Itália) |
| `POST` | `/marcas` | Cadastra uma nova marca de luxo |
| `PUT` | `/marcas/{id}` | Atualiza os dados de uma marca existente pelo ID |
| `DELETE` | `/marcas/{id}` | Remove uma marca pelo ID |

---

### Exemplo de JSON para Cadastro (`POST /marcas`):

```json
{
  "nome": "Balenciaga",
  "paisOrigem": "Espanha",
  "anoFundacao": 1919,
  "categoria": "Alta Costura & Calçados",
  "faturamentoBilhoes": 2.5,
  "descricao": "Famosa pelas criações conceituais, alfaiataria inovadora e tênis de luxo icônicos.",
  "siteOficial": "https://www.balenciaga.com"
}
```

---

## 📤 Como Enviar o Projeto para o seu GitHub

Para enviar o código para o seu repositório `https://github.com/anatiritan/marcasluxo.git`:

```bash
cd /Users/ra2457043/.gemini/antigravity/scratch/marcasluxo

# 1. Iniciar o repositório git (já inicializado)
git init

# 2. Adicionar todos os arquivos
git add .

# 3. Criar o commit inicial
git commit -m "feat: CRUD de Marcas de Luxo com Spring Boot e H2"

# 4. Apontar para o repositório remoto
git remote add origin https://github.com/anatiritan/marcasluxo.git

# 5. Renomear para a branch main e enviar
git branch -M main
git push -u origin main
```

*(Se o Git solicitar autenticação, use seu Personal Access Token ou faça login com suas credenciais do GitHub).*

---

## 👩‍💻 Autora & Créditos
* **Tema Escolar:** Marcas de Luxo
* **Autora do Projeto:** Anatiritan
* **Tutorial de Inspiração:** Angélica Weiler ([Canal Javanauta](https://www.youtube.com/@Javanauta))
