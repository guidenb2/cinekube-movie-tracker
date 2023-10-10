(ns cinekube-movie-tracker.core
  (:require [cinekube-movie-tracker.server :as server])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Starting server...")
  (server/init-server))
