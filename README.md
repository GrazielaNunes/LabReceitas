O sistema requer:
- java  17  
- spring boot 3.1.0
- banco de dados PostgresSQL 

Clonar o projeto no link https://github.com/GrazielaNunes/LabReceitas.git

- aplicar a seguinte configuração no arquivo application.properties
  - spring.datasource.username: postgres
  - spring.datasource.password: sua_senha
  - server.port = 8090

Para executar a aplicação via linha de comando:
    mvn spring-boot:run