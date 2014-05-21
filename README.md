# Mac OS X tests

Setup:
- Mac OS X 10.9.3
- Intel core i5-4288U
- 16 GB RAM

```
wrk -t 2 -c 100 --latency -d 60s <URL>
```

## JSON Scores:
```
---------------------------------  --------
Clojure http-kit clj-json .......  63540.95
Clojure http-kit chesire ........  62368.80
Spray-can-only-fp: ..............  60920.00 (*)
Spray-can-only: .................  60402.64
RestExpress: ....................  56102.12
Spray: ..........................  55735.21
Play Framework (spray-json): ....  44483.06
Clojure http-kit stock ..........  38664.36
Play Framework: .................  38015.35
Node.js: ........................  25835.20

```

## Plain Text Scores:
```
---------------------------------  --------
Clojure http-kit ................  65020.83
Spray-can-only-fp: ..............  62759.70 (*)
Spray-can-only: .................  62513.67
Spray: ..........................  62014.54
RestExpress: ....................  59597.06
Play Framework: .................  50746.09
Node.js: ........................  28926.99

```

# Ubuntu

Setup:
- Ubuntu 14.04 LTS
- Intel core i7-2720QM
- 16 GB RAM

```
wrk -t 4 -c 100 --latency -d 60s <URL>
```

## JSON Scores:
```
---------------------------------  --------
Spray-can-only-fp: ..............  111777.46 (*)
Spray-can-only: .................  106569.73
Spray: ..........................  97620.83
Play Framework (spray-json): ....  72072.42
Clojure http-kit ................  64607.17 (!!!)
RestExpress: ....................  63251.98 (!!!)
Play Framework: .................  50907.89
Node.js: ........................  42727.68

```

## Plain Text Scores:
```
---------------------------------  --------
Spray-can-only-fp: ..............  144685.13 (*)
Spray-can-only: .................  137590.83
Spray: ..........................  131394.28
Clojure http-kit ................  100372.60 (!!!)
Play Framework: .................  91196.91
RestExpress: ....................  70793.38 (!!!)
Node.js: ........................  47306.06

```
(!!!) test not using all CPU power

(*) this test run using fastpath, which uses directly conection actor avoiding message passing to the handler actor. [See more](https://groups.google.com/forum/#!searchin/spray-user/fastpath/spray-user/ovWhZy8vxtU/7o-HLl1j_9oJ)
