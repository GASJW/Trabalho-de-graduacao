# ir na pasta com mysqll
# colar o dockerfile
FROM mysql

# COPY . /var/www
WORKDIR /var/www
# RUN [ "" ]
# ENTRYPOINT [ "" ]
EXPOSE 3306

# docker build -f mysql.dockerfile -t sidewinterof/mysql-bd