(ns registrar.util)

(defn uuid []
  (str (java.util.UUID/randomUUID)))
