# banks_api
API desenvolvida para teste prático em Java

## Endpoints

- GET: `http://localhost:8080/BancosAPI/api/banks/`
  - Status 200: JSON com todos os bancos cadastrados.
  - Status 204: nenhum banco cadastrado.

- GET: `http://localhost:8080/BancosAPI/api/banks/{code}`
  - Status 200: JSON banco cadastrado com o código de compensação informado.
  - Status 404: banco não encontrado.

## Tecnologias utilizadas

- JDK 11
- Jersey 2.29.1
- MySQL
- Apache Tomcat 9.0

## Executando o projeto

- Executar o script `banks_api.sql` no cliente MySQL.
- Realize o deploy do arquivo `target/BancosAPI-0.0.1-SNAPSHOT.war` em um servidor de aplicação.
