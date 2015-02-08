(ns registrar.deployment.fetcher
  (:require [config.database]
            [korma.core :refer :all]))

(defn fetch-all []
  (select :deployments))
