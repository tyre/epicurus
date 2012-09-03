(ns epicurus.test.key
  (:use [epicurus.models.key])
  (:use [clojure.test]))

(deftest build-key-for-event
 (is
  (= "Facebook-pageView-4871324"
   (build-key :event
    {:app-name "Facebook" :event-name "pageView" :time 4871324}))))

(deftest build-key-for-unread-event
 (is
  (= "Facebook-pageView-KEYS-UNREAD"
   (build-key :unread-for-event
    {:app-name "Facebook" :event-name "pageView"}))))

(deftest build-key-for-unread-events-keys
 (is
  (= "Facebook-EVENTS-KEYS-UNREAD"
   (build-key :unread-events
    {:app-name "Facebook"}))))

(deftest build-keys-for-event-range
 (is
  (= ["Facebook-pageView-4871324" "Facebook-pageView-4871325" "Facebook-pageView-4871326"]
   (build-keys :event-range
    {:app-name "Facebook" :event-name "pageView" :start-time 4871324 :end-time 4871326}))))