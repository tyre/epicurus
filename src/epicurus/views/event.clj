(ns epicurus.views.event

 (:require
  [noir.response :as response])

 (:use [noir.core :only [defpage]]
  [hiccup.core :only [html]]))

(defn build-key-fn [app-name]
   (let [the-ns (symbol (str "epicurus.models." app-name "-model"))]
      (require the-ns)
      (ns-resolve the-ns 'build-key)))

(defpage "/:backend/generate/event" {:keys [backend app-name event-name time] :as key-map}
 (response/json
  {:key ((build-key-fn backend) :event key-map)}))

(defpage "/:backend/generate/event/unread" {:keys [backend app-name event-name] :as key-map}
 (response/json
  {:key ((build-key-fn backend) :unread-for-event key-map)}))

(defpage "/:backend/generate/event-range" {:keys [backend app-name event-name start-time end-time time-unit time-scale] :as key-map}
   (response/json
    {:key ((build-key-fn backend) :event-range key-map)}))
