<h1 align="center"> 
  Fórum
</h1> 

<p> 
  <img src="https://img.shields.io/badge/Release-Sep%202023-green" alt="Badge da data de lançamento: Setembro de 2023">  
  <img src="https://img.shields.io/badge/Version-0.1.0-blue" alt="Badge da versão do projeto: 0.1.0">  
  <img src="https://img.shields.io/github/stars/MateusPitura/api-spring-forum?style=social" alt="Badge indicando quantidade de estrelas no repositório"> 
</p> 

## Descrição 

A aplicação é uma API REST desenvolvida em Spring que oferece um conjunto completo de operações CRUD para gerenciar posts de um fórum local. Além disso, a aplicação implementa autenticação via JWT (JSON Web Tokens) para garantir a segurança das rotas e controlar o acesso aos recursos

## Índice 
- [Funcionalidades](#funcionalidades) 
- [Como executar](#como-executar) 
- [Tecnologias usadas](#tecnologias-usadas) 
- [Autores](#autores) 

## Funcionalidades 

:oncoming_police_car: **Autenticação via JWT:** para acessar as funcionalidades da API, os usuários devem autenticar-se usando JSON Web Tokens. Isso garante a segurança das rotas e controla o acesso aos recursos

:page_facing_up: **Documentação da API:** a aplicação inclui documentação completa da API, que pode ser acessada e testada usando o [Postman](https://documenter.getpostman.com/view/28639415/2s9YJW5ks9). Isso facilita o entendimento e uso da API 

## Como executar 

**Para devs:** 

1. Execute o código SQL `src/main/resources/db/V1__schema.sql`
2. Crie uma variável de ambiente `MYSQL` com a senha do seu banco de dados
3. Crie outra variável de ambiente `JWT_SECRET` com um valor qualquer
4. Faça o download de `api-0.0.1-SNAPSHOT.jar` nos Releases do GitHub
5. Dê permissão para ser executado com `chmod +x api-0.0.1-SNAPSHOT.jar`
6. Execute com `java -jar api-0.0.1-SNAPSHOT.jar`

## Tecnologias usadas 

:heavy_check_mark: Java 17

:heavy_check_mark: Spring

:heavy_check_mark: Maven

:heavy_check_mark: MySQL

:heavy_check_mark: Postman

## Autores 

| Mateus Pitura | 
|------| 
| <p align="center"><img src="https://avatars.githubusercontent.com/u/119008106" width="100" height="100"></p> | 
| <a href="https://www.linkedin.com/in/mateuspitura/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"> | 
