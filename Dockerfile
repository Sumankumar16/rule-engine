FROM frolvlad/alpine-oraclejdk8:slim
WORKDIR /home/

ADD target/rule-engine.jar /home/app.jar
RUN sh -c 'touch /app.jar'

EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app.jar"] 
