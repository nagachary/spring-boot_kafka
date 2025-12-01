## Spring Boot Kafka Integration | Maven Build

This repository contains a sample project demonstrating Spring Boot integration with Apache Kafka, packaged and built using Maven. The project includes both producer and consumer implementations and is designed to run locally using Confluent Kafka.

### Prerequisites

Ensure the following tools are installed on your machine:

**- Docker Desktop or Docker Engine**

Verify your Docker installation by running:
```
docker info
```

**- Confluent CLI**

Install via Homebrew (macOS):
```
brew install confluentinc/tap/cli
```
### Running Kafka Locally
Follow the steps below to set up and run Kafka using the Confluent CLI:

**1. Start the Kafka Broker**

```
confluent local kafka start
```
After startup, note the ```Plaintext Ports``` displayed in the terminal. These will be required for client configuration.
Update the port value for  the ```spring.kafka.bootstrap-servers``` property in application.properties file.

**2. Create a Kafka Topic**

Create a topic named ```purchases```, which will be used for producing and consuming events:

```
confluent local kafka topic create purchases
```

### Running the Spring Boot Applications

You can run the producer and consumer components individually using Maven.

**Start the Producer Application**

```
mvn spring-boot:run -Dspring-boot.run.arguments='--producer'
```

**Start the Consumer Application**
```
mvn spring-boot:run -Dspring-boot.run.arguments='--consumer'
```

### Shutting Down Kafka

When you are finished, stop the local Kafka instance with:

```
confluent local kafka stop
```