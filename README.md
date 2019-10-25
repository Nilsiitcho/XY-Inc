# XY-Inc
Aplicação para desafio BackEnd

Se trata de uma plataforma de gerenciamento de Pontos de Interesse (POI).

É possível gerenciar o cadastros de POIs, realizar consulta de todos os POIs, bem como consultar os POIs proximos a um determinado local em uma distância pre determinada pelo usuario

## Especificações
A aplicação foi contruída utilizando a linguagem **Java (versão 8)**, juntamento com o framework **SpringBoot**
e **Spring Data** para camada de persistência.

**Obs:** Por questões de simplicidade e se tratar de uma aplicação de teste, foi utilizado o banco de dados em memória **H2**, vale lembrar que por este se tratar de um banco de dados em memória, todos os registros criados serão perdidos ao finalizar a aplicação.

## Iniciando a aplicação
Para testar a aplicação, basta fazer o download do projeto, importa-lo no **Eclipse** ou **STS** e iniciar o APP.

O banco de dados **H2** será iniciado automaticamente junto com a aplicação. 


## Testando a Aplicação
Para a realizar as comunicações, foi adotado o tipo de dados ***JSON***, sendo assim, ao acessar os serviços, o corpo das requisições deve estar neste formato. (As respostas dos serviço também estarão em **JSON**)

A aplicação se trata apenas do back-end, então para que os serviços sejam testados, é preciso usar alguma ferramenta
para requisições HTTP, como Insomnia ou Postman.

Para facilitar os testes, já são adicionados alguns dados para popular o banco de dados no boot da aplicação.

### CRUD de POIs
Para acessar o serviço de CRUD, utilize o caminho ```/ponto-interesse``` com um dos seguintes métodos HTTP:

- **GET** - consultar registro
- **POST** - criar novo registro
- **PUT** - atualizar registro
- **DELETE** - deletar registro

Nos metodos **GET, PUT** e **DELETE** é preciso informar também o **id** do registro desejado. Exemplo ```/ponto-interesse/{id}```

Além disso, nos métodos **POST** e **PUT** é preciso informar no corpo da requisição, um *JSON* contendo os dados do registro a ser criado ou atualizado, contendo **TODOS** os seguintes campos:
- **x** - valor da coordenada x. Deve ser um inteiro positivo.
- **y** - valor da coordenada y. Inteiro positivo.
- **nome** - String com o nome do Ponto de Interesse. Deve conter entre 3 e 120 caracteres. 

Por exemplo, para criar um registro:

````
http://localhost:8080/ponto-interesse

{
	"x": 25,
	"y": 37,
	"nome": "Center Shooping"
}
````

ou para atualizar um registro:

````
http://localhost:8080/ponto-interesse/2

{
	"x": 12,
	"y": 7,
	"nome": "Mc Donnalds"
}
````

### Listando todos os POIs
Para acessar o serviço que trás todos os Pontos de Interesse, basta acessar a URL ```/todos-pontos``` utilizando o método ***GET***. Será retornado um array com todos os registros.

### Consultado os POIS dentro de um raio específico
Este serviço trás todos os Pontos de Interesse que estão dentro de uma distância pré estabelecida pelo usuário.

A requisição deve ser feita utilizando o método **POST**, contendo um **JSON** em seu corpo com **TODOS** os seguintes campos:
- **x** - valor da coordenada x. Deve ser um inteiro positivo.
- **y** - valor da coordenada y. Inteiro positivo.
- **distanciaMaxima** - valor da distância máxima no qual os POIs devem estar. 

````
http://localhost:8080/pontos-proximos

{
	"x": 25,
	"y": 37,
	"distanciaMaxima": 5
}
````
