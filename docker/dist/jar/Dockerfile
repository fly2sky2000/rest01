# Docker image for springboot file run
# VERSION 0.0.1
# Author: eangulee
# 基础镜像使用java
FROM java:8
# 作者
MAINTAINER Felix
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为app.jar
ADD app.jar app.jar
# 运行jar包
RUN bash -c 'touch /app.jar'
# ENV JAVA_OPTS=""
# ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
EXPOSE 10202
# ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod", "--server.port=10202", "> /log/app.log"]
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod", "--server.port=10202"]
