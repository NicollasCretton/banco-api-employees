# Uso de IA Generativa no Projeto

## Ferramentas Utilizadas
- ChatGPT (GPT-4o) para auxílio técnico, arquitetura, configuração do projeto e documentação.

## Prompts Efetivos

### 1. Organização do Projeto com Clean Architecture
**Prompt**: "Estou participando de um processo seletivo que exige criar uma API RESTful com Spring Boot 3 e Java 17 usando DDD, SOLID, Clean Architecture e Docker. Quais pacotes devo criar e como estruturar?"
**Resultado**: A IA sugeriu a divisão em pacotes `domain`, `application`, `infrastructure`, com explicações de responsabilidades de cada camada. A estrutura foi implementada e mantida ao longo do projeto.

### 2. Criação de arquivos `Dockerfile` e `docker-compose.yml`
**Prompt**: "Agora vamos para o 8. Dockerizar a aplicação"
**Resultado**: A IA gerou os arquivos prontos com imagem do PostgreSQL, build multi-stage para Java e mapeamento correto de portas e volumes. O projeto foi executado com sucesso via `docker-compose up`.

### 3. Integração e configuração do Swagger
**Prompt**: "Então agora vamos fazer o 9. Gerar documentação automática com Swagger, certo?"
**Resultado**: A IA adicionou corretamente a dependência do `springdoc-openapi-starter-webmvc-ui` ao `pom.xml`, orientou sobre a URL `/swagger-ui.html` e ajudou a corrigir erros de build.

### 4. Testes com JUnit e Mockito
**Prompt**: "Agora vamos para o 7. Criar testes com JUnit e Mockito"
**Resultado**: A IA guiou na criação da estrutura de testes, localização da pasta `src/test`, boas práticas com `@Mock` e `@InjectMocks`, e criação de testes unitários para o serviço `EmployeeService`.

## Decisões Influenciadas por IA

1. Uso de PostgreSQL como banco de dados com persistência em volume Docker.
2. Utilização de `@Valid` nos DTOs e integração com Spring Validation.
3. Definição de endpoints RESTful simples com `GET`, `POST` e `DELETE`.
4. Criação de testes com comportamento esperado utilizando Mockito.
5. Criação da documentação `README.md` com instruções passo a passo.

## Limitações e Soluções

- ❌ A IA sugeriu inicialmente um container com `eclipse-temurin` que travava no TLS → solução: substituído por imagem `openjdk:17-slim`.
- ❌ Pasta de testes não era localizada → a IA orientou a navegar até `src/test/java/...` e criar o arquivo `EmployeeServiceTest.java` corretamente.

## Considerações Finais

A IA foi utilizada como **assistente técnico complementar**. Todas as sugestões foram analisadas, adaptadas e testadas manualmente antes de serem incorporadas ao projeto.

Ferramenta de IA utilizada:
- [ChatGPT (GPT-4o)](https://chat.openai.com/)

---
