# registrar

[![Codeship build status](https://codeship.com/projects/a0f65a50-92fd-0132-c937-6a8221c3ead3/status?branch=master)](https://codeship.com/projects/62097)

Site builder API server written in Clojure

### Running migrations

    $ lein ragtime migrate

### Running specs

    $ lein with-profile test ragtime migrate
    $ lein spec

### Running server

    $ lein ring server-headless
