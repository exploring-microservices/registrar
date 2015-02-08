(ns registrar.deployment.creator-spec
  (:require [speclj.core :refer [context describe it
                                 should= should-not-be-nil]]
            [spec-helper :refer [with-transactions]]
            [registrar.deployment.creator :refer :all]))

(describe "registrar.deployment.creator"
  (with-transactions)

  (context "/create"
    (it "returns the newly created deployment"
      (let [deployment (create {:name "website.com"})]
        (should= "website.com" (:name deployment))
        (should-not-be-nil (:id deployment))))))
