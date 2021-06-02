FROM amazoncorretto:11-alpine-jdk
RUN apk add postgresql
RUN mkdir /run/postgresql
RUN chown postgres:postgres /run/postgresql
USER postgres
RUN cd && pwd
RUN mkdir /var/lib/postgresql/data
RUN chmod 0700 /var/lib/postgresql/data
RUN initdb -D /var/lib/postgresql/data
RUN pg_ctl start -D /var/lib/postgresql/data &&\
    psql -U postgres -c "alter user postgres with password 'root';" &&\
    psql -U postgres -c "create database archive;"
COPY target/archive-2.5.0.jar archive.jar
CMD pg_ctl start -D /var/lib/postgresql/data && java -jar archive.jar
EXPOSE 3000
