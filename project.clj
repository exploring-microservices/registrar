(defproject registrar "0.1.0-SNAPSHOT"
  :description "Site-builder registrar API"
  :url "https://github.com/exploring-microservices/registrar"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[com.h2database/h2 "1.4.185"]
                 [com.novemberain/langohr "3.1.0"]
                 [compojure "1.1.3"]
                 [environ "1.0.0"]
                 [korma "0.3.0"]
                 [liberator "0.12.0"]
                 [org.clojure/clojure "1.6.0"]
                 [ragtime/ragtime.sql.files "0.3.8"]
                 [ring/ring-core "1.2.1"]
                 [ring/ring-json "0.3.1"]
                 [log4j "1.2.15" :exclusions [javax.mail/mail
                                              javax.jms/jms
                                              com.sun.jdmk/jmxtools
                                              com.sun.jmx/jmxri]]]
  :ring {:handler registrar.core/handler}
  :plugins [[speclj "3.1.0"]
            [lein-environ "1.0.0"]
            [lein-ring "0.8.11"]
            [ragtime/ragtime.lein "0.3.8"]]
  :test-paths ["spec"]
  :aliases {"spec" ["with-profile" "test" "spec"]
            "db-migrate" ["ragtime" "migrate"]
            "db-rollback" ["ragtime" "rollback"]
            "db-reset" ["do" ["db-rollback"] ["db-migrate"]]})
