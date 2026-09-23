cat > Dockerfile << 'EOF'
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/fanid-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
EOF

cat > src/main/resources/application.properties << 'EOF'
server.port=${PORT:8080}
EOF

git add Dockerfile src/main/resources/application.properties
git commit -m "add Dockerfile for Render deployment"
git push origin master
git push origin master:main
