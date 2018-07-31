FROM frolvlad/alpine-oraclejdk8:slim
WORKDIR /home/

ADD target/rule-engine.jar /home/app.jar
RUN sh -c 'touch /app.jar'

ADD startproject.sh /home/startproject.sh
RUN  chmod -R 775 /home/startproject.sh
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app.jar"] 
