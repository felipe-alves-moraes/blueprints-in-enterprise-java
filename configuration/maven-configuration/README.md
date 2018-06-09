# Maven Filters
With this approach I was setting my database config based on the environment that I was working.

I wanted to have an in memory database while developing the application and a MySQL database for QA env.

To do this I used [maven filters](https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html) feature and set the config that I want at build time.

You can check the configuration inside the `pom.xml` file.

By default maven applies the local config into the files.
If you want to change the config use this parameter "-Denvironment=qa" with `mvn` command.

## Cons of this approach
Everytime you need to change the properties you need to rebuild the application and set the desired environment. 
This way, in a CI/CD environment you would have to build your `war` everytime it changes the env in a pipeline, not recommended.

## Pros
Somehow simple to achieve the desired result.

# Build
mvn clean package && docker build -t br.com.fmoraes/maven-configuration .

# RUN

docker rm -f maven-configuration || true && docker run -d -p 8080:8080 -p 4848:4848 --name maven-configuration br.com.fmoraes/maven-configuration 