# ir na pasta com compra
# colar o dockerfile
FROM java11

COPY loja-compra.1.0.jar /var/www
WORKDIR /var/www
RUN [ "java", "-jar" "loja-compra.1.0.jar" ]
# ENTRYPOINT [ "java", "-jar" "loja-compra.1.0.jar" ]
EXPOSE 80

# docker build -f compra.dockerfile -t sidewinterof/backend-compra-loja