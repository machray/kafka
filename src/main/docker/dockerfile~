FROM java:8
VOLUME /tmp
COPY kafka_2.10-0.8.2.0.tgz .
RUN tar -xzf kafka_2.10-0.8.2.0.tgz
CMD cd kafka_2.10-0.8.2.0
CMD bin/zookeeper-server-start.sh config/zookeeper.properties
CMD bin/kafka-server-start.sh config/server.properties
CMD bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
CMD bin/kafka-topics.sh --list --zookeeper localhost:2181

ADD kafka-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 80