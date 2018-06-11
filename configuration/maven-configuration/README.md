# Maven Filters
With this approach I was setting my database config based on the environment that I was working.

I wanted to have an in memory database while developing the application and a MySQL database for QA env.

To do this I've used [maven filters](https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html) feature and also based my configuration in this [article](https://developer.jboss.org/wiki/HowToConfigureJavaEEApplicationToApplyDifferentSettingsinWebxmlEtcForVariousEnvironmentsByMaven?_sscc=t) . 
This way I was able to set the config that I wanted at build time.

You can check the configuration inside the `pom.xml` file.

By default maven applies the local config into the files.
If you want to change the config use this parameter "-Denvironment=qa" with `mvn` command.

## Cons of this approach
Everytime you need to change the properties you need to rebuild the application and set the desired environment. 
This way, in a CI/CD environment you would have to build your `war` everytime it changes the env in a pipeline, not recommended.

It is INSECURE. As pointed in this twit: https://twitter.com/struberg/status/1005905045790044160.

Not the way that Java EE applications should handle it's environment configurations. DON'T DO THIS.

## Pros
Somehow simple to achieve the desired result.

You get to know better the capabilities of Maven.

# Build
mvn clean package && docker build -t br.com.fmoraes/maven-configuration .

# RUN

docker rm -f maven-configuration || true && docker run -d -p 8080:8080 -p 4848:4848 --name maven-configuration br.com.fmoraes/maven-configuration 
