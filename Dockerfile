FROM clojure:lein-2.4.3
MAINTAINER Sandro Padin <sandropadin@gmail.com>

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY project.clj /usr/src/app/

RUN lein deps

COPY . /usr/src/app

RUN mv "$(lein ring uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar

EXPOSE 3000

RUN lein ragtime migrate

CMD ["java", "-jar", "app-standalone.jar"]
