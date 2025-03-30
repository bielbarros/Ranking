# Ranking de Funcionários

Este projeto é uma API REST desenvolvida em **Spring Boot** para gerenciar um ranking de funcionários, permitindo a criação de perfis e a adicição de pontos.

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **Banco de Dados H2 (para desenvolvimento e testes)**
- **Lombok**
- **Postman (para testes de API)**

## Configuração do Projeto
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/ranking-funcionarios.git
   cd ranking-funcionarios
   ```
2. Configure o banco de dados (padrão: H2, mas pode ser alterado no `application.properties`):
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

## Endpoints Disponíveis

### 1. Criar um Funcionário
- **URL:** `POST /funcionarios/criar`
- **Body (JSON):**
  ```json
  {
    "nome": "João Silva",
    "pontos": 0
  }
  ```
- **Resposta:**
  ```json
  {
    "id": 1,
    "nome": "João Silva",
    "pontos": 0
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
      "pontos": 10
    },
    {
      "id": 2,
      "nome": "Maria Souza",
      "pontos": 5
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
    "pontos": 10
  }
  ```

## Estrutura do Projeto
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

## Melhorias Futuras
- Implementação de autenticação via **Spring Security**
- Implementação de um **front-end** para visualizar o ranking
- Persistência em banco de dados **PostgreSQL ou MySQL**

## Autor
**Gabriel** - Desenvolvedor Back-End

