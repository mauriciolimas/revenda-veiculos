# 🚗 Plataforma de Revenda de Veículos - API

Este projeto é a API responsável por gerenciar a plataforma de revenda de veículos de uma empresa que atua no mercado de automóveis. A aplicação foi desenvolvida utilizando **Java 17** e **Spring Boot**, seguindo práticas modernas de desenvolvimento, como separação de responsabilidades, autenticação desacoplada.

## 📋 Funcionalidades

A API oferece os seguintes recursos principais:

- **Cadastro de veículos** para venda (Marca, Modelo, Ano, Cor, Preço);
- **Edição** dos dados de um veículo;
- **Listagem de veículos disponíveis**, ordenados do mais barato ao mais caro;
- **Listagem de veículos vendidos**, também ordenados por preço;
- **Cadastro de compradores** (realizado via serviço de autenticação separado);
- **Compra de veículos**, disponível apenas para usuários autenticados;
- Integração com sistema externo de autenticação Keycloak.

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA (persistência de dados)
- Spring Security (autorização com JWT)
- PostgreSQL (banco de dados relacional)
- Flyway (versionamento de banco de dados)
- Docker / Docker Compose
- OpenAPI / Swagger
- JUnit 5 + Mockito (testes)
- GitHub Actions (CI/CD)

## 🚀 Como Executar Localmente

### Pré-requisitos

- Java 17+
- Maven: 3.+
- Docker e Docker Compose

### Passos

```bash
# Clone o repositório
git clone https://https://github.com/mauriciolimas/revenda-veiculos.git
cd revenda-veiculos

# Suba o banco de dados com Docker
docker-compose up -d

# Rode a aplicação localmente
./mvnw spring-boot:run
```

## 🚀 Deploy da aplicação via docker-compose

```bash
# Clone o repositório
git clone https://https://github.com/mauriciolimas/revenda-veiculos.git
cd revenda-veiculos

# Suba o banco de dados com Docker
docker-compose up -d
```

## 📚 Documentação da API
Uma interface Swagger está disponível em:

```bash
http://localhost:8080/swagger-ui.html
```
Essa interface permite testar os endpoints diretamente pela web.
