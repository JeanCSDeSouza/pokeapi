# Pokémon API - Spring Boot Application

## Descrição
Esta é uma aplicação RESTful de gerenciamento de Pokémon, construída usando Spring Boot. A aplicação permite criar, visualizar, atualizar e deletar Pokémon no banco de dados. Também inclui um recurso para atualizar o treinador de um Pokémon específico.

## Pré-requisitos

- **Java 17** ou superior
- **Maven** (ou outra ferramenta de build que suporte Maven)
- **Docker** (para rodar o banco de dados MySQL ou a aplicação via container)

## Como rodar localmente a aplicação Spring Boot

### 1. Clonar o repositório
```bash
git clone https://github.com/JeanCSDeSouza/pokeapi.git
cd pokeapi
```
### 2. Rodar a aplicação localmente com Maven
Você pode empacotar o projeto em um arquivo .jar e executar o JAR:
```bash
mvn clean package
java -jar target/nome-do-seu-projeto.jar
```
A aplicação estará rodando no endereço: http://localhost:8081.

3. Testar as rotas
Agora você pode acessar os endpoints da aplicação utilizando uma ferramenta como Postman ou curl.

##Como rodar com Docker
### 1. Buildar a imagem Docker
A aplicação contém um Dockerfile para facilitar a criação de uma imagem Docker. Para criar a imagem, execute o seguinte comando no diretório raiz do projeto:

```bash
docker build -t pokemon-api .
```
### 2. Rodar a imagem Docker
Após buildar a imagem, você pode rodar o container:
```bash
docker run -p 8081:8081 pokemon-api
A aplicação estará disponível no endereço http://localhost:8081.
```
3. Rodar com docker-compose
Se você tem um arquivo docker-compose.yml do projeto:
```bash
docker-compose up
```
##Endpoints da Aplicação
Aqui estão os endpoints disponíveis na aplicação:

### GET /api/v1/pokemon
Retorna uma lista de todos os Pokémon cadastrados.

### POST /api/v1/pokemon
Adiciona um novo Pokémon. O corpo da requisição deve conter os dados do Pokémon em JSON.

### GET /api/v1/pokemon/{id}
Retorna os detalhes de um Pokémon específico com base no ID.

### DELETE /api/v1/pokemon/{id}
Deleta um Pokémon específico com base no ID.

### PATCH /api/v1/pokemon/{id}/treinador
Atualiza o treinador de um Pokémon específico. O corpo da requisição deve conter o novo nome do treinador.

##Swagger
A aplicação inclui suporte ao Swagger para documentação da API. Para visualizar a documentação da API, acesse:

```bash
http://localhost:8081/swagger-ui.html
```
