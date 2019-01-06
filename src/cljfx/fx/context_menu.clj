(ns cljfx.fx.context-menu
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.fx.popup-control :as fx.popup-control]
            [cljfx.coerce :as coerce])
  (:import [javafx.scene.control ContextMenu]))

(def lifecycle
  (lifecycle.composite/describe ContextMenu
    :ctor []
    :extends [fx.popup-control/lifecycle]
    :props {;; overrides
            :style-class [:list lifecycle/scalar :coerce coerce/style-class
                          :default "context-menu"]
            :auto-hide [:setter lifecycle/scalar :default true]
            :consume-auto-hiding-events [:setter lifecycle/scalar :default false]
            ;; definitions
            :items [:list lifecycle/dynamics]
            :on-action [:setter lifecycle/event-handler :coerce coerce/event-handler]}))