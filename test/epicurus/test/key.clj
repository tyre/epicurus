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
   (build-key :unread-events
    {:app-name "Facebook" :event-name "pageView"}))))
