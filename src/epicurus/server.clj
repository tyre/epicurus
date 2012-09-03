(ns epicurus.server
  (:require [noir.server :as server])
  (:require [epicurus.settings :as settings]))

(server/load-views "src/epicurus/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (get settings/settings-map :port 7737)]
    (server/start port {:mode mode
                        :ns 'epicurus})))

