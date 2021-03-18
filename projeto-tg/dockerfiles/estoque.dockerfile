# ir na pasta com estoque
# colar o dockerfile
FROM java11

COPY loja-estoque.1.0.jar /var/www
WORKDIR /var/www
RUN [ "java", "-jar" "loja-estoque.1.0.jar" ]
# ENTRYPOINT [ "java", "-jar" "loja-estoque.1.0.jar" ]
EXPOSE 80

# docker build -f estoque.dockerfile -t sidewinterof/backend-estoque-loja