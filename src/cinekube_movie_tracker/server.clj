(ns cinekube-movie-tracker.server
  (:require [com.appsflyer.donkey.core :refer [create-donkey create-server]]
            [com.appsflyer.donkey.server :refer [start]]
            [com.appsflyer.donkey.result :refer [on-success]]
            [cinekube-movie-tracker.configuration :as config]
            [reitit.ring :as ring]))

(defn handler [_]
  {:status 200, :content-type "application/json", :body (str {:currently-watching ["Gangs of New York" "Goodfellas"]})})

(def app
  (ring/ring-handler
    (ring/router
      [["/watching" {:get handler}]])))

(defn init-server []
  (let [config (config/read-config)]
    (->
      (create-donkey)
      (create-server {:port (:port config)
                      :routes [{:handler app
                                :handler-mode :blocking}]})
      start
      (on-success (fn [_] (println "Server started listening on port" (:port config)))))))
