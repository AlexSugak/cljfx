(ns cljfx.fx.text-flow
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce]
            [cljfx.fx.pane :as fx.pane])
  (:import [javafx.scene.text TextFlow TextAlignment]
           [javafx.scene AccessibleRole]))

(def lifecycle
  (lifecycle.composite/describe TextFlow
    :ctor []
    :extends [fx.pane/lifecycle]
    :props {;; overrides
            :accessible-role [:setter lifecycle/scalar :coerce (coerce/enum AccessibleRole)
                              :default :text]
            ;; definitions
            :line-spacing [:setter lifecycle/scalar :coerce double :default 0.0]
            :text-alignment [:setter lifecycle/scalar :coerce (coerce/enum TextAlignment)
                             :default :left]}))