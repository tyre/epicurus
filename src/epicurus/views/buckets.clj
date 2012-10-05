(ns epicurus.views.buckets
 (:require
  [noir.response :as response])
 (:use [noir.core :only [defpage]]))

(defn build-key-fn [app-name]
 (let [the-ns (symbol (str "epicurus.models." app-name "-model"))]
  (require the-ns)
  (ns-resolve the-ns 'build-key)))

(defpage "/:backend/generate/bucket-and-key" {:keys [backend app-name] :as key-map}
 (response/json
  (let [key-fn (build-key-fn backend)]
   {:key (key-fn :key key-map)
     :bucket (key-fn :bucket key-map)})))