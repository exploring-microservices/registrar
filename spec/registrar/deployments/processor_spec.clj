(ns registrar.deployments.processor-spec
  (:require [speclj.core :refer [context describe it should=]]
            [spec-helper :refer [with-transactions]]
            [registrar.deployments.processor :refer :all]
            [registrar.deployments.creator :as creator]))

(describe "registrar.deployments.processor"
  (with-transactions)

  (context "/process"
    (it "takes a deployment id and returns a hash with status: true"
      (let [id (:id (creator/create {:name "website.com"}))]
        (should= {:status true} (process id))))))
