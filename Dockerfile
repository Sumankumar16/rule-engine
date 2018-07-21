FROM frolvlad/alpine-oraclejdk8:slim
WORKDIR /home/


ADD target/rule-engine.jar /home/app.jar
RUN sh -c 'touch /app.jar'

ADD startproject.sh /home/startproject.sh
RUN sh -c 'touch /app.jar'
RUN  chmod -R 775 /home/startproject.sh

CMD /home/startproject.sh
