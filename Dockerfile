FROM eclipse-temurin:17
WORKDIR app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} desa-canggih.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","desa-canggih.jar"]
