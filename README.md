# XY-Inc
Aplicação para desafio de desenvolvedor Back-End ZUP

## Especificações
A aplicação foi contruída utilizando a linguagem **Java (versão 8)**, juntamento com o framework **SpringBoot**
e **Hibernate** para camada de persistência.

**Obs:** Por questões de simplicidade, foi utilizado o banco em memória **H2**

## Como rodar a aplicação
Para testar a aplicação, basta fazer o download do projeto, importa-lo no **Eclipse** ou **STS** e iniciar o APP.

O banco de dados **H2** será iniciado automaticamente junto com a aplicação. 

## Como testar
A aplicação se trata apenas do back-end, então para que os serviços sejam testados, é preciso usar alguma ferramenta
para requisições HTTP, como Insomnia ou Postman.

Para facilitar os testes, já são adicionados alguns dados para popular o banco de dados no boot da aplicação.

**Obs** vale lembrar que por a aplicação estar utilizando o **H2** e este se tratar de um banco de dados em memória,
apenas para fins de testes, todos os registros criados serão perdidos ao finalizar a aplicação.
