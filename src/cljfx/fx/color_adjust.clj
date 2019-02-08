(ns cljfx.fx.color-adjust
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.lifecycle :as lifecycle])
  (:import [javafx.scene.effect ColorAdjust]))

(set! *warn-on-reflection* true)

(def props
  (lifecycle.composite/props ColorAdjust
    :input [:setter lifecycle/dynamic]
    :hue [:setter lifecycle/scalar :coerce double :default 0]
    :saturation [:setter lifecycle/scalar :coerce double :default 0]
    :brightness [:setter lifecycle/scalar :coerce double :default 0]
    :contrast [:setter lifecycle/scalar :coerce double :default 0]))

(def lifecycle
  (lifecycle.composite/describe ColorAdjust
    :ctor []
    :props props))
