(ns cljfx.fx.indexed-cell
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.fx.cell :as fx.cell]
            [cljfx.coerce :as coerce]
            [cljfx.lifecycle :as lifecycle])
  (:import [javafx.scene.control IndexedCell]))

(set! *warn-on-reflection* true)

(def lifecycle
  (lifecycle.composite/describe IndexedCell
    :ctor []
    :extends [fx.cell/lifecycle]
    :props {;; overrides
            :style-class [:list lifecycle/scalar :coerce coerce/style-class
                          :default ["cell" "indexed-cell"]]}))
