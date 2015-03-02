(ns registrar.deployments.creator-spec
  (:require [speclj.core :refer [context describe it
                                 should= should-not-be-nil]]
            [spec-helper :refer [with-transactions]]
            [registrar.deployments.creator :refer :all]
            [registrar.deployments.fetcher :as fetcher]))

(describe "registrar.deployments.creator"
  (with-transactions)

  (context "/create"
    (it "returns the newly created deployment"
      (let [deployment (create {:name "website.com"})]
        (should= "website.com" (:name deployment))
        (should-not-be-nil (:id deployment))))

    (it "persists the newly created deployment"
      (let [deployment (create {:name "website.com"})
            found-deployment (fetcher/fetch-by-id (:id deployment))]
        (should= deployment found-deployment)))))
