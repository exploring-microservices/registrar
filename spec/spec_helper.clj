(ns spec-helper
  (:require [speclj.core :refer :all]
            [korma.db :refer [transaction rollback]]))

(defn request [handler method uri & params]
  (handler {:request-method method :uri uri :params (first params)}))

(defn with-transactions []
  (around [it]
    (transaction
      (it)
      (rollback))))
