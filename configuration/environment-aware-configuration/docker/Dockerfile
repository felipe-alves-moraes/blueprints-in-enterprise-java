FROM payara/micro:5.182

ADD ./target/libs /opt/libs

COPY ./target/envronment-aware-configuration.war ${DEPLOY_DIR}

ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", \
"--addLibs", "/opt/libs/", \
"--deploy", "/opt/payara/deployments/envronment-aware-configuration.war"]
