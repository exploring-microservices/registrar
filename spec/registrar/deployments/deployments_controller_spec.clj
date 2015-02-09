(ns registrar.deployments.deployments-controller-spec
  (:require [speclj.core :refer [context describe it should= should-contain
                                 with-stubs stub should-have-invoked]]
            [ring.util.response :refer [get-header]]
            [ring.mock.request :refer [request body]]
            [registrar.deployments.fetcher :as fetcher]
            [registrar.deployments.creator :as creator]
            [registrar.deployments.deployments-controller :refer :all]))

(describe "registrar.deployments.deployments-controller"
  (with-stubs)

  (context "GET /"
    (it "responds with status of 200 and application/json content-type"
      (with-redefs [fetcher/fetch-all (constantly nil)]
        (let [response (routes (request :get "/"))
              content-type (get-header response "content-type")]
          (should= 200 (:status response))
          (should-contain "application/json" content-type))))

    (it "calls fetcher/fetch-all"
      (with-redefs [fetcher/fetch-all (stub :fetch-all)]
        (routes (request :get "/"))
        (should-have-invoked :fetch-all))))

  (context "POST /"
    (defn make-request [& params]
      (merge (request :post "/") {:params (first params)}))

    (it "responds with status of 200 and application/json content-type"
      (with-redefs [creator/create (constantly nil)]
        (let [response (routes (make-request))
              content-type (get-header response "content-type")]
          (should= 201 (:status response))
          (should-contain "application/json" content-type))))

    (it "calls creator/create with params"
      (with-redefs [creator/create (stub :create)]
        (routes (make-request {:name "website.com"}))
        (should-have-invoked :create {:with [{:name "website.com"}]})))))
