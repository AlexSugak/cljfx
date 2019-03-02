(ns cljfx.fx.tree-item
  "Part of a public API"
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce])
  (:import [javafx.scene.control TreeItem]))

(set! *warn-on-reflection* true)

(def props
  (composite/props TreeItem
    :children [:list lifecycle/dynamics]
    :expanded [:setter lifecycle/scalar :default false]
    :on-expanded-changed [:property-change-listener
                          (lifecycle/wrap-coerce lifecycle/event-handler
                                                 coerce/change-listener)]
    :graphic [:setter lifecycle/dynamic]
    :value [:setter lifecycle/scalar]))

(def lifecycle
  (composite/describe TreeItem
    :ctor []
    :props props))
