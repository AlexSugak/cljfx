(ns cljfx.fx.tool-bar
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce]
            [cljfx.fx.control :as fx.control])
  (:import [javafx.scene.control ToolBar]
           [javafx.geometry Orientation]
           [javafx.scene AccessibleRole]))

(set! *warn-on-reflection* true)

(def lifecycle
  (lifecycle.composite/describe ToolBar
    :ctor []
    :extends [fx.control/lifecycle]
    :props {;; overrides
            :style-class [:list lifecycle/scalar :coerce coerce/style-class :default "tool-bar"]
            :accessible-role [:setter lifecycle/scalar :coerce (coerce/enum AccessibleRole)
                              :default :tool-bar]
            ;; definitions
            :items [:list lifecycle/dynamics]
            :orientation [:setter lifecycle/scalar
                          :coerce (coerce/enum Orientation)
                          :default :horizontal]}))