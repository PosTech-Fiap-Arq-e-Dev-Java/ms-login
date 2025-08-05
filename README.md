# Microsserviço de Login - Projeto Java Spring Boot com MySQL + Docker Compose

Este projeto é um microsserviço responsável pela gestão de logins de usuários (clientes e parceiros) em um sistema de restaurantes.

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
- `wait-for-it.sh`: script que aguarda o banco de dados estar pronto antes de subir a aplicação
- `entrypoint.sh`: ponto de entrada para inicialização segura da aplicação

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
| `wait-for-it.sh`     | Script que aguarda o MySQL estar disponível antes de iniciar a aplicação |
| `entrypoint.sh`      | Script de entrada que executa o JAR da aplicação                         |
| `application.yml`    | Configurações do Spring Boot, incluindo porta e datasource               |
| `pom.xml`            | Gerenciador de dependências Maven                                        |

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/PosTech-Fiap-Arq-e-Dev-Java/ms-login
cd ms-login

```
### 2. Compile a aplicação com o Maven

```bash
./mvnw clean package

```
### 3. Dê permissão de execução ao script de espera

```bash
chmod +x wait-for-it.sh
chmod +x entrypoint.sh

```
### 4. Faça o clone do docker-compose

### 5. Suba o docker-compose contendo as três aplicações e o banco de dados

```bash
docker-compose up -d

````

### 6. Suba o container do ms-login

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

## 🚀 Documentação API (Swagger)

Para explorar e testar os endpoints do microsserviço de forma visual, acesse a documentação interativa Swagger no link abaixo:

[🌐 Acesse a documentação Swagger](http://localhost:9207/ms-login/swagger-ui.html)

---

## 🛢️ Banco de Dados MySQL

| Configuração | Valor          |
|--------------|----------------|
| **Host**     | `localhost`    |
| **Porta**    | `3306`         |
| **Usuário**  | `adm123`       |
| **Senha**    | `adm123`       |
| **Database** | `db-tc-grupo8` |

## 🗄️ Tabelas utilizadas no microsserviço

O ms-login interage com as seguintes tabelas no banco de dados:

| Tabela              | Operações Realizadas                   | Descrição                                                                                                         |
| ------------------- | -------------------------------------- |-------------------------------------------------------------------------------------------------------------------|
| `tb_login`          | `SELECT`, `INSERT`, `UPDATE`, `DELETE` | Contém os dados de login do usuário, como `usuario`, `senha`, `documento`, tipo e status.                         |
| `tb_status_usuario` | `SELECT`, `INSERT` (via carga inicial) | Define os possíveis status que um usuário pode ter (ex: ATIVO, INATIVO, BLOQUEADO, PENDENTE, EXPIRADO, SUSPENSO). |
| `tb_tipo_usuario`   | `SELECT`, `INSERT` (via carga inicial) | Define os tipos de usuários existentes no sistema (ex: CLIENTE, PARCEIRO).                                        |


## 🧪 Carga Inicial de Dados (DataLoader)

A aplicação realiza a carga automática assim que a aplicação é iniciada, dos registros iniciais para as tabelas de domínio:

- tb_status_usuario com os valores do StatusUsuarioEnum
- tb_tipo_usuario com os valores do TipoUsuarioEnum

Essa carga é realizada através de dois componentes CommandLineRunner:

- TipoUsuarioDataLoaderConfig
- StatusUsuarioDataLoaderConfig

⚠️ Caso os registros já existam (mesmo ID), a aplicação não os duplica.

---

---

## 🧪 Testes Automatizados com JUnit e Mockito

Este projeto utiliza testes unitários com JUnit 5 e Mockito para garantir a qualidade e o comportamento esperado dos componentes da aplicação.

## 🔗 Executar Testes


```bash
mvn clean verify

```

## ‍💻 Autores

Este projeto faz parte da Pós-graduação em Arquitetura e Desenvolvimento Java da FIAP e implementa um microsserviço de login com autenticação, documentação OpenAPI e persistência de dados com MySQL, seguindo boas práticas de microsserviços.

- Raysse Geise Alves Cutrim - rayssecutrim@hotmail.com
