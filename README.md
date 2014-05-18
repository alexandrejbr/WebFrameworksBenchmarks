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
RestExpress: ....................  56102.12
Spray: ..........................  55735.21
Play Framework (spray): .........  44483.06
Clojure http-kit ................  38907.40
Play Framework: .................  38015.35
Node.js: ........................  25835.20

```

## Plain Text Scores:
```
---------------------------------  --------
Clojure http-kit ................  64745.66
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
RestExpress: ....................  0
Spray: ..........................  0
Play Framework (spray): .........  0
Clojure http-kit ................  0
Play Framework: .................  0
Node.js: ........................  0

```

## Plain Text Scores:
```
---------------------------------  --------
Clojure http-kit ................  0
Spray: ..........................  0
RestExpress: ....................  0
Play Framework: .................  0
Node.js: ........................  0

```