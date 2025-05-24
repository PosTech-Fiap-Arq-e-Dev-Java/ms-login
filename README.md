# Microserviço de Login - Projeto Java Spring Boot com MySQL + Docker Compose

Este projeto é um microserviço responsável pela gestão de logins de usuários (clientes e parceiros) em um sistema de restaurantes.

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Maven
- MySQL 8.3
- Docker & Docker Compose
- Lombok
- OpenAPI/Swagger
- Spring Data JPA

## 📁 Estrutura do Projeto

- `app`: aplicação Spring Boot
- `Dockerfile`: imagem da aplicação
- `docker-compose.yml`: orquestração dos containers (aplicação + banco)
- `wait-for-it.sh`: script que aguarda o banco de dados estar pronto antes de subir a aplicação

---

## ⚙️ Pré-requisitos

Certifique-se de ter os seguintes softwares instalados:

 
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## 📦 Principais arquivos

| Arquivo              | Descrição                                                                |
|----------------------|--------------------------------------------------------------------------|
| `Dockerfile`         | Define a imagem da aplicação Spring Boot                                 |
| `docker-compose.yml` | Sobe o MySQL e o microserviço de login em containers                     |
| `wait-for-it.sh`     | Script que aguarda o MySQL estar disponível antes de iniciar a aplicação |
| `application.yml`    | Configurações do Spring Boot, incluindo porta e datasource               |
| `pom.xml`            | Gerenciador de dependências Maven                                        |

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/FIAP-Pos-Arq-e-Dev-Java/ms-login
cd ms-login

```
### 2. Compile a aplicação com o Maven

```bash
./mvnw clean package

```
### 3. Compile a aplicação com o Maven

```bash
./mvnw clean package

```
### 4. Dê permissão de execução ao script de espera

```bash
chmod +x wait-for-it.sh
chmod +x entrypoint.sh

```
### 5. Crie a rede externa manualmente

```bash
docker network create mslogin-net

```
### 6. Suba os containers com Docker Compose

```bash
docker-compose up --build
```

---

## 🔗 Endpoints Disponíveis

| Método   | Caminho                      | Descrição                  |
|----------|------------------------------|----------------------------|
| `POST`   | `/v1/auth/login`             | Autenticação de usuário    |
| `GET`    | `/v1/auth/login?usuario=xxx` | Buscar status do login     |
| `POST`   | `/v1/auth/registration`      | Criar login de usuário     |
| `PATCH`  | `/v1/login/{usuario}`        | Atualizar senha de usuário |
| `DELETE` | `/v1/login/{usuario}`        | Deletar login de usuário   |

- [Swagger](http://localhost:9207/ms-login/swagger-ui.html)

---

## 🛢️ Banco de Dados MySQL

| Configuração | Valor         |
|--------------|---------------|
| **Host**     | `localhost`   |
| **Porta**    | `3306`        |
| **Usuário**  | `adm123`      |
| **Senha**    | `adm123`      |
| **Database** | `db-ms-login` |

---

## ‍💻 Autores

Este projeto faz parte da Pós-graduação em Arquitetura e Desenvolvimento Java da FIAP e implementa um microserviço de login com autenticação, documentação OpenAPI e persistência de dados com MySQL, seguindo boas práticas de microsserviços.

- Raysse Geise Alves Cutrim - rayssecutrim@hotmail.com 
- Marcos Vinicius Beserra Pinho - marcos.vb.pinho@live.com