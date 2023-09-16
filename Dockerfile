FROM openjdk:17
ADD target/simple-kubernetes-deployment.jar simple-kubernetes-deployment.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","simple-kubernetes-deployment.jar"]