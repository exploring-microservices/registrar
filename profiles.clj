{:dev {:jvm-opts ["-Dlogfile.name=development.log"]
       :env {:clj-env "development"
             :db-classname "org.j2.Driver"
             :db-subprotocol "h2"
             :db-subname "./resources/db/development"}
       :ragtime {:migrations ragtime.sql.files/migrations
                 :database "jdbc:h2:./resources/db/development"}}
 :test {:jvm-opts ["-Dlogfile.name=test.log"]
        :env {:clj-env "test"
              :db-classname "org.j2.Driver"
              :db-subprotocol "h2"
              :db-subname "./resources/db/test"}
        :dependencies [[ring/ring-mock "0.2.0"]
                       [speclj "3.1.0"]]
        :ragtime {:migrations ragtime.sql.files/migrations
                  :database "jdbc:h2:./resources/db/test"}}}
