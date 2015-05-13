(ns registrar.worker
  (:require [clojure.data.json :as json]
            [environ.core :refer [env]]
            [langohr.core :as langohr]
            [langohr.channel :as channel]
            [langohr.queue :as queue]
            [langohr.basic :as basic]
            [langohr.consumers :as consumers]))

(defn -main [& args]
  (let [connection (langohr/connect {:uri (env :queue-uri)})
        channel (channel/open connection)
        queue-name "incoming-notification"
        handler (fn [channel {:keys [delivery-tag]} ^bytes payload]
                  (Thread/sleep 2000)
                  (println (format "[consumer] Received %s" (String. payload "UTF-8")))
                  (basic/ack channel delivery-tag))]
    (queue/declare channel queue-name {:durable true :auto-delete false})
    (basic/qos channel 1)
    (consumers/subscribe channel queue-name handler)))
