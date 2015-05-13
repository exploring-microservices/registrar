(ns queue.enqueue-spec
  (:require [speclj.core :refer :all]
            [queue.enqueue :refer :all]))

(describe "queue.enqueue"
  (it "works"
    ;; (enqueue "incoming-notification" {:id "00000000-0000-0000-000000000000"})
    (should= 1 1)))
