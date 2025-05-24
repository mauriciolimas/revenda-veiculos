![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.9.6-C71A36.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=mauriciolimas_revenda-veiculos&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=mauriciolimas_revenda-veiculos)

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

[Acesso a documentação](http://localhost:8081/swagger-ui/index.html)
```bash
http://localhost:8081/swagger-ui/index.html
```
Essa interface permite testar os endpoints diretamente pela web.

## Acesso a interface do Keycloak

Para acessar a interface grafica do keycloak é necessário configurar o arquivos /etc/hosts e adicionar a entrada

- Caminho no Linux: /etc/hosts
- Caminho no Windows: C:\Windows\System32\drivers\etc\hosts
```bash
127.0.0.1 keycloak
```

[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=mauriciolimas_revenda-veiculos)](https://sonarcloud.io/summary/new_code?id=mauriciolimas_revenda-veiculos)