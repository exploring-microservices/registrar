(ns registrar.core-spec
  (:require [speclj.core :refer [context describe it should=]]
            [ring.mock.request :refer [request]]
            [registrar.core :refer :all]))

(describe "registrar.core"
  (context "GET /foo"
    (it "responds with status of 200"
      (let [response (app (request :get "/foo"))]
        (should= 200 (:status response))))))
