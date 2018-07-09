# Build
mvn clean package && docker build -f ./docker/Dockerfile -t br.com.fmoraes/envronment-aware-configuration .

# RUN

docker rm -f envronment-aware-configuration || true && docker run --env-file=./docker/local_env_properties -d -p 8080:8080 -p 4848:4848 --name envronment-aware-configuration br.com.fmoraes/envronment-aware-configuration