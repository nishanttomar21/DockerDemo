# Use the official OpenJDK image as a base (includes light linux OS and Java)
FROM openjdk:23

# Set the working directory inside the container
#WORKDIR /app

# Copy the Maven-built JAR file into the container
COPY target/DockerDemo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the app will run
#EXPOSE 8080

# Command to run the java application directly with jar file
ENTRYPOINT ["java","-jar","app.jar"]


# [DOCKER COMMANDS]:
#docker login -u <username>
#echo "your_password" | docker login -u <username> --password-stdin     // You will be prompted to enter your password. For security, consider using
#docker build -t nishanttomar211/testingdocker:v1.000001 .  // dot to tell docker, find dockerfile in this location and build image with name given
#docker run -d --name katrina -p 8080:8080 nishanttomar211/testingdocker:v1.000001  // Map a port on your host machine to a port on the containe
#image_name: testingdocker, container_name: katrina, tag_name: v1.000001
#docker ps  // To see running containers
#docker ps -a   // To see all containers (including stopped ones)
#docker stop container_id
#docker rm <container_name>     // To remove a stopped container
#docker rmi <image_name>    // To delete an image
#docker push nishanttomar211/testingdocker:v1.000001
#docker pull nishanttomar211/testingdocker:v1.000001