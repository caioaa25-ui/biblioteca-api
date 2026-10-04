# 📚 Biblioteca API

API REST desenvolvida em **Spring Boot** para gerenciamento de um acervo de biblioteca, com controle de livros, autores, usuários e empréstimos.

🔗 **API publicada:** https://biblioteca-api-huzt.onrender.com
📘 **Documentação interativa (Swagger):** https://biblioteca-api-huzt.onrender.com/swagger-ui/index.html

> ⚠️ A API está hospedada no plano gratuito do Render, então a primeira requisição pode levar até 50 segundos para responder (o serviço "acorda" do modo hibernado).

## 🚀 Tecnologias utilizadas

- **Java 21**
- **Spring Boot 4**
- **Spring Data JPA**
- **Spring Validation**
- **H2 Database** (banco em memória)
- **Swagger / OpenAPI** (springdoc-openapi)
- **Lombok**
- **Docker**
- **Maven**

## ✨ Funcionalidades

- CRUD completo de **Livros**, **Autores**, **Usuários** e **Empréstimos**
- Validações de dados de entrada (Bean Validation)
- Relacionamento entre entidades (Livro ↔ Autor, Empréstimo ↔ Livro/Usuário)
- Controle de status de empréstimo (ATIVO, DEVOLVIDO, ATRASADO)
- Documentação automática via Swagger
- Dados de exemplo pré-carregados para teste imediato

## ▶️ Como rodar localmente

```bash
git clone https://github.com/caioaa25-ui/biblioteca-api.git
cd biblioteca-api
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`. Acesse o Swagger em `http://localhost:8080/swagger-ui/index.html`.

## 🐳 Rodando com Docker

```bash
docker build -t biblioteca-api .
docker run -p 8080:8080 biblioteca-api
```

## 📂 Estrutura do projeto
