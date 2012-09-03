(ns epicurus.views.event

 (:require
  [noir.response :as response]
  [epicurus.models.key :as key-model])

 (:use [noir.core :only [defpage]]
  [hiccup.core :only [html]]
  ))

(defpage "/gen-key/event" {:keys [app-name event-name time] :as key-map}
 (response/json
  {:key (key-model/build-key :event key-map)}))