(ns cljfx.fx.scroll-pane
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.coerce :as coerce]
            [cljfx.fx.control :as fx.control])
  (:import [javafx.scene.control ScrollPane ScrollPane$ScrollBarPolicy]
           [javafx.geometry Bounds BoundingBox]))

(defn- bounds [x]
  (cond
    (instance? Bounds x)
    x

    (= 0 x)
    (BoundingBox. 0.0 0.0 0.0 0.0 0.0 0.0)

    (and (vector? x) (= 4 (count x)))
    (let [[x y w h] x]
      (BoundingBox. x y w h))

    (and (vector? x) (= 6 (count x)))
    (let [[x y z w h d] x]
      (BoundingBox. x y z w h d))

    :else
    (coerce/fail Bounds x)))

(def lifecycle
  (lifecycle.composite/describe ScrollPane
    :ctor []
    :extends [fx.control/lifecycle]
    :props {:content [:setter lifecycle/dynamic]
            :fit-to-height [:setter lifecycle/scalar :default false]
            :fit-to-width [:setter lifecycle/scalar :default false]
            :hbar-policy [:setter lifecycle/scalar
                          :coerce (coerce/enum ScrollPane$ScrollBarPolicy)
                          :default :as-needed]
            :hmax [:setter lifecycle/scalar :coerce double :default 1.0]
            :hmin [:setter lifecycle/scalar :coerce double :default 0.0]
            :hvalue [:setter lifecycle/scalar :coerce double :default 0.0]
            :min-viewport-height [:setter lifecycle/scalar :coerce double :default 0.0]
            :min-viewport-width [:setter lifecycle/scalar :coerce double :default 0.0]
            :pannable [:setter lifecycle/scalar :default false]
            :pref-viewport-height [:setter lifecycle/scalar :coerce double :default 0.0]
            :pref-viewport-width [:setter lifecycle/scalar :coerce double :default 0.0]
            :vbar-policy [:setter lifecycle/scalar
                          :coerce (coerce/enum ScrollPane$ScrollBarPolicy)
                          :default :as-needed]
            :viewport-bounds [:setter lifecycle/scalar :coerce bounds :default 0]
            :vmax [:setter lifecycle/scalar :coerce double :default 1.0]
            :vmin [:setter lifecycle/scalar :coerce double :default 0.0]
            :vvalue [:setter lifecycle/scalar :coerce double :default 0.0]}))