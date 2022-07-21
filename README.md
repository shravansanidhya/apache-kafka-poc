# Apache Kafka #

Kafka is a distributed event streaming platform or publish-subscribe messaging system which lets you send messages between processes, applications, and servers.

#### To start zookeeper server ####

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

#### To start kafka server ####

 .\bin\windows\kafka-server-start.bat .\config\server.properties

#### To create a Topic ####

kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic kafkaPOC

#### To modify a Topic ####

kafka-topics.bat --zookeeper localhost:2181 --alter --topic kafkaPOC --partitions 2

#### To delete a Topic ####

kafka-topics.bat --zookeeper localhost:2181 --delete --topic kafkaPOC

#### To see list of Topics ####

kafka-topics.bat --list --zookeeper localhost:2181

#### To see messages from consumer console ####

kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafkaPOC

#### To produce messages from producer console ####

kafka-console-producer.bat --broker-list localhost:9092 --topic kafkaPOC

#### To produce messages from producer console to multiple brokers ####

kafka-console-producer.bat --broker-list localhost:9092,localhost:9093,localhost:9094 --topic kafka-topic1

#### To check which broker is listening on the current created topic ####

kafka-topics.bat --describe --zookeeper localhost:2181 --topic kafka-topic1

#### To see all console messages in consumer console from beginning ####

kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafkaPOC --from-beginning

