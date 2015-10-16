FROM java:7
VOLUME /tmp

COPY kafka_2.10-0.8.2.0.tgz .
RUN tar -xzf kafka_2.10-0.8.2.0.tgz


ADD kafka-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 80
