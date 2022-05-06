# sales-cambio-bookservice

API micro-serviço para gerenciar taxa de cambio, BD MySql.

para acessar a documentação da API GATEWAY

http://localhost:8765/swagger-ui.html

Para acessar a DOCUMENTAÃO DE BOOK-SERVICE

localhost:8100/swagger-ui.html

Para acessar a DOCUMENTAÃO DE CAMBIO-SERVICE

localhost:8000/swagger-ui.html

INFORMAÇÃO IMPORTANTE, NA DOCUMENTAÇÃO DE GATEWAY NÃO É POSSIVEL CONSUMIR AS APIS, POIS OS ENDPOINTS SÃO DINAMICOS, SÃO APENAS PARA EXPOR
CASO QUEIRA VER ENTRAR NAS DOCS DAS APIS E TESTAR, OU DIRETAMETNE PELO CAMINHO DO GATEWAY PELO POSTMAN.

http://localhost:8765/book-service/1/BRL TESTA O BOOK-SERVICE
http://localhost:8765/CAMBIO-SERVICE/cambio-service/1/USD/BRL  
TESTA O CAMBIO, AS MOEDAS QUE ESTÃO SALVAS NO BANCO DE DADOS ABAIXO, LEMBRANDO QUE ESTÃO MOCKADAS;

 Modify	id	from_currency	to_currency	conversion_factor
 	1	USD	BRL	5.73
 	2	USD	EUR	0.84
 	3	USD	GBP	0.73
 	4	USD	ARS	92.56
 	5	USD	CLP	713.30
 	6	USD	COP	3665.00
 	7	USD	MXN	20.15





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


para acessar cambio-service por gateway: http://localhost:8765/cambio-service/1/USD/BRL
para acessar book-service por gateway: http://localhost:8765/book-service/1/BRL
para ver configurações da api-gateway: http://localhost:8765/get

{
"args": {
"Hello": "Word"
},
"headers": {
"Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
"Accept-Encoding": "gzip, deflate, br",
"Accept-Language": "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7",
"Cache-Control": "max-age=0",
"Content-Length": "0",
"Cookie": "adminer_key=04b953a9e9335f12f8dcb2fd3712c4be; adminer_permanent=; adminer_settings=; adminer_engine=InnoDB; adminer_sid=729f1bdbd7ca910069a727219fb60e33",
"Forwarded": "proto=http;host=\"localhost:8765\";for=\"[0:0:0:0:0:0:0:1%0]:47800\"",
"Hello": "Word",
"Host": "httpbin.org",
"Sec-Ch-Ua": "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"100\", \"Google Chrome\";v=\"100\"",
"Sec-Ch-Ua-Mobile": "?0",
"Sec-Ch-Ua-Platform": "\"Linux\"",
"Sec-Fetch-Dest": "document",
"Sec-Fetch-Mode": "navigate",
"Sec-Fetch-Site": "none",
"Sec-Fetch-User": "?1",
"Upgrade-Insecure-Requests": "1",
"User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36",
"X-Amzn-Trace-Id": "Root=1-625969c8-5a74673411c5584f6c840cd1",
"X-Forwarded-Host": "localhost:8765"
},
"origin": "0:0:0:0:0:0:0:1%0, 177.139.90.235",
"url": "http://localhost:8765/get?Hello=Word"
}

