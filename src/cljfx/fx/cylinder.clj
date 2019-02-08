(ns cljfx.fx.cylinder
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.lifecycle :as lifecycle]
            [cljfx.fx.shape3d :as fx.shape3d])
  (:import [javafx.scene.shape Cylinder]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.shape3d/props
    (lifecycle.composite/props Cylinder
      :height [:setter lifecycle/scalar :coerce double :default 2.0]
      :radius [:setter lifecycle/scalar :coerce double :default 1.0])))

(def lifecycle
  (lifecycle.composite/describe Cylinder
    :ctor []
    :props props))
