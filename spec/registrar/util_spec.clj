(ns registrar.util-spec
  (:require [speclj.core :refer [context describe it
                                 should-contain should-not-be-same]]
            [registrar.util :refer :all]))

(describe "registrar.util"
  (context "/uuid"
    (it "returns a UUID string with 8-4-4-4-12 format"
      (should-contain #"\w{8}-\w{4}-\w{4}-\w{4}-\w{12}"
                      (uuid)))

    (it "returns a different string when invoked twice"
      (should-not-be-same (uuid) (uuid)))))
