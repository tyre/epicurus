(ns epicurus.views.event

 (:require
  [noir.response :as response]
  [epicurus.models.key :as key-model])

 (:use [noir.core :only [defpage]]
  [hiccup.core :only [html]]))

(defpage "/generate/event" {:keys [app-name event-name time] :as key-map}
 (println "CREATING KEY FOR:")
 (println (str "  app-name: " app-name))
 (println (str "  event-name: " event-name))
 (println (str "  time: " time))
 (response/json
  {:key (key-model/build-key :event key-map)}))

(defpage "/generate/event-range" {:keys [app-name event-name start-time end-time] :as key-map}
   (response/json
    {:key (key-model/build-keys :event-range key-map)}))
