FROM centos

MAINTAINER Matteo Capitanio <matteo.capitanio@gmail.com>

ENV JAVA_VER  11
ENV JAVA_HOME /opt/jdk-$JAVA_VER/

# Install Packages
RUN wget https://download.java.net/openjdk/jdk${JAVA_VER}/ri/openjdk-${JAVA_VER}+28_linux-x64_bin.tar.gz -O /opt/jdk.tar.gz

VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
