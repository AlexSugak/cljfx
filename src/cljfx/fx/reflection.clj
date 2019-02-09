(ns cljfx.fx.reflection
  (:require [cljfx.composite :as composite]
            [cljfx.lifecycle :as lifecycle])
  (:import [javafx.scene.effect Reflection]))

(set! *warn-on-reflection* true)

(def props
  (composite/props Reflection
    :input [:setter lifecycle/dynamic]
    :top-offset [:setter lifecycle/scalar :coerce double :default 0.0]
    :fraction [:setter lifecycle/scalar :coerce double :default 0.75]
    :top-opacity [:setter lifecycle/scalar :coerce double :default 0.5]
    :bottom-opacity [:setter lifecycle/scalar :coerce double :default 0.0]))

(def lifecycle
  (composite/describe Reflection
    :ctor []
    :props props))
