(ns epicurus.models.riak-model
 (:require [clojure.string :as string]))

;; key-map has availible:
;     app-name
;     agent-id          --uniq against other agents
;     event-name
;     entity-id
;     variation-ids     --vector
;     time              --Integer (ms)
;     session-id        --non-uniq amongst agent

(defn build-riak-key [key-map]
 (string/join "/" [
  (:app-name key-map)
  (:agent-id key-map)
  (:session-id key-map)
  (:entity-id key-map)
  (:event-name key-map)
  (str (:time key-map))]))

(defn build-riak-bucket [key-map]
 (str
  (:app-name key-map)))

(defn build-key [type key-map]
 (case type
  :key (build-riak-key key-map)
  :bucket (build-riak-bucket key-map)))