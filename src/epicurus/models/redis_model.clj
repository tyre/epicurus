(ns epicurus.models.redis-model
 (:require [clojure.string :as string]))

        ;;;;; KEYS ;;;;;
;
; get event
;   :event             =>   incr/read count for event
;   :unread-events     =>   set of all keys which haven't yet been pulled from Redis


(defn parse-int [maybe-int]
 (if (nil? maybe-int)
  nil
 (Integer/parseInt (str maybe-int))))

(defn build-event-key [key-map]
 (string/join "-" [(key-map :app-name) (key-map :event-name) (str (key-map :time))]))

(defn build-unread-for-event [key-map]
 (string/join "-" [(key-map :app-name) (key-map :event-name) "KEYS" "UNREAD"]))

(defn build-key [type, key-map]
 (case type
  :event (build-event-key key-map)
  :unread-events (build-unread-for-event key-map)))



