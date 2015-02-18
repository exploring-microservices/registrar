(ns registrar.deployments.fetcher-spec
  (:require [speclj.core :refer [around after context describe
                                 it should= should-contain should-be-nil]]
            [korma.core :refer [insert values]]
            [spec-helper :refer [with-transactions]]
            [registrar.deployments.fetcher :refer :all]))

(describe "registrar.deployments.fetcher"
  (with-transactions)

  (defn create-deployment [data]
    (insert :deployments (values data)))

  (context "/fetch-all"
    (it "returns an empty list when no deployments exist"
      (should= [] (fetch-all)))

    (it "returns a list which includes a newly created deployment"
      (let [uuid "00000000-0000-0000-0000-000000000000"]
        (create-deployment {:id uuid :name "website.com"})

        (let [deployments (fetch-all)
              deployment (first deployments)]
          (should= 1 (count deployments))
          (should= uuid (:id deployment))
          (should= "website.com" (:name deployment))))))

  (context "fetch-by-id"
    (it "returns an empty map when no deployment exists"
      (should-be-nil (fetch-by-id "id")))

    (it "returns a newly created deployment"
      (let [uuid "00000000-0000-0000-0000-000000000001"
            data {:id uuid :name "website.com"}]
        (create-deployment data)

        (let [deployment (fetch-by-id uuid)]
          (should= deployment data))))))
