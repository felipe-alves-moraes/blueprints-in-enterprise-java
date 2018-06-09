# Build
mvn clean package && docker build -t br.com.fmoraes/maven-configuration .

# RUN

docker rm -f maven-configuration || true && docker run -d -p 8080:8080 -p 4848:4848 --name maven-configuration br.com.fmoraes/maven-configuration 