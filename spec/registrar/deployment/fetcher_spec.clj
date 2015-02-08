(ns registrar.deployment.fetcher-spec
  (:require [speclj.core :refer [around after context describe
                                 it should= should-contain]]
            [korma.core :refer [insert values]]
            [spec-helper :refer [with-transactions]]
            [registrar.deployment.fetcher :refer :all]))

(describe "registrar.deployment.fetcher"
  (with-transactions)

  (context "/fetch-all"
    (defn create-deployment [data]
      (insert :deployments (values data)))

    (it "returns an empty list when no deployments exist"
      (should= [] (fetch-all)))

    (it "returns a newly created deployment"
      (let [uuid "00000000-0000-0000-0000-000000000000"]
        (create-deployment {:id uuid :name "website.com"})

        (let [deployments (fetch-all)
              deployment (first deployments)]
          (should= 1 (count deployments))
          (should= uuid (:id deployment))
          (should= "website.com" (:name deployment)))))))
