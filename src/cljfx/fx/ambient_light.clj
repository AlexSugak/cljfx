(ns cljfx.fx.ambient-light
  (:require [cljfx.lifecycle.composite :as lifecycle.composite]
            [cljfx.fx.light-base :as fx.light-base])
  (:import [javafx.scene AmbientLight]))

(set! *warn-on-reflection* true)

(def props
  fx.light-base/props)

(def lifecycle
  (lifecycle.composite/describe AmbientLight
    :ctor []
    :props props))
