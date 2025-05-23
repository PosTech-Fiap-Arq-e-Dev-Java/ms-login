FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY 'target/*.jar' '/app/appMsLogin.jar'

EXPOSE 9207

CMD ["java", "-jar", "appMsLogin.jar"]