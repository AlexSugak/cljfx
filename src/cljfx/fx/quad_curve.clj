(ns cljfx.fx.quad-curve
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.fx.shape :as fx.shape])
  (:import [javafx.scene.shape QuadCurve]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.shape/props
    (lifecycle.composite/props QuadCurve
      :control-x [:setter lifecycle/scalar :coerce double :default 0.0]
      :control-y [:setter lifecycle/scalar :coerce double :default 0.0]
      :end-x [:setter lifecycle/scalar :coerce double :default 0.0]
      :end-y [:setter lifecycle/scalar :coerce double :default 0.0]
      :start-x [:setter lifecycle/scalar :coerce double :default 0.0]
      :start-y [:setter lifecycle/scalar :coerce double :default 0.0])))

(def lifecycle
  (lifecycle.composite/describe QuadCurve
    :ctor []
    :props props))
