FROM ENV_IMAGE_OPENJDK
USER mitapp
EXPOSE 8080
WORKDIR /opt/local/apps
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
