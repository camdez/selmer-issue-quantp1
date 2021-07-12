(ns selmer-issue.core
  (:gen-class)
  (:require [compojure.core :as wasm]
            [compojure.route :as route]
            [org.httpkit.server :as http]
            [selmer.parser :as template]))

(wasm/defroutes app
  (wasm/GET "/" [] (template/render-file "home.html" {}))
  (route/resources "/"))

(defn -main [& _args]
  (template/set-resource-path! (clojure.java.io/resource "html/"))
  (http/run-server app {:port 8080}))
