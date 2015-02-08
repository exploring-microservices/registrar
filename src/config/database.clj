(ns config.database
  (:require [environ.core :refer [env]]
            [korma.db :refer :all]))


(defdb db {:classname (env :db-classname)
           :subprotocol (env :db-subprotocol)
           :subname (env :db-subname)})
