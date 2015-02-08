{:dev {:env {:clj-env "dev"
             :db-classname "org.j2.Driver"
             :db-subprotocol "h2"
             :db-subname "./resources/db/dev"}
       :ragtime {:migrations ragtime.sql.files/migrations
                 :database "jdbc:h2:./resources/db/dev"}}
 :test {:env {:clj-env "test"
              :db-classname "org.j2.Driver"
              :db-subprotocol "h2"
              :db-subname "./resources/db/test"}
        :dependencies [[ring/ring-mock "0.2.0"]
                       [speclj "3.1.0"]]
        :ragtime {:migrations ragtime.sql.files/migrations
                  :database "jdbc:h2:./resources/db/test"}}}
