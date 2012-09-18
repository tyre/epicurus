(ns epicurus.views.event

 (:require
  [noir.response :as response]
  [epicurus.models.key :as key-model])

 (:use [noir.core :only [defpage]]
  [hiccup.core :only [html]]))

(defpage "/generate/event" {:keys [app-name event-name time] :as key-map}
 (response/json
  {:key (key-model/build-key :event key-map)}))

(defpage "/generate/event/unread" {:keys [app-name event-name] :as key-map}
 (response/json
  {:key (key-model/build-key :unread-for-event key-map)}))

(defpage "/generate/event-range" {:keys [app-name event-name start-time end-time] :as key-map}
   (response/json
    {:key (key-model/build-keys :event-range key-map)}))
