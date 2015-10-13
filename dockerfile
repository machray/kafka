FROM ubuntu
VOLUME /tmp
COPY kafka_2.10-0.8.2.0.tgz .
RUN tar -xzf kafka_2.10-0.8.2.0.tgz
CMD cd kafka_2.10-0.8.2.0
CMD bin/zookeeper-server-start.sh config/zookeeper.properties
CMD bin/kafka-server-start.sh config/server.properties
CMD bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
CMD bin/kafka-topics.sh --list --zookeeper localhost:2181