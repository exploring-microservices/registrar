(ns registrar.deployments.creator
  (:require [config.database]
            [korma.core :refer :all]))

(defn uuid []
  (str (java.util.UUID/randomUUID)))

(defn create [data]
  (let [data (merge data {:id (uuid)})]
    (insert :deployments (values data))
    data))
