FROM openjdk:8
#VOLUME /tmp
#ADD docker-demo-0.0.1.jar /opt/docker-demo.jar
#ENTRYPOINT ["java", "-jar", "/opt/docker-demo.jar"]

COPY docker-demo-0.0.1.jar /opt/docker-demo.jar
CMD java -jar --server.port=${SERVER_PORT} /opt/docker-demo.jar