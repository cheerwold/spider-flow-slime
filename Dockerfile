FROM maven:3.6.1-jdk-8-slim AS build

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY . .

RUN mvn clean package


FROM openjdk:8-jdk-alpine
ENV LC_ALL C.UTF-8
ENV LANG C.UTF-8
ENV TZ Asia/Shanghai

ENV SLIME_USERNAME slime
ENV SLIME_PASSWORD slime

COPY --from=build /usr/src/app/slime-web/target/slime.jar .

EXPOSE 8086

# Add Tini
RUN apk add --no-cache tini
# Tini is now available at /sbin/tini
ENTRYPOINT ["/sbin/tini", "--"]

# Run java under Tini
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-Dnashorn.args=--language=es6", "-jar", "slime.jar"]
