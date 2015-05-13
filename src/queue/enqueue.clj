(ns queue.enqueue
  (:require [clojure.data.json :as json]
            [environ.core :refer [env]]
            [langohr.core :as langohr]
            [langohr.channel :as channel]
            [langohr.queue :as queue]
            [langohr.basic :as basic]))

(defn enqueue [queue-name data]
  (let [connection (langohr/connect {:uri (env :queue-uri)})
        channel (channel/open connection)
        default-exchange-name ""]
    (queue/declare channel queue-name {:durable true :auto-delete false})
    (basic/publish channel default-exchange-name queue-name (json/write-str data) {:content-type "application/json" :persistent true :durable true})
    (langohr/close channel)
    (langohr/close connection)))
