(ns cinekube-movie-tracker.configuration
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn])
  (:import (java.io PushbackReader)))


(defn read-config []
  (with-open [r (io/reader (.getFile (io/resource "config.edn")))]
    (edn/read (PushbackReader. r))))
