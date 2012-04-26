;RESISTOR

;Generic resistor calculation
;in: v=voltage, i=current, r=resistance
;out: p=power, vd=voltage change
(defn res_calculate [params]
  (let [voltage (get params :v) current (get params :i) resistance (get params :r)]
    (assoc params :p (* voltage current))
    (assoc params :vd (* resistance current))
  ))

(defn res_parallel [s1 s2]
  ;resistors in parallel: 1/(1/s1 + 1/s2)
  (/ 1 (+ (/ 1 s1) (/ 1 s2))))

(defn res_series [s1 s2]
  ;resistors in series: s1 + s2
  (+ s1 s2))

;CAPACITOR

(defn cap_parallel [s1 s2]
  ;capacitors in parallel: s1 + s2
  (+ s1 s2))

(defn cap_series [s1 s2]
  ;capacitors in series: 1/(1/s1 + 1/s2)
  (/ 1 (+ (/ 1 s1) (/ 1 s2))))

;INDUCTOR

(defn ind_parallel [s1 s2]
  ;inductors in parallel: 1/(1/s1 + 1/s2)
  (/ 1 (+ (/ 1 s1) (/ 1 s2))))

(defn ind_series [s1 s2]
  ;inductors in series: s1 + s2
  (+ s1 s2))

