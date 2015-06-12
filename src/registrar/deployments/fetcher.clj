(ns registrar.deployments.fetcher
  (:require [config.database]
            [korma.core :refer :all]))

(defn fetch-all []
  (select :deployments))

(defn fetch-by-id [id]
  (first
    (select :deployments
            (where {:id id})
            (limit 1))))
