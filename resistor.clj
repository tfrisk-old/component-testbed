;RESISTOR

;Generic resistor calculation
;in: v=voltage, i=current, r=resistance
;out: p=power, vd=voltage drop on component
(defn res_calculate [params]
  (let [voltage (get params :v) current (get params :i) resistance (get params :r)]
    (assoc params :p (* (* current current) resistance) :vd (* resistance current))
  ))

(defn res_parallel [s1 s2]
  ;resistors in parallel: 1/(1/s1 + 1/s2)
  (/ 1 (+ (/ 1 s1) (/ 1 s2))))

(defn res_series [s1 s2]
  ;resistors in series: s1 + s2
  (+ s1 s2))

;CAPACITOR

;Generic capacitor calculation
;in: v=voltage, i=current, c=capacitance
;out: q=charge
(defn cap_calculate [params]
  (let [voltage (get params :v) current (get params :i) capacitance (get params :c)]
    (assoc params :q (/ capacitance voltage))
  ))

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

