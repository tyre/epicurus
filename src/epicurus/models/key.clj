(ns epicurus.models.key
 (:require [clojure.string :as string]))

        ;;;;; KEYS ;;;;;
;
; get event
;   :event             =>   incr/read count for event
;   :event-range       =>   event keys from :start-time to :end-time (inclusive)
;   :unread-for-event  =>   set of all keys for an event which haven't yet been pulled from Redis
;   :unread-events     =>   set of keys which hold sets of particular events keys
;
;
;
;
;

(defn build-event-key [key-map]
 (string/join "-" [(key-map :app-name) (key-map :event-name) (str (key-map :time))]))

(defn build-event-range [key-map]
 (loop [
  start-time (Integer/parseInt (key-map :start-time))
  acc []]
  (if (> start-time (Integer/parseInt (key-map :end-time)))
   acc
   (recur (inc start-time)
    (conj acc (build-event-key (merge {:time start-time} key-map)))))))

(defn build-unread-for-event [key-map]
 (string/join "-" [(key-map :app-name) (key-map :event-name) "KEYS" "UNREAD"]))

(defn build-unread-events-key [key-map]
 (string/join "-" [(key-map :app-name) "EVENTS" "KEYS" "UNREAD"]))

(defn build-key [type, key-map]
 (case type
  :event (build-event-key key-map)
  :unread-for-event (build-unread-for-event key-map)
  :unread-events (build-unread-events-key key-map)))

(defn build-keys [type, key-map]
 (case type
  :event-range (build-event-range key-map)))



