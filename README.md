# Ranking de Funcionários

Este projeto é uma **API REST** desenvolvida em **Spring Boot** para gerenciar um **ranking de funcionários** para o setor comercial de empresas, permitindo a **criação, atualização, remoção e pontuação** de cada colaborador.

##  Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **Banco de Dados H2** (para desenvolvimento e testes)
- **Lombok**
- **Postman** (para testes de API)
 
##  Configuração do Projeto
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/ranking.git
   cd ranking-funcionarios
   ```
2. Configure o banco de dados (padrão: H2, pode ser alterado no `application.properties`):
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   ```
3. Execute a aplicação com:
   ```sh
   mvn spring-boot:run
   ```
4. A API estará disponível em `http://localhost:8080`

##  Endpoints Disponíveis

### 1. Criar um Funcionário
- **URL:** `POST /funcionarios/criar`
- **Body (JSON):**
  ```json
  {
    "nome": "João Silva",
    "pontos": 0,
    "meta": "Vender 10 produtos"
  }
  ```
- **Resposta:**
  ```json
  {
    "id": 1,
    "nome": "João Silva",
    "pontos": 0,
    "meta": "Vender 10 produtos"
  }
  ```

### 2. Listar Ranking de Funcionários
- **URL:** `GET /funcionarios/ranking`
- **Resposta:**
  ```json
  [
    {
      "id": 1,
      "nome": "João Silva",
      "pontos": 10,
      "meta": "Vender 10 produtos"
    },
    {
      "id": 2,
      "nome": "Maria Souza",
      "pontos": 5,
      "meta": "Atender 20 clientes"
    }
  ]
  ```

### 3. Adicionar Pontos a um Funcionário
- **URL:** `POST /funcionarios/{id}/adicionar-pontos?pontos=10`
- **Exemplo:**
  ```http
  POST /funcionarios/1/adicionar-pontos?pontos=10 HTTP/1.1
  Host: localhost:8080
  ```
- **Resposta:**
  ```json
  {
    "id": 1,
    "nome": "João Silva",
    "pontos": 10,
    "meta": "Vender 10 produtos"
  }
  ```

### 4. Atualizar um Funcionário
- **URL:** `PUT /funcionarios/{id}`
- **Body (JSON):**
  ```json
  {
    "nome": "João Silva",
    "pontos": 20,
    "meta": "Vender 15 produtos"
  }
  ```
- **Resposta:**
  ```json
  {
    "id": 1,
    "nome": "João Silva",
    "pontos": 20,
    "meta": "Vender 15 produtos"
  }
  ```

### 5. Excluir um Funcionário
- **URL:** `DELETE /funcionarios/{id}`
- **Exemplo:**
  ```http
  DELETE /funcionarios/1 HTTP/1.1
  Host: localhost:8080
  ```
- **Resposta:**
  ```json
  {
    "mensagem": "Funcionário removido com sucesso!"
  }
  ```

##  Estrutura do Projeto
```
ranking-funcionarios/
├── src/main/java/com/ranking/ranking/
│   ├── controller/FuncionarioController.java
│   ├── entity/Funcionario.java
│   ├── repository/FuncionarioRepository.java
│   ├── service/FuncionarioService.java
│   ├── RankingApplication.java
├── src/main/resources/
│   ├── application.properties
├── pom.xml
└── README.md
```

##  Melhorias Futuras
- Implementação de **autenticação** via **Spring Security**
- Persistência em banco de dados **PostgreSQL ou MySQL**
- Adição de **logs e monitoramento** com **Spring Actuator**
- Criação de um **front-end** para exibição do ranking

##  Autor
**Gabriel** - Desenvolvedor Back-End

