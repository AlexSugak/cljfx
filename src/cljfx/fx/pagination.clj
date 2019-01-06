(ns cljfx.fx.pagination
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce]
            [cljfx.fx.control :as fx.control])
  (:import [javafx.scene.control Pagination]
           [javafx.util Callback]))

(defn- page-factory [x]
  (cond
    (instance? Callback x)
    x

    (fn? x)
    (reify Callback
      (call [_ param]
        (x param)))

    :else
    (coerce/fail Callback x)))

(def lifecycle
  (lifecycle.composite/describe Pagination
    :ctor []
    :extends [fx.control/lifecycle]
    :props {:current-page-index [:setter lifecycle/scalar :coerce int :default 0]
            :max-page-indicator-count [:setter lifecycle/scalar :coerce int :default 10]
            :page-count [:setter lifecycle/scalar :coerce int :default Integer/MAX_VALUE]
            :page-factory [:setter (lifecycle/wrap-factory lifecycle/dynamic)
                           :coerce page-factory]}))