FROM maven:3.6.3-openjdk-11-slim

RUN mkdir -p app
WORKDIR /app

COPY pom.xml .
COPY run.sh .
COPY src ./src
#
RUN mvn clean package

RUN ls -l

ENTRYPOINT ["java", "-jar", "/app/target/chatapp.jar"]
