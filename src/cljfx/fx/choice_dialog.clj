(ns cljfx.fx.choice-dialog
  (:require [cljfx.composite :as composite]
            [cljfx.fx.dialog :as fx.dialog]
            [cljfx.lifecycle :as lifecycle])
  (:import [javafx.scene.control ChoiceDialog]))

(set! *warn-on-reflection* true)

(def props
  (merge
    fx.dialog/props
    (composite/props ChoiceDialog
      :items [:list lifecycle/scalar]
      :selected-item [:setter lifecycle/scalar])))

(def lifecycle
  (-> (composite/describe ChoiceDialog
        :ctor []
        :props props)
      (lifecycle/wrap-on-delete #(.hide ^ChoiceDialog %))))
