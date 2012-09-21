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

(def time-map {
  :milliseconds 1
  :seconds      1000
  :minutes      60000
  :hours        3600000
  :days         86400000
  })

(defn parse-int [maybe-int]
 (if (nil? maybe-int)
  nil
 (Integer/parseInt (str maybe-int))))

(defn build-event-key [key-map]
 (string/join "-" [(key-map :app-name) (key-map :event-name) (str (key-map :time))]))

(defn build-event-range [key-map]
 (loop [
  start-time (parse-int (key-map :start-time))
  acc []]
  (if (> start-time (parse-int (key-map :end-time)))
   acc
   (recur (+ start-time (* (or (parse-int (key-map :time-scale)) 1) (get time-map (keyword (key-map :time-range)) 1)))
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



