FROM openjdk:11
VOLUME /tmp
EXPOSE 9047
ADD ./target/ms-cwtransaction-0.0.1-SNAPSHOT.jar ms-cwtransaction.jar
ENTRYPOINT ["java","-jar","/ms-cwtransaction.jar"]