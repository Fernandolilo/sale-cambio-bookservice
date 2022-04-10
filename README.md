# sale-cambio-bookservice

API micro-serviço para gerenciar taxa de cambio, BD MySql.

gerar container para banco de dados MySql com o adminer4 para manipulara dados, criar um repositorio, salvar o arquivo a baixo 
como docker-compose.yml 

abrir um terminal no repositorio, ter o docker instalado e dar o comando => docker-compose up

vai gerar 2 containers, um com o MySql outro com o adminer o adminer será exposto no browser, localhost:8080

version: '3.8'

services:
  mysql-db:
    image:  mysql:5.7
    container_name: mysql_container
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: cambio_service
    ports:
      - "3306:3306"
    cap_add:
      - SYS_NICE  # Desabilitar o aviso "mbind: Operation not permitted"
  adminer:
    image: adminer:4
    container_name: adminer_container
    restart: always
    ports:
      - 8080:8080


