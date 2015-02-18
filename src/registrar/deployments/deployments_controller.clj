(ns registrar.deployments.deployments-controller
  (:require [liberator.core     :refer [resource]]
            [compojure.core     :refer [defroutes GET POST]]
            [clojure.walk       :refer [keywordize-keys]]
            [registrar.deployments.fetcher :as fetcher]
            [registrar.deployments.creator :as creator]))

(defroutes routes
  (GET "/" [] (resource
                :available-media-types ["application/json"]
                :handle-ok (fn [_] (fetcher/fetch-all))))

  (POST "/" {params :params}
        (resource
          :allowed-methods [:post]
          :available-media-types ["application/json"]
          :handle-created (fn [_] (creator/create (keywordize-keys params)))))

  (GET "/:id" [id]
        (resource
          :available-media-types ["application/json"]
          :handle-ok (fn [_] (fetcher/fetch-by-id id)))))
