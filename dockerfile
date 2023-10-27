FROM clojure

COPY . /usr/src/app
WORKDIR /usr/src/app

RUN lein uberjar && \
    mv target/uberjar/cinekube-movie-tracker-0.1.0-SNAPSHOT-standalone.jar ./movie-tracker.jar

CMD ["java", "-jar", "movie-tracker.jar"]