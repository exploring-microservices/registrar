(ns registrar.core
  (:require [liberator.core         :refer [resource defresource]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json   :refer [wrap-json-params]]
            [compojure.core         :refer [defroutes context ANY GET]]
            [registrar.deployment.deployment-controller :as deployment-controller]))

(defroutes app
  (context "/deployment" [] deployment-controller/routes)
  (GET "/foo" [] (resource :available-media-types ["application/json"]
                           :handle-ok {:hello :world})))

(def handler
  (-> app
      wrap-json-params
      wrap-params))
