(ns epicurus.test.key
  (:use [epicurus.models.key])
  (:use [clojure.test]))

(deftest build-key-for-event-with-string
 (is
  (= "Facebook-pageView-4871324"
   (build-key :event
    {:app-name "Facebook" :event-name "pageView" :time "4871324"}))))

(deftest build-key-for-event-with-int
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

(deftest build-keys-for-event-range-with-strings
 (is
  (= ["Facebook-pageView-4871324" "Facebook-pageView-4871325" "Facebook-pageView-4871326"]
   (build-keys :event-range
    {:app-name "Facebook" :event-name "pageView" :start-time "4871324" :end-time "4871326"}))))

(deftest build-keys-for-event-range-with-ints
 (is
  (= ["Facebook-pageView-4871324" "Facebook-pageView-4871325" "Facebook-pageView-4871326"]
   (build-keys :event-range
    {:app-name "Facebook" :event-name "pageView" :start-time 4871324 :end-time 4871326}))))

(deftest event-range-with-time-scale-seconds
 (is
  (= 4
  (count (build-keys :event-range
   {:app-name "Walrus" :event-name "Bubbles" :start-time "481516000" :end-time "481519000" :time-unit "seconds"})))))

(deftest event-range-with-time-scale-seconds-and-time-step
 (is
  (= 3
  (count (build-keys :event-range
   {:app-name "Walrus" :event-name "Bubbles" :start-time "481516000" :end-time "481520000" :time-unit "seconds" :time-scale "2"})))))

(deftest event-range-with-time-step-as-int
 (is
  (= 3
  (count (build-keys :event-range
   {:app-name "Walrus" :event-name "Bubbles" :start-time "481516000" :end-time "481520000" :time-unit "seconds" :time-scale 2})))))


