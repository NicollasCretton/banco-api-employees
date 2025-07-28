# Banco API Employees

API RESTful para cadastro, listagem e remoção de funcionários, construída com **Java 17**, **Spring Boot 3**, **PostgreSQL**, **Docker**, **JUnit**, **Mockito**, documentação via **Swagger** e arquitetura baseada em **DDD**, **SOLID** e **Clean Architecture**.

---

## 🚀 Instruções para compilar e executar localmente

1. Clone o repositório:
```bash
git clone https://github.com/NicollasCretton/banco-api-employees
cd banco-api-employees
```

2. Compile o projeto:
```bash
./mvnw clean install
```

3. Execute o projeto localmente:
```bash
./mvnw spring-boot:run
```

> A API estará disponível em `http://localhost:8080`.

---

## 🐳 Executar via Docker

### Pré-requisitos:
- Docker e Docker Compose instalados.

### Passos:
```bash
docker-compose up --build
```

> Isso iniciará o backend em `http://localhost:8080` e o banco de dados PostgreSQL em `localhost:5432`.

---

## ✅ Executar os testes

```bash
./mvnw test
```

---

## 🔁 Endpoints da API

### Criar funcionário
```bash
curl -X POST http://localhost:8080/employees \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Arnaldo Pereira",
    "email": "arnaldo@banco.com.br",
    "department": "Arquitetura"
  }'
```

### Listar todos os funcionários
```bash
curl -X GET http://localhost:8080/employees
```

### Remover funcionário por ID
```bash
curl -X DELETE http://localhost:8080/employees/1
```

---

## 🧪 Exemplo de Resposta da API

### Requisição:
```bash
curl -X GET http://localhost:8080/employees
```

### Resposta:
```json
[
  {
    "name": "Arnaldo Pereira",
    "email": "arnaldo@banco.com.br",
    "department": "Arquitetura"
  },
  {
    "name": "Renato Pedigoni",
    "email": "renato@banco.com.br",
    "department": "E-commerce"
  }
]
```

---

## 📚 Documentação Swagger

Acesse a documentação interativa em:

👉 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

---

## 🧠 Uso de IA Generativa

Este projeto foi desenvolvido com apoio de IA para acelerar a entrega e garantir boas práticas. Confira os detalhes no arquivo [AI_USAGE.md](./AI_USAGE.md).

---

## 🧱 Arquitetura

- **Camadas:**
    - `domain`: entidades e interfaces
    - `application`: regras de negócio
    - `infrastructure`: JPA, controllers, configurações
- **Padrões aplicados:**
    - DDD
    - SOLID
    - Clean Architecture
- **Banco de dados:** PostgreSQL

---

## 📦 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- PostgreSQL
- Maven
- Docker
- Swagger (SpringDoc)
- JUnit 5
- Mockito
- Lombok

---

## 👨‍💻 Autor

Nícollas Nogueira Cretton
