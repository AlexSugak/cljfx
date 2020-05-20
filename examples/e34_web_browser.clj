(ns e34-web-browser
  (:require [cljfx.api :as fx]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.mutator :as mutator]
            [cljfx.prop :as prop]))

;; A simple web browser
;; ====================
;;
;; This example requires one additional property from web-view in order to understand when a link on a web page has been
;; clicked. See the README.md and e21-extension-lifecycle for some additional examples of this.

(def web-view-with-ext-props
  (cljfx.api/make-ext-with-props
    {:on-location-changed (prop/make (mutator/property-change-listener
                                             #(.locationProperty (.getEngine %)))
                                           cljfx.lifecycle/change-listener)}))
;; A well known URL
(def home-url "https://www.google.com")

;; The strategy here is to have a partial-url associated with the text field so that typing into the text field
;; does not act as a URL until the return button is pressed. The resulting url is checked to see if the (usually omitted)
;; http:// is prepended, if not - it adds it then loads the web-view vis the :url keyword.

(def *state (atom {::partial-url home-url
                   ::current-url home-url}))

(defn top-pane [{:keys [state]}]
  {:fx/type  :h-box
   :spacing  5
   :children [{:fx/type   :button
               :text      "Home"
               :on-action {:event/type ::home}}
              {:fx/type         :text-field
               :h-box/hgrow     :always
               :text            (::partial-url state)
               :on-text-changed {:event/type ::url-change}
               :on-action       {:event/type ::url-complete}}]})

;; The web-pane function returns the extended web-view that has the additional property :on-location-changed installed.
(defn web-pane [{:keys [state]}]
  {:fx/type web-view-with-ext-props
   :desc    {:fx/type     :web-view
             :pref-height 1000
             :pref-width  1500
             :url         (::current-url state)}
   :props   {:on-location-changed {:event/type ::url-change}}})

  (defn body-pane [{:keys [state]}]
    {:fx/type  :v-box
     :padding  10
     :spacing  10
     :children [{:fx/type top-pane
                 :state   state}
                {:fx/type web-pane
                 :state   state}]})

(defn root [state]
    {:fx/type :stage
     :showing true
     :title   "Simple web browser"
     :scene   {:fx/type :scene
               :root    {:fx/type body-pane :state state}}})

  (defn normalise [s]
    (let [omitted "http://"]
      (if (clojure.string/starts-with? s omitted)
        s
        (str omitted s))))

  (defn event-handler [event]
    (case (:event/type event)
      ::home (reset! *state {::partial-url home-url
                             ::current-url home-url})
      ::url-change (do (prn (:fx/event event)) (swap! *state assoc ::partial-url (:fx/event event)))
      ::url-complete (swap! *state assoc ::current-url (-> @*state ::partial-url normalise))))

  (def renderer
    (fx/create-renderer
      :middleware (fx/wrap-map-desc assoc :fx/type root)
      :opts {:fx.opt/map-event-handler event-handler}))

  (fx/mount-renderer *state renderer)
